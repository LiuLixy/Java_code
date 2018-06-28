题目: 在一个长度为n的数组里的所有数字都在 0 到 n-1 的范围内。 数组中某些数字是重复的，
但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。


思路: 
1. 遍历数组，采用hashmap存放每个元素，其中元素作为key存储，value为0。 
2. 当前遍历元素插入hashmap时，先检查hashmap中是否已经存在同样的key。 
3. 若存在，记录下该值，返回true；若不存在，存入map中，继续遍历，直到数组结束，返回false.


import java.util.HashMap;

public class Test {
	public static void main(String[] args) {
		int[] numbers = new int[] {1,2,3,4,5,3,5,4,6,8,2,4,1,4,5,8,9};
		int length = numbers.length;
		int[] duplication = new int[length];
		duplicate(numbers, length, duplication);
		System.out.println(duplication[0]);
	}

	/** Parameters:
        numbers:     an array of integers
        length:      the length of array numbers
        duplication: (Output) the duplicated number in the array number,
        			 length of duplication array is 1,so using duplication[0] = ? in implementation;
                     Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
        这里要特别注意~返回任意重复的一个，赋值duplication[0]
     	Return value:       true if the input is valid, and there are some duplications in the array number
                   		    otherwise false
    */
	public static boolean duplicate(int[] numbers, int length, int[] duplication) {
		if (numbers == null || length <= 1) {
			duplication = null;
			return false;
		}
		boolean flag = false;
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		for (int i : numbers) {
			if (hashMap.containsKey(i)) {
				flag = true;
				duplication[0] = i;
				break;
			}
			hashMap.put(i, 0);
		}
		return flag;
	}
}