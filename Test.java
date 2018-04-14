/*
class Person {
   public int i;
   public String s;

   public Person(int i, String s) {
      this.i = i;
      this.s = s;
   }
   public static int a = 10;
}

public class Test {
   public static void main(String[] args) {
      Person per1 = new Person(20, "张三");
      Person per2 = new Person(18, "李四");
      System.out.println(per1.i);
      System.out.println(per1.s);
      System.out.println(per1.a);
      System.out.println(per2.i);
      System.out.println(per2.s);
      System.out.println(per2.a);
   }
} 
*/

/*
class Person {
   public Person() {
      System.out.println("Hello Constructor");
   }
   public Person(String s) {
      this();
      System.out.println(s);
   }
}

public class Test {
   public static void main(String[] args) {
      new Person(args[0]);
   }
}
*/

/*
class Person {
   public void print() {
      System.out.println("1.");
   }
}

class Student extends Person {
   public void print(){
   System.out.println("2.");
   }
}

public class Test {
   public static void main(String[] args) {
      new Student().print();
   }
}*/


/*
class Person{
   public String info = "Person";
}
class Student extends Person{
   // 按照就近取用原则，肯定找被覆盖的属性。
   public String info = "Student";
}
public class Test{
   public static void main(String[] args) {
      System.out.println(new Student().info);
   }
}
*/

/*
public class Test {
   public static void main(String[] args) {
      {
         int x = 10;
         System.out.println("x = "+x);
      }
      int x = 100;
      System.out.println("x = "+x);
   }
}
*/


/*
class Person {
   {
      System.out.println("1.");
   }
   public Person() {
      System.out.println("2.");
   }
   static {
      System.out.println("3.");
   }
}

public class Test {
   public static void main(String[] args) {
      System.out.println("--start--");
      new Person();
      new Person();
      System.out.println("--end--");
   }
}
*/

//
//public class Test {
//   {
//      System.out.println("1.");
//   }
//   public Test() {
//      System.out.println("2.");
//   }
//   static {
//      System.out.println("3.");
//   }
//   public static void main(String[] args) {
//      System.out.println("--start--");
//      new Test();
//      new Test();
//      System.out.println("--end--");
//   }
//}
//
//
/*
class Outer {
   private String msg = "Hello World";
   class Inner {
      public void print() {
         System.out.println(msg);
      }
   }
   public void fun() {
      Inner in = new Inner();
      in.print();
   }
}

public class Test {
   public static void main(String[] args) {
      Outer out = new Outer();
      out.fun();
   }
}
*/

/*
class Outer{
   private String msg = "Hello World" ;
   public String getMsg(){ //通过此方法才能取得msg属性
   return this.msg ;
   }
public void fun(){ //3.现在由out对象调用了fun()方法
   Inner in = new Inner(this); //4.this表示当前对象
   in.print(); //7.调用方法
   }
}
class Inner{
   private Outer out;
   public Inner(Outer out){ //5.Inner.out = mian.out
   this.out = out ; //6.引用传递
   }
public void print(){ //8.执行此方法
   System.out.println(out.getMsg());
   }
}
public class Test{
   public static void main(String[] args) {
   Outer out = new Outer(); //1. 实例化Outter类对象
   out.fun(); //2.调用Outter类方法
   }
}
*/

/*
class Outer{
   private static String msg = "Hello World" ;
   public void fun(int num){
      class Inner{
         public void print(){
         System.out.println("num :" +num);
         System.out.println("msg :" +msg);
         }
      }
      new Inner().print();//产生了内部类对象并且调用方法
   }
}
public class Test{
   public static void main(String[] args) {
   Outer out = new Outer();
   out.fun(55);
   }
}
*/


/*
class Person{
   private String name;
   private int age;
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public int getAge() {
      return age;
   }
   public void setAge(int age) {
      this.age = age;
   }
}
class Student extends Person{ //定义了一个子类
   private String school; //扩充的新属性
   public String getSchool() {
      return school;
   }
}
public class Test {
   public static void main(String[] args) {
      Student student = new Student();
      student.setName("Steven");
      student.setAge(18);
      System.out.println("姓名："+student.getName()+"，年龄："+student.getAge());
   }
}
*/






/*
class Person {
   public int i;
   public String s;
}

public class Test {
   public static void main(String[] args) {
      Person per = new Person();
      System.out.println(per.i);
      System.out.println(per.s);
   }
}
*/

/*
class Person {
   public int i;
   public String s;

   public Person(int i, String s) {
      this.i = i;
      this.s = s;
   }
   public static int a = 10;
}

public class Test {
   public static void main(String[] args) {
      Person per1 = new Person(20, "张三");
      Person per2 = new Person(18, "李四");
      System.out.println(per1.i);
      System.out.println(per1.s);
      System.out.println(per1.a);
      System.out.println(per2.i);
      System.out.println(per2.s);
      System.out.println(per2.a);
   }
}
*/

/*
class Person {
   public Person() {
      System.out.println("Hello Constructor");
   }
   public Person(String s) {
      this();
      System.out.println(s);
   }
}

public class Test {
   public static void main(String[] args) {
      new Person(args[0]);
   }
}
*/

/*
public class Test{
   public static void main(String[] args) {
      for (int num = 100; num < 1000; num++) {
         int i = num%10;//求出num的个位数
         int j = num/10%10;//求出num的百位数
         int k = num/100%10;//求出num的千位数
         if(i*i*i + j*j*j + k*k*k == num){
            System.out.print(num+" ");
         }
      }
      System.out.println("");
   }
}
*/

/*
class Father{
   private String name = "zhangjun";
   class Child{
      public void introFather(){
         System.out.println("My father's name is "+name);
      }
    }
}

public class Test {
   public static void main(String[] args) {
      Father.Child child = new Father().new Child();
      child.introFather();
   }
}
*/


/*
利用接口做参数，写个计算器，能完成加减乘除运算。 
（1）定义一个接口Compute含有一个方法int computer(int n, int m)。 
（2）设计四个类分别实现此接口，完成加减乘除运算。 
（3）设计一个类UseCompute，类中含有方法：public void useCom(Compute com, int one, int two)，
            此方法能够用传递过来的对象调用computer方法完成运算，并输出运算的结果。 
（4）设计一个主类Test，调用UseCompute中的方法useCom来完成加减乘除运算。 
interface ICompute  {
   int computer(int n, int m);
}

//加法
class Add implements ICompute {
   public int computer(int n, int m) {
      return n + m;
   }
}

//减法
class Sub implements ICompute {
   public int computer(int n, int m) {
      return n - m;
   }
}

//乘法
class Mul implements ICompute {
   public int computer(int n, int m) {
      return n * m;
   }
}

//除法
class Div implements ICompute {
   public int computer(int n, int  m) {
      return n / m;
   }
}

class UseCompute {
   public void useCom(ICompute com, int one, int two) {
      int ret = com.computer(one, two);
      System.out.println("计算结果： "+ret);
   }
}

public class Test { 
   public static void main(String[] args) { 
      UseCompute uc = new UseCompute();
      uc.useCom(new Add(), 5, 7);
      uc.useCom(new Sub(), 12, 7);
      uc.useCom(new Mul(), 5, 4);
      uc.useCom(new Div(), 14, 7);
   } 
} 
*/


/*
（1）定义接口A，里面包含值为3.14的常量PI和抽象方法double area()。 
（2）定义接口B，里面包含抽象方法void setColor(String c)。 
（3）定义接口C，该接口继承了接口A和B，里面包含抽象方法void volume()。 
（4）定义圆柱体类Cylinder实现接口C，该类中包含三个成员变量：底圆半径radius、 
圆柱体的高height、颜色color。 
（5）创建主类来测试类Cylinder。


interface IA {
   float PI = 3.14f;
   public abstract double area();
}

interface IB {
   public abstract void setColor(String c);
}

interface IC extends IA, IB {
   public abstract void volume();
}

class Cylinder implements IC {
   private int radius;
   private int height;
   private String color;

   public Cylinder(){}  
      
    public Cylinder(int radius, int height, String color){  
        this.radius = radius;  
        this.height = height;  
        this.color = color;  
    }  
      
    public int getRadius() {  
        return radius;  
    }  
  
    public void setRadius(int radius) {  
        this.radius = radius;  
    }  
  
    public int getHeight() {  
        return height;  
    }  
  
    public void setHeight(int height) {  
        this.height = height;  
    }  
  
    public String getColor() {  
        return color;  
    }  
  
    public void setColor(String c) {  
      this.color = color;       
    }  
  
    //Override  
    public double area() {  
        return 2*radius*PI*height + 2*radius*radius*PI;  
    }  
  
    //Override  
    public void volume() {  
        float volumeCount = radius*radius*PI*height;  
        System.out.println("体积为： " + volumeCount);  
    }  
}

public class Test {
   public static void main(String[] args) {
      Cylinder c = new Cylinder(4, 2, "green");
      System.out.println("表面积为： "+c.area());
      c.volume();
   }
}
*/

/*
//1000以内的完数

public class Test {
   public static void isWanShu() {
      for(int i = 1; i <= 1000; i++) {
         int sum = 0;
         for (int j = 1; j < i; j++) {
            if(i % j == 0){
               sum += j;
            }
         }
         if(sum == i) {
            System.out.print(i+" ");
         }  
      }

   }
   public static void main(String[] args) {
      isWanShu();
   }
}
*/


/*
编程题: 
要求: 
1).Person类有name,age,salary属性，要求实现至少两个构造方法，并且属性私有，提供对应的getter、setter。 
2).覆写toString方法，要求在System.out.println()函数中传递Person对象能打印出三个属性值而不是对象地址。 
3).覆写equals方法，要求两个Person类对象的值相同时返回true。 

class Person{
	private String name;
	private Integer age;
	private Integer salary;
	public Person() {
		this.name = "Peter";
		this.age = 18;
		this.salary = 20000; 
	}
	public Person(String name, Integer age, Integer salary) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "name: "+this.getName()+", age: "+this.getAge()+", salary: "+this.getSalary();
	}
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if(!(obj instanceof Person)) {
			return false;
		}
		Person p = (Person)obj;
		return (this.name.equals(p.name)) && (this.age.equals(p.age)) && (this.salary.equals(p.salary));
	}
}

public class Test {
	public static void main(String[] args) {
		Person p1 = new Person("Peter", 18, 20000);
		Person p2 = new Person();
		System.out.println(p1.toString());
		System.out.println(p2.toString());
		System.out.println(p1.equals(p2));
	}	
}
*/


/*
public class Test {
	public static void main(String[] args) {
		Integer a = 55;
		Integer b = 55;
		System.out.println(a==b);//true
		System.out.println(a == new Integer(55));  //false
		System.out.println(a.equals(new Integer(55))); //true
		Integer c = 129; 
		Integer d = 129; 
		System.out.println(c==d); //false
	}
}

//在自动装箱时对于在-128~127的值，它们被装箱为Integer对象后，
//会存在内存中被重用，因为重用，所以Integer b = 55，实际上没有生成新的对象，而是引用了对象a，实际上参考的对象是同一个对象，内存地址一样，所以结果是true。
//而new Integer(55)是生成了新的对象，"=="比较的是两个对象的内存地址。所以是false。
//equals比较的是内容是否一致，所以a.equals(new Integer(55)的结果为true。
//在自动装箱时如果值不在-128~127之间，则被装箱后Integer对象不会被重用，c与d的内存地址也就不一样，所以结果为false。

*/

/*
 //懒汉式单例
class Singleton{
	private static Singleton instance ;
	private Singleton() { // private声明构造
	}
	public static Singleton getInstance() {
		if (instance==null) { // 表示此时还没有实例化
		instance = new Singleton() ;
		}
		return instance ;
	}
	public void print() {
		System.out.println("Hello World");
	}
}

public class Test {
	public static void main(String[] args) {
		Singleton singleton = null ; // 声明对象
		singleton = Singleton.getInstance() ;
		singleton.print();
	}
}

*/


/*
编程: 
1).定义一个MulException类继承Exception类，要求两数相乘等于100报错，在主类中定义一个方法，在方法中抛出此异常，在主方法观察结果。 
2).定义一个DivException类继承RuntimeException类，要求两数相除等于2报错，在主类中定义一个方法，在方法中抛出此异常，在主方法观察结果。

class MulException extends Exception {
	public MulException(String str) {
		super(str);
	}
}

class DivException extends Exception {
	public DivException (String str) {
		super(str);
	}
}

public class Test {
	public static void main(String[] args) {
		try{
			Mul(50,2);
		}catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Div(10,5);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static int Mul(int a, int b) throws MulException {
		int ret = a*b;
		try {
			if(ret == 100) {
				throw new MulException("两数相乘不能为100");
			}
		}catch (Exception e) {
			throw e;
		}finally {
			System.out.println("计算结果: "+ret);
		}
		return ret;
	}
	public static int Div(int a, int b) throws DivException {
		int ret = a/b;
		try {
			if(ret == 2) {
				throw new DivException("两数相除不能为2");
			}
		}catch (Exception e) {
			throw e;
		}finally {
			System.out.println("计算结果： "+ret);
		}
		return ret;
	}
}
*/

/*
题目：猴子吃桃问题：猴子第一天摘下若干个桃子，当即吃了一半，还不过瘾，又多吃了一个,
第二天早上又将剩下的桃子吃掉一半，又多吃了一个。以后每天早上都吃了前一天剩下的一半零一个。
到第10天早上想再吃时，见只剩下一个桃子了。求第一天共摘了多少。
public class Test {
	public static void main(String[] args) {
		int ret = getPeach(10);
		System.out.println(ret);
	}
	public static int getPeach(int days) {
		if(days == 1) {
			return 1;
		}
		return getPeach(days-1)*2 + 1;
	}
}
*/

