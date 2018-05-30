题目: 请实现一个函数来匹配包括请实现一个函数用来匹配包括 ”.” 和 ”*” 的正则表达式。 
模式中的字符 ”.” 表示任意一个字符，而 ”*” 表示它前面的字符可以出现任意次（包含0次）。 
在本题中，匹配是指字符串的所有字符匹配整个模式。 
例如，字符串 ”aaa” 与模式 ”a.a” 和 ”ab*b*ac*a” 匹配，但是与 ”aa.a” 和 ”ab*a” 均不匹配


public class Solution {

	public static void main(String[] args) {
		String str1 = "aaa";
		String str2 = "ab*ac*a";
		char[] str = str1.toCharArray();
		char[] pattern = str2.toCharArray();
		System.out.println(match(str, pattern));
	}
	public static boolean match(char[] str, char[] pattern) {
		if (str == null || pattern == null) {
			return false;
		}
		int strIndex = 0;
		int patternIndex = 0;
		return matchCore(str, strIndex, pattern, patternIndex);
	}
	public static boolean matchCore(char[] str, int strIndex, 
								char[] pattern, int patternIndex) {
		if (strIndex == str.length && patternIndex == pattern.length) {
			return true;
		}
		// pattern先到尾，匹配失败
        if (strIndex != str.length && patternIndex == pattern.length) {
            return false;
        }
        // 模式第2个(next字符)是*，且字符串第1个(当前字符)跟模式第1个(当前字符)匹配,分3种匹配模式；
        // 若字符串第1个(当前字符)跟模式第1个(当前字符)不匹配，模式指针后移2位
        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
              if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || 
            		  			(pattern[patternIndex] == '.' && strIndex != str.length)) {
                  // 视为模式匹配1个字符
                  return matchCore(str, strIndex, pattern, patternIndex + 2)
                          // 视为模式匹配1个字符
                          || matchCore(str, strIndex + 1, pattern, patternIndex + 2)
                          // *匹配1个，再匹配str中的下一个
                          || matchCore(str, strIndex + 1, pattern, patternIndex);
              } else {
                  return matchCore(str, strIndex, pattern, patternIndex + 2);
              }
        }

        //模式第2个不是*，且字符串第1个(当前字符)跟模式第1个(当前)匹配，则都后移1位，否则直接返回false
        if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || 
                			(pattern[patternIndex] == '.' && strIndex != str.length)) {
            return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
        }
        return false;
	}
}