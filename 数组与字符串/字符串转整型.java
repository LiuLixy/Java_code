题目:将字符串转换为整型输出，如果该字符串不是纯字符串组成，则返回0
示例:	输入: +125332532
 		输出: 125332532

public class Test {
	public static void main(String[] args) {
		String str = "+125332532";
		System.out.println(StrToInt(str));
	}

	public static int StrToInt(String str) {
		// 字符串转换为字符数组
		char[] arr = str.toCharArray();
		int k = 0;

		// 判断字符串的第一个字符是否为"+"号
		if (arr[0] == '+') {
			// 从下标为1开始循环处理字符数组中的每一个元素
			for (int i = 1; i < arr.length; i++) {
				// 判断字符是否为字符'0'~'9'
				if (arr[i] >= '0' && arr[i] <= '9') {
					// 将char转换为 int 
					k = k * 10 + (arr[i] - '0');
				} else {
					// 字符串不是纯数字组成
					return 0;
				}
			} 
			return k;
		}
		// 判断字符串的第一个字符是否为"-"号
		if (arr[0] == '-') {
			for (int i = 1; i < arr.length; i++) {
				if (arr[i] >= '0' && arr[i] <= '9') {
					k = k * 10 + (arr[i] - '0');
				} else {
					return 0;
				}
			}
			return -k;
		}

		// 字符串第一个既不是"+",也不是"-"
		// 从下标为0开始循环地处理每一个字符数组的元素
		for (int i = 0; i < arr.length; i++) {
			// 判断是否为字符'0'~'9'
			if (arr[i] >= '0' && arr[i] <= '9') {
				// 将 char 转化为 int
				k = k * 10 + (arr[i] - '0');
			} else {
				return 0;
			}
		}
		return k;
	}
}