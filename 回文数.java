题目：输入一个5位数, 判断它是不是回文数. 即12321是回文数, 个位与万位相同, 十位与千位相同.


import java.util.*;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入一个5位数: ");
		while(sc.hasNext()) {
			int num = sc.nextInt();
			if((num/10000 == num % 10) && 
					(num/1000%10 == num % 100 / 10)) {
				System.out.println(num+"是回文数..");
			} else {
				System.out.println(num+"不是回文数..");
			}
		}
	}
}