class A {	
	//构造方法
	public A() {
		System.out.println("1. A类构造方法");
	}
	//非静态代码块
	{
		System.out.println("2. A类非静态代码块");
	}
	//静态代码块
	static {
	System.out.println("3.A类静态代码块");
	}
}
public class B extends A {
	//构造方法
	public B() {
		System.out.println("4.B类构造方法");
	}
	//非静态代码块
	{
		System.out.println("5.B类非静态代码块");
	}
	//静态代码块
	static {
		System.out.println("6.B类静态代码块");
	}
	public static void main(String[] args) {
		System.out.println("7.---start---");
		new B();
		new B();
		System.out.println("8.---end---");
	}
}


//运行结果为: 3 6 7 2 1 5 4 2 1 5 4 8