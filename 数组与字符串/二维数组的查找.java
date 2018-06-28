题目: 在一个二维数组中，每一行都是按照从左往右递增的顺序排序，
每一列都是按照从上到下递增的排序，请完成一个函数，
输入一个这样的二维数组，判断数组中是否含有该整数


public class Test {
	public static void main(String[] args) {
		int[][] array = new int[][] {
			{1, 2, 3},
			{4, 5, 6},
			{7, 8, 9}
		};
		System.out.println(Find(5, array));
		System.out.println(Find(0, array));
		System.out.println(Find(10, array));
	}
	public static boolean Find(int target, int[][] array) {
		int row = array.length; // 行数
		int col = array[0].length;  // 列数
		int i = row - 1;
		int j = 0;
		while (i >= 0 && j < col) {
			if (target > array[i][j]) {
				j++;
			} else if (target < array[i][j]) {
				i--;
			} else {
				return true;
			}
		}
		return false;
	}
}