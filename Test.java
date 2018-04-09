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