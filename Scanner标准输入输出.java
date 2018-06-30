题目：输入两行, 第一行为整数n (1 <= n <= 100000), 表示一共有n个元素, 
第二行为n个数, 即每个元素都为32位的整数, 判断输入的整数中的最大值.


import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("请输入n: ");
		while (in.hasNextInt()) {
			int n = in.nextInt();
			if (n >= 1 && n <= 100000) {
				System.out.print("请输入n个数: ");
				int[] array = new int[n];
				for (int i = 0; i < n; i++) {
					array[i] = in.nextInt();
				}
				int max = 0;
				int j = 0;
				while (j < n) {
					if (array[max] < array[j]) {
						max = j;
					} else {
						j++;
					}
				}
				System.out.println("最大值为:"+array[max]);
			} else {
				System.out.println("输入错误..");
			}
		}
	}
}