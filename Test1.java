class MyThread implements Runnable {
	private int ticket = 10;
	private String title;
	public MyThread(String title) {
		this.title = title;
	}
	public void run() {
		while(this.ticket > 0) {
			System.out.println(this.title+": "+"剩余票数: "+this.ticket--);
		}
	}
}

public class Test1 {
	public static void main(String[] args) {
		MyThread myThreadA = new MyThread("A");
		MyThread myThreadB = new MyThread("B");
		MyThread myThreadC = new MyThread("C");
		new Thread(myThreadA).start();
		new Thread(myThreadB).start();
		new Thread(myThreadC).start();
	}
}
