题目: 输入一个非空字符串, 返回字符串中第一个出现一次的字符, 如果不存在返回-1.

public class Test {
	public static void main(String[] args) {
		String str = "sasasfeadgdfjhvn";
		int result = solution(str);
		if (result == -1) {
			System.out.println(result);
		} else {
			System.out.println((char) result);
		}
	}

	public static int solution(String str) {
		if (str == null) {
			return -1;
		}
		char[] array = str.toCharArray();
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (array[i] == array[j] && i != j) {
					break;
				}
				if (j == array.length - 1) {
					return array[i];
				}
			}
		}
		return -1;
	}
}