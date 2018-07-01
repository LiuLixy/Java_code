public class Quicksort {
	public static void main(String[] args) {
		int[] array = new int[] {23,34,11,22,54,64,57,89,37,91,47};
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println(" ");
		sort(array, 0, array.length-1);
		for(int j = 0; j < array.length; j++) {
			System.out.print(array[j]+" ");
		}
	}
	public static int partition(int[] array, int beg, int end) {
		int key = array[beg];
		while (beg < end) {
			while (array[end] >= key && end > beg) {
				end--;
			} 
			array[beg] = array[end];
			while (key >= array[beg] && end > beg) {
				beg++;
			}
			array[end] = array[beg];
		}
		array[end] = key;
		return end;
	}

	public static void sort(int[] array, int beg, int end) {
		if(beg >= end) {
			return;
		}
		int index = partition(array, beg, end);
		sort(array, beg, index-1);
		sort(array, index+1, end);
	}	 
}
	