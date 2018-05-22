对象序列化与反序列化：要求自定义Person类，其中三个属性name,age,school,age属性
不作为序列化保存而其他两个属性使用序列化保存在本地文件TestSer.txt中。 
使用序列化和反序列化的方式将自定义类序列化与反序列化操作。 


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Person implements Serializable {
	private String school;
	private String name;
	private int age;
	
	public Person(String school, String name, int age) {
		super();
		this.school = school;
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Person [school=" + school + ", name=" + name + ", age=" + age + "]";
	}
}


public class TestSer {
	public static final File FILE = new File("C:\\Users\\LiuWang\\Desktop\\TestSer.txt");
	public static void main(String[] args) throws Exception {
		ser(new Person("西安工大", "Peter", 20));
		// dser();
	}
	// 序列化
	public static void ser(Object obj) throws Exception {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE));
		oos.writeObject(obj);
		oos.close();
	}
	// 反序列化
	public static void dser() throws Exception {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE));
		System.out.println(ois.readObject());
		ois.close();
	}
}
