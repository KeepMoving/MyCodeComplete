package replace;

public class test3 
{
    public static void main(String[] args)
    {
        String bb = "test（test）";
        System.out.println(bb);
        bb = cutkakko(bb);
        recutkakko(bb);
    }
    
    private static String cutkakko(String temp)
    {
        temp=temp.replaceAll("（", "_");
        temp=temp.replaceAll("）", "\\.");
        System.out.println(temp);
        return temp;
    }
    
    private static void recutkakko(String temp)
    {
        temp=temp.replaceAll("_","（");
        temp=temp.replaceAll("\\.","）");
        System.out.println(temp);
    }
}
