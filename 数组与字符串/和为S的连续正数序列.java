小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,
你能不能也很快的找出所有和为S的连续正数序列? 

题目: 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序

1）由于我们要找的是和为S的连续正数序列，因此这个序列是个公差为1的等差数列，
而这个序列的中间值代表了平均值的大小。假设序列长度为n，那么这个序列的中间值
可以通过（S / n）得到，知道序列的中间值和长度，也就不难求出这段序列了。
2）满足条件的n分两种情况：
n为奇数时，序列中间的数正好是序列的平均值，所以条件为：(n & 1) == 1 && sum % n == 0；
n为偶数时，序列中间两个数的平均值是序列的平均值，而这个平均值的小数部分为0.5，
所以条件为：(sum % n) * 2 == n.
3）由题可知n >= 2，那么n的最大值是多少呢？我们完全可以将n从2到S全部遍历一次，
但是大部分遍历是不必要的。为了让n尽可能大，我们让序列从1开始，
根据等差数列的求和公式：S = (1 + n) * n / 2，得到.

最后举一个例子，假设输入sum = 100，我们只需遍历n = 13~2的情况（按题意应从大到小遍历），
n = 8时，得到序列[9, 10, 11, 12, 13, 14, 15, 16]；n  = 5时，得到序列[18, 19, 20, 21, 22]。

import java.util.ArrayList;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入一个正整数: ");
		int sum = sc.nextInt();
		ArrayList<ArrayList<Integer>> result = FindContinuousSequence(sum);
		for (ArrayList<Integer> arrayList : result) {
			System.out.println(arrayList);
		}
	}
	public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		if (sum < 3) {
			return null;
		}
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		for (int i = (int) Math.sqrt(2 * sum); i >= 2; i--) {
			if((i & 1) == 1 && sum % i == 0 || (sum % i) * 2 == i) {
				ArrayList<Integer> list = new ArrayList<>();
				for(int j = 0, k = (sum / i) - (i - 1) / 2; j < i; j++, k++) {
					list.add(k);
				}
				result.add(list);
			}
		}
		return result;
    }
}
