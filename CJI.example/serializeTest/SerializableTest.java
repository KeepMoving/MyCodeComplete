package serializeTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializableTest implements Serializable {
	private static final long serialVersionUID = 0L;   

	public static void main(String[] args) throws Exception 
	{   
		//序列化类
		SerializableTest serializableTest = new SerializableTest();
		serializableTest.setAge(22);
		serializableTest.setName(SerializableTest.class.getName());
		serializableTest.setSex("男");
		FileOutputStream fileStream = new FileOutputStream("data.ser");  
		ObjectOutputStream os = new ObjectOutputStream(fileStream);
		os.writeObject(serializableTest);
		os.close();
		
		//解序列化类
		FileInputStream readFileStream = new FileInputStream("data.ser");
		ObjectInputStream ois = new ObjectInputStream(readFileStream);   
		SerializableTest st = (SerializableTest) ois.readObject();   
		ois.close();   
		System.out.println("创建对象: " + st);   
		System.out.println("得到姓名：" + st.getName());
		System.out.println("得到性别：" + st.getSex());
		System.out.println("得到年龄：" + st.getAge());
	}   

	private String name;
	private String sex;
	private int age;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
