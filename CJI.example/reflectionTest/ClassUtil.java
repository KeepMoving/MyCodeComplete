package reflectionTest;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
  
/**  
 * 类帮助类（原创）  
 * @author 存在就有理由  
 *  
 */  
public class ClassUtil {   
    public static final String FILE_PREFIX = "file:/";   
    public static final String URL_PROTOCOL_JAR = "jar";   
    public static final String URL_PROTOCOL_ZIP = "zip";   
    public static final String URL_PROTOCOL_WSJAR = "wsjar";   
    public static final String URL_PROTOCOL_CODE_SOURCE = "code-source";   
    public static final String JAR_URL_SEPARATOR = "!/";   
    /**  
     *   
     */  
    static Map<String,Class[]> packageClassCache = new HashMap<String, Class[]>();   
    /**  
     * 获得默认类加载器  
     * @return  
     */  
    public static ClassLoader getDefaultClassLoader() {   
        ClassLoader cl = null;   
        try {   
            cl = Thread.currentThread().getContextClassLoader();   
        } catch (Throwable ex) {   
        }   
        if (cl == null) {   
            cl = ClassUtil.class.getClassLoader();   
        }   
        return cl;   
    }   
  
    /**  
     * 获得某一包下的所有类  
     * @param packageName  
     * @return  
     */  
    public static Class[] getClassesInPackage(String packageName) {   
        try {   
            if(packageName==null){   
                throw new Exception("packageName can't be null");   
            }   
            Set<Class> classes = new HashSet<Class>();   
            String tmpPackageName = packageName;   
            int point = tmpPackageName.length();   
            while(point!=-1){   
                tmpPackageName = tmpPackageName.substring(0, point);   
                Class[] cs = packageClassCache.get(tmpPackageName);   
                if(cs == null){   
                    point = tmpPackageName.lastIndexOf(".");   
                }   
                else {   
                    for(Class c:cs){   
                        if(c.getPackage().getName().contains(packageName)){   
                            classes.add(c);   
                        }   
                    }   
                    return classes.toArray(new Class[0]);   
                }   
            }   
            String rootPath = packageName.replace('.', '/');   
            Enumeration<URL> urls = getDefaultClassLoader().getResources(rootPath);   
            while (urls.hasMoreElements()) {   
                URL url = urls.nextElement();   
                   
                if (isJarURL(url)) {// jar包   
                    String path = url.getPath().substring(url.getPath().indexOf(FILE_PREFIX)+FILE_PREFIX.length()-1,   
                            url.getPath().indexOf(JAR_URL_SEPARATOR));   
                    ZipInputStream zin = new ZipInputStream(new FileInputStream(path));   
                    ZipEntry entry;   
                    while ((entry = zin.getNextEntry()) != null) {   
                        String entryName = entry.getName().replace('/', '.');   
                        if(entryName.startsWith(packageName)){   
                            int classPoint = entryName.lastIndexOf(".class");   
                            if(classPoint!=-1){   
                                try{   
                                    classes.add(Class.forName(entryName.substring(0, classPoint)));   
                                }catch(Error e){   
                                }catch(Exception e){   
                                }   
                            }   
                        }   
                        zin.closeEntry();   
                    }   
                    zin.close();   
                } else {// 未打包的classes目录   
                    String path = url.getPath();   
                    File[] classFiles = getFilesFromDir(path,new FileFilter() {   
                        public boolean accept(File paramFile) {   
                            return paramFile.getName().endsWith(".class")||paramFile.isDirectory();   
                        }   
                    });   
                    for(File classFile:classFiles){   
                        if(classFile.isFile()){   
                            String classFilePath = classFile.getAbsolutePath().substring(path.length());   
                            try{   
                                classFilePath = packageName+classFilePath.replace(File.separatorChar, '.');   
                                classes.add(Class.forName(classFilePath.substring(0, classFilePath.lastIndexOf(".class"))));   
                            }catch(Error e){   
                            }catch(Exception e){   
                            }   
                        }   
                    }   
                }   
            }   
            Class[] cs = classes.toArray(new Class[0]);   
            packageClassCache.put(packageName, cs);   
            return cs;   
        } catch (Exception e) {   
            throw new RuntimeException(e);   
        }   
    }   
       
    /**  
     * 从一个目录中获取所有文件  
     * @param dirPath  
     * @param fileFilter  
     * @return  
     */  
    static File[] getFilesFromDir(String dirPath,FileFilter fileFilter){   
        Set<File> fileSet = new HashSet<File>();   
        File dir = new File(dirPath);   
        if(!dir.isDirectory()){   
            return new File[]{};   
        }   
        File[] files = dir.listFiles(fileFilter);   
        for(File file:files){   
            fileSet.add(file);   
            if(file.isDirectory()){   
                fileSet.addAll(Arrays.asList(getFilesFromDir(file.getAbsolutePath(),fileFilter)));   
            }   
        }   
        return fileSet.toArray(new File[0]);   
    }   
       
    /**  
     * @param url  
     * @return  
     */  
    static boolean isJarURL(URL url) {   
        String protocol = url.getProtocol();   
        return (URL_PROTOCOL_JAR.equals(protocol) ||   
                URL_PROTOCOL_ZIP.equals(protocol) ||   
                URL_PROTOCOL_WSJAR.equals(protocol) ||   
                (URL_PROTOCOL_CODE_SOURCE.equals(protocol) && url.getPath().contains(JAR_URL_SEPARATOR)));   
    }   
       
    /**  
     * 动态执行一个类的新方法  
     * @param obj  
     * @param methodName  
     * @param params  
     * @return  
     */  
    public static Object invoke(Object obj,String methodName,Object... params){   
        if(obj == null){   
            throw new NullPointerException("can't invoke with null obj");   
        }   
        if(methodName == null){   
            throw new NullPointerException("can't invoke with null methodName");   
        }   
        params = params==null ? new Object[0]:params;   
        List newParams = new ArrayList();   
        try{   
            Class objClass = obj.getClass();   
            Method targetMethod = null;   
            for(Method method:objClass.getMethods()){   
                if(method.getName().equals(methodName)){   
                    Class[] parameterTypes = method.getParameterTypes();   
                    out:   
                    if(parameterTypes.length<=params.length){   
                        for(int i = 0;i< parameterTypes.length;i++){   
                            if(i+1< parameterTypes.length){   
                                Object param = params[i];   
                                if(param!=null){   
                                    if(!isInstance(parameterTypes[i],param)){   
                                        break out;   
                                    }   
                                    newParams.add(param);   
                                }   
                            }   
                            else {   
                                Object param = Arrays.copyOfRange(params, i, params.length);   
                                if(!isInstance(parameterTypes[i],param)){   
                                    break out;   
                                }   
                                newParams.add(param);   
                            }   
                        }   
                        targetMethod = method;   
                        break;   
                    }   
                }   
            }   
            if(targetMethod==null){   
                throw new Exception("can't find vaild method");   
            }   
            return targetMethod.invoke(obj, newParams.toArray());   
        }catch(Exception ex){   
            throw new RuntimeException("can't invoke object:"+obj+"'s method:"+methodName+" with this params:"+(params==null?"null":Arrays.asList(params)),ex);   
        }   
    }   
       
    /**  
     * 判断一个对象是否是一个类的实例（兼容基类和其包装器类型的转换）  
     * @param cls  
     * @param obj  
     * @return  
     */  
    public static boolean isInstance(Class<?> cls,Object obj){   
        if(obj==null){   
            return false;   
        }   
        if(cls.isInstance(obj)){   
            return true;   
        }   
        if(cls.equals(Integer.TYPE)||cls.equals(Integer.class)){   
            if(obj.getClass().equals(Integer.TYPE)||obj.getClass().equals(Integer.class)){   
                return true;   
            }   
        }   
        if(cls.equals(Short.TYPE)||cls.equals(Short.class)){   
            if(obj.getClass().equals(Short.TYPE)||obj.getClass().equals(Short.class)){   
                return true;   
            }   
        }   
        if(cls.equals(Long.TYPE)||cls.equals(Long.class)){   
            if(obj.getClass().equals(Long.TYPE)||obj.getClass().equals(Long.class)){   
                return true;   
            }   
        }   
        if(cls.equals(Boolean.TYPE)||cls.equals(Boolean.class)){   
            if(obj.getClass().equals(Boolean.TYPE)||obj.getClass().equals(Boolean.class)){   
                return true;   
            }   
        }   
        if(cls.equals(Float.TYPE)||cls.equals(Float.class)){   
            if(obj.getClass().equals(Float.TYPE)||obj.getClass().equals(Float.class)){   
                return true;   
            }   
        }   
        if(cls.equals(Double.TYPE)||cls.equals(Double.class)){   
            if(obj.getClass().equals(Double.TYPE)||obj.getClass().equals(Double.class)){   
                return true;   
            }   
        }   
        if(cls.equals(Character.TYPE)||cls.equals(Character.class)){   
            if(obj.getClass().equals(Character.TYPE)||obj.getClass().equals(Character.class)){   
                return true;   
            }   
        }   
        if(cls.equals(Byte.TYPE)||cls.equals(Byte.class)){   
            if(obj.getClass().equals(Byte.TYPE)||obj.getClass().equals(Byte.class)){   
                return true;   
            }   
        }   
        return false;   
    }   
  
    public static void main(String[] args) {   
        Class[] classes = getClassesInPackage("java.util");   
        for(Class c:classes){   
            System.out.println(c);   
        }   
        System.out.println(classes.length);   
    }   
}  
