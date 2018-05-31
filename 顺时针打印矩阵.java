题目: 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 
则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.

import java.util.ArrayList;

public class Solution {
	public static void main(String[] args) {
		int[][] array = new int[][] {
			{1, 2, 3, 4},
			{5, 6, 7, 8},
			{9, 10, 11, 12},
			{13, 14, 15, 16}
		};
		ArrayList<Integer> result = new ArrayList<>();
		result = printMatrix(array);
		System.out.println(result);
	}
	public static ArrayList<Integer> printMatrix(int[][] matrix) {
		ArrayList<Integer> result = new ArrayList<>();
		
		if (matrix == null) {
			return null;
		}
		
		int row = matrix.length; 
		int col = matrix[0].length; 
		int layers = (Math.min(row, col) -1) / 2 + 1;  // 层数
		for (int i = 0; i < layers; i++) {
			for(int k = i; k < col - i; k++) {
				// 从左至右
				result.add(matrix[i][k]);  
			}
			for(int j=i+1;j<row - i;j++) {   
				// 从右上至右下
				result.add(matrix[j][col - i - 1]);
			}
            for(int k = col - i - 2; (k >= i)&&(row - i - 1 != i); k--) {    
            	// 从右至左
            	result.add(matrix[row - i - 1][k]);  
            }
            for(int j = row - i - 2; (j > i) && (col - i - 1 != i); j--) {   
            	// 从左下至左上  
            	result.add(matrix[j][i]); 
            }
		}
		return result;
	}
}