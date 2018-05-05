/**
题目：海滩上有一堆桃子，五只猴子来分。第一只猴子把这堆桃子平均分为五份，
多了一个，这只猴子把多的一个扔入海中，拿走了一份。第二只猴子把剩下的桃子
又平均分成五份，又多了一个，它同样把多的一个扔入海中，拿走了一份，
第三、第四、第五只猴子都是这样做的，问海滩上原来最少有多少个桃子？
*/
public class TotalPeach {
	public static void main(String[] args) {
		int totalPeach = 1; // 假设最后一次的桃子数量为 1 个
		while (true) {
			// 如果下面的条件没有满足，即循环的次数没有满足5次就中止，
			//也就不满足题目的要求，就让totalPeach+5， 直到满足要求
			totalPeach += 5;  
			int n = 0;  // 表示的是第几只猴子
			int curPeach = totalPeach;  // 表示的是当前的桃子数量
			for (int i = 0; i < 5; i++) {
				if (curPeach % 5 == 1) {
					curPeach = (curPeach - 1) / 5 * 4;
					n++;
				} else {
					break;
				}
			}
			if (n == 5) {
				System.out.println(totalPeach);
				break;
			}
		}
	}
}
