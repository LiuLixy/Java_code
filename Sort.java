// 冒泡排序

//public class Sort {
//	public static void main(String[] args) {
//		int[] array = new int[] {11, 22, 31, 12, 6, 41, 36, 71, 3};
//		for(int i = 0; i < array.length; i++) {
//            System.out.print(array[i]+" ");
//        }
//        System.out.println(" ");
//        bubbleSort(array, array.length);
//        for(int j = 0; j < array.length; j++) {
//            System.out.print(array[j]+" ");
//        }
//	}
//	public static void bubbleSort(int[] array, int len) {
//		for(int i = 0; i < len-1; ++i) {
//			for(int j = 0; j < len-i-1; ++j) {
//				if(array[j] > array[j+1]) {
//					int tmp = array[j];
//					array[j] = array[j+1];
//					array[j+1] = tmp;
//				}
//			}
//		}
//	}
//}


// 选择排序

// public class Sort {
// 	public static void main(String[] args) {
// 		int[] array = new int[] {11, 22, 31, 12, 6, 41, 36, 71, 3};
// 		for(int i : array) {
//           System.out.print(i+" ");
//         }
//         System.out.println(" ");
//         selectSort(array, array.length);
//         for(int j : array) {
//             System.out.print(j+" ");
//         }
//    	}
// 	public static void selectSort(int[] array, int len) {
// 		 int min = 0;
// 		 for(int i = 0; i < len; i++) {
// 			 min = i;
// 			 for(int j = i + 1; j < len; j++) {
// 				 if(array[j] < array[min]) {
// 					 min = j;
// 				 }
// 			 }
// 			 if(min != i) {
// 				 int tmp = array[i];
// 				 array[i] = array[min];
// 				 array[min] = tmp;
// 			 }
// 		 }
// 	}
// }


// 快速排序

// public class Sort {
// 	public static void main(String[] args) {
// 		int[] array = new int[] {11, 22, 31, 12, 6, 41, 36, 71, 3};
// 		for(int i : array) {
//           System.out.print(i+" ");
//         }
//         System.out.println(" ");
//         quickSort(array, 0, array.length-1);
//         for(int j : array) {
//             System.out.print(j+" ");
//         }
// 	}
//     public static void quickSort(int[] array, int beg, int end) {
//         if(beg >= end) {
//             return;
//         }
//         int index = partition(array, beg, end);
//         quickSort(array, beg, index-1);
//         quickSort(array, index+1, end);
//     }
// 	 public static int partition(int[] array, int beg, int end) {
// 	        int key = array[beg];
// 	        while (beg < end) {
// 	            while (array[end] >= key && end > beg) {
// 	                end--;
// 	            } 
// 	            array[beg] = array[end];
// 	            while (key >= array[beg] && end > beg) {
// 	                beg++;
// 	            }
// 	            array[end] = array[beg];
// 	        }
// 	        array[end] = key;
// 	        return end;
// 	 }
// }


// 