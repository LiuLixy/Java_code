Given a number represented as an array of digits, plus one to the number.

思路：从后向前处理。如果不再有进位，则可以跳出循环。如果最高位产生了进位需要在数组的头部插入1。


public class Solution {
    public int[] plusOne(int[] digits) {
		int carry = 1;
        int i = digits.length - 1;
		for (; i >= 0; i--) {
			digits[i] += carry;
 
			if (digits[i] >= 10) {
				digits[i] -= 10;
				carry = 1;
			} else {
				carry = 0;
				break;
			}
		}
 
		if (i < 0) {
			int[] result = new int[digits.length + 1];
			result[0] = 1;
			System.arraycopy(digits, 0, result, 1, digits.length);
			return result;
		} else {
			return digits;
		}
    }
}