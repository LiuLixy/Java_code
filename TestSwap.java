题目：输入数组，最大的与第一个元素交换，最小的与最后一个元素交换，输出数组。

public class TestSwap {
	public static void main(String[] args) {
		int[] array = new int[]{33, 12, 3, 42, 52, 13, 41, 58, 32, 24, 42, 1};
		for(int i : array) {
			System.out.print(i+"  ");
		}
		System.out.println();
		swap(array, array.length);
		for(int i : array) {
			System.out.print(i+"  ");
		}
	}
	public static void swap(int[] array, int len) {
		int min = 0;
		int max = len - 1;
		int tmp;
		for (int i = 0; i < len; i++) {
			if(array[i] < array[min]) {
				min = i;
			} else if (array[i] > array[max]) {
				max = i;
			}
		}
		tmp = array[0];
		array[0] = array[min];
		array[min] = tmp;
		tmp = array[len - 1];
		array[len - 1] = array[max];
		array[max] = tmp;
	}
}