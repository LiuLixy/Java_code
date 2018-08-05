给定一个有n个正整数的数组A和一个整数sum,求选择数组A中部分数字和为sum的方案数。
当两种选取方案有一个数字的下标不一样,我们就认为是不同的组成方案。 
输入描述:
    输入为两行:
        第一行为两个正整数n(1 ≤ n ≤ 1000)，sum(1 ≤ sum ≤ 1000)
        第二行为n个正整数A[i](32位整数)，以空格隔开。


输出描述:
    输出所求的方案数

示例：
    输入： 5 15 5 5 10 2 3
    输出： 4


import java.util.Scanner;

/**
 * @Author: LiuWang
 * @Created: 2018/8/5 20:46
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int sum = scanner.nextInt();
            int[] A = new int[n];
            for (int i = 0; i < n; i++) {
                A[i] = scanner.nextInt();
            }
            long[] count = new long[sum + 1];
            count[0] = 1;
            for (int i = 0; i < n; i++) {
                if (A[i] <= sum) {
                    for (int j = sum; j >= 0; j--) {
                        if (count[j] > 0 && j + A[i] <= sum) {
                            count[j + A[i]] += count[j];
                        }
                    }
                }
            }
            System.out.println(count[sum]);
        }
    }
}