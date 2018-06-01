题目: 输入一个正整数数组，把数组里所有的数字拼接起来排成一个数，
打印能拼接出的所有数字中最小的一个，例如： 输入的数组为: {3, 32, 321}，
则打印出这三个数字能排成的最小数字为 321323

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入一个数组: ");
		String str = sc.nextLine();
		String[] strArr = str.split(" ");
		int[] array = new int[strArr.length];
		for (int i = 0; i < array.length; i++) {
			array[i] = Integer.parseInt(strArr[i]);
		}
		System.out.println("组成的最小的数字为: "+PrintMinNumber(array));
	}
	public static String PrintMinNumber(int[] numbers) {
		if (numbers == null) {
			return null;
		}
		String result = "";
		for (int i = 0; i < numbers.length; i++) {
			if (i < numbers.length - 1) {
				String s1 = numbers[i] + "" + numbers[i + 1];
				String s2 = numbers[i + 1] + "" + numbers[i];
				if (s1.compareTo(s2) > 0) {
					int tmp = 	numbers[i];
					numbers[i] = numbers[i + 1];
					numbers[i + 1] = tmp;
					i = -1;
				}
			}
		} 
		for (int i = 0; i < numbers.length; i++) {
			result += numbers[i];
		}
		return result;
	}
}