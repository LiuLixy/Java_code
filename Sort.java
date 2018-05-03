public class Sort {
	public static void main(String[] args) {
		int[] array = new int[] {11, 22, 31, 21, 5, 3, 52, 21, 6};
		for(int i : array) {
			System.out.print(i+" ");
		}
		System.out.println(" ");
		//bubbleSort(array, array.length);
		selectSort(array, array.length);
		for (int j : array) {
			System.out.print(j+" ");
		}
	}
	// public static void bubbleSort(int[] array, int len) {
	// 	for (int i = 0; i < len - 1; i++) {
	// 		for (int j = 0; j < len - i - 1; j++) { 
	// 			if (array[j] > array[j+1]) {
	// 				int tmp = array[j];
	// 				array[j] = array[j+1];
	// 				array[j+1] = tmp;
	// 			}
	// 		}
	// 	}
	// }
	public static void selectSort(int[] array, int len) {
		
	}
}