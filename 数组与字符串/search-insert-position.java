Given a sorted array and a target value, return the index if the target is found. 
If not, return the index where it would be if it were inserted in order.
You may assume no duplicates in the array.
Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0

public class Solution {
    public int searchInsert(int[] A, int target) {
        int l = 0,r = A.length - 1, pos = 0, mid;
        while(l <= r){
            mid=(l+r)>>1;
            if(target == A[mid]) {
                return mid;
            }
            else if(target > A[mid]){
                l = mid+1;
                pos = mid+1;
            }else{
                r = mid-1;
                pos = mid;
            }
        }
        return pos;
    }
}