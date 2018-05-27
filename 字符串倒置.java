题目: 字符串倒置
示例: 输入: I like beijing.  输入的字符控制在100个以内
	 输出: beijing. like I

import java.util.*;

import java.util.Scanner;
import java.util.Stack;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please Enter: ");
		String str = sc.nextLine();
		if (str == null || str.length() > 100) {
			return;
		}
		String[] str2 = (String[]) str.split(" ");
		Stack<String> stack = new Stack<>();
		for(int i = 0; i < str2.length; i++) {
			stack.push(str2[i]);
		}
		for (int i = 0; i < str2.length; i++) {
			System.out.print(stack.peek()+" ");
			stack.pop();
		}
	}
}


public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please Enter: ");
		String str = sc.nextLine();
		String[] strArr = str.split(" ");
//		List<String> list = new ArrayList<String>();
//		list = Arrays.asList(sArr);
//		Collections.reverse(list);
//		for (String string : list) {
//			System.out.print(string + " ");
//		}
		StringBuilder sb = new StringBuilder();
		for(int i = strArr.length - 1; i >= 0; i--) {
			sb.append(strArr[i]).append(" ");
		}
		String result = sb.toString().trim();
		System.out.println(result);
	}
}