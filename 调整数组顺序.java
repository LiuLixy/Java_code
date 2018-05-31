题目: 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
使得奇数位于偶数的前半部分，所有的偶数位于数组的后半部分，
并保证奇数和奇数，偶数和偶数之间的相对位置不变。

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入一个数组: ");
		String str = sc.nextLine();
		String[] strArr = str.split(" ");
		int[] array = new int[strArr.length];
		for (int i = 0; i < array.length; i++) {
			array[i] = Integer.parseInt(strArr[i]);
		}
		System.out.print("输入的数组内容为: ");
		for (int i : array) {
			System.out.print(i+" ");
		}
		System.out.println();
		reOrderArray(array);
		System.out.print("调整后数组内容为: ");
		for (int i : array) {
			System.out.print(i+" ");
		}
	}
	public static void reOrderArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				if(array[j] % 2 == 0 && array[j + 1] % 2 != 0) {
					int tmp = array[j];
					array[j] = array[ j + 1];
					array[j + 1 ] = tmp;
				}
			}
		}
	}
}