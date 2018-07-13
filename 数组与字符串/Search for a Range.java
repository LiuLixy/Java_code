Given a sorted array of integers, find the starting and ending position of a given target value. 
Your algorithm’s runtime complexity must be in the order of O(log n). 
If the target is not found in the array, return [-1, -1]. 
For example, 
Given [5, 7, 7, 8, 8, 10] and target value 8, 
return [3, 4]. 


package com.lwstudy.bittest;

public class Test {
    public static void main(String[] args) {
        int[] array = new int[] {5, 7, 7, 8, 8, 10};
        int[] result = searchRange(array, 11);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
    public static int[] searchRange(int[] A, int target) {
        int[] result = new int[] {-1, -1};
        if (A.length == 0) {
            return result;
        }
        int left = 0;
        int right = A.length - 1;
        int tmp1 = 0;
        int tmp2 = 0;
        Boolean flag = false;
        // 利用二分法思路
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (A[mid] == target) {
                tmp1 = mid;
                tmp2 = mid;
                flag = true;
                break;
            } else if (A[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (flag == false) {
            return result;
        }

        if (tmp1 != A.length - 1) {
            while (tmp1 < A.length) {
                if ((tmp1 + 1 < A.length) && A[tmp1] == A[tmp1 + 1]) {
                    tmp1++;
                } else {
                    result[1] = tmp1;
                    break;
                }
            }
        } else {
            result[1] = tmp1;
        }

        if (tmp2 != 0) {
            while (tmp2 > -1) {
                if ((tmp2 - 1 > -1) && A[tmp2] == A[tmp2 - 1]) {
                    tmp2--;
                } else {
                    result[0] = tmp2;
                    break;
                }
            }
        }
        return result;
    }
}
