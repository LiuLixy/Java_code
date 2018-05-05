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
