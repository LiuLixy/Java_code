题目:将字符串转换为整型输出，如果该字符串不是纯字符串组成，则返回0
示例:	输入: +125332532
 		输出: 125332532

public class Test {
	public static void main(String[] args) {
		String str = "+125332532";
		System.out.println(StrToInt(str));
	}

	public static int StrToInt(String str) {
		char[] arr = str.toCharArray();
		int k = 0;
		if (arr[0] == '+') {
			for (int i = 1; i < arr.length; i++) {
				if (arr[i] >= '0' && arr[i] <= '9') {
					k = k * 10 + (arr[i] - '0');
				} else {
					return 0;
				}
			}
			return k;
		} else if (arr[0] == '-') {
			for (int i = 1; i < arr.length; i++) {
				if (arr[i] >= '0' && arr[i] <= '9') {
					k = k * 10 + (arr[i] - '0');
				} else {
					return 0;
				}
			}
			return -k;
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= '0' && arr[i] <= '9') {
				k = k * 10 + (arr[i] - '0');
			} else {
				return 0;
			}
		}
		return k;
	}
}