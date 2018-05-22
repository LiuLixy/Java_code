要求:在桌面上新建一个Test.txt,使用打印流向文件中输出如下: 
Hello world 
hello Java

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class TestIO {
	public static void main(String[] args) throws Exception {
		File file = new File("C:\\Users\\LiuWang\\Desktop\\Test.txt");
		OutputStream output = new FileOutputStream(file);
		String str = "Hello world\r\nhello Java"; 
		output.write(str.getBytes());
		output.close();
	}
}	


然后使用Scanner类读取文件内容并输入到控制台。

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

public class TestIO {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new FileInputStream(new File("C:\\Users\\LiuWang\\Desktop\\Test.txt")));
		sc.useDelimiter("\r\n");
		while(sc.hasNext()) {
			System.out.println(sc.next());
		}
		sc.close();
	}
}