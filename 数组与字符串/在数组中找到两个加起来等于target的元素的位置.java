Given an array of integers, find two numbers such that they add up to a specific 
target number.The function twoSum should return indices of the two numbers such that 
they add up to the target, where index1 must be less than index2. Please note that 
your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2

package com.lwstudy.twosum;

public class Solution {
    public static void main(String[] args) {
        int[] array = new int[]{2, 7, 11, 15};
        int[] result = twoSum(array, 26);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
    public static int[] twoSum(int[] numbers, int target) {
        if (numbers.length < 2) {
            return null;
        }
        int[] result = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target && i != j) {
                    if (i < j) {
                        result[0] = i + 1;
                        result[1] = j + 1;
                    } else {
                        result[1] = i + 1;
                        result[0] = j + 1;
                    }
                }
            }
        }
        return result;
    }
}