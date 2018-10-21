一个字符串，字符串中的字符只包含ASCII码之内的值，请输出字符串的所有大小写组合（若包含非字母，直接输出即可）
样例输入：
    aa123bb
样例输出：
    aa123bb
    Aa123bb
    AA123bb
    AA123Bb
    AA123BB
    AA123bB
    Aa123Bb
    Aa123BB
    Aa123bB
    aA123bb
    aA123Bb
    aA123BB
    aA123bB
    aa123Bb
    aa123BB
    aa123bB

代码如下：

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: LiuWang
 * @data: 2018/9/28 10:36
 */
class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            List<String> list = letterCasePermutation(str);
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        }
    }

    public static List<String> letterCasePermutation(String str) {
        List<String> list = new ArrayList<>();
        String temp = "";
        letter(list, str, temp, 0);
        return list;
    }

    public static void letter(List<String> list, String str, String temp, int index) {
        if (str.length() == temp.length()) {
            list.add(temp);
        }
        if (index == str.length()) {
            return;
        }
        temp += str.charAt(index);
        letter(list, str, temp, index + 1);
        temp = temp.substring(0, temp.length() - 1);
        //小写字母a-z
        if (str.charAt(index) >= 'a' && str.charAt(index) <= 'z') {
            temp += (char) (str.charAt(index) + 'A' - 'a');
            letter(list, str, temp, index + 1);

        }
        //大写字母A-Z
        if (str.charAt(index) >= 'A' && str.charAt(index) <= 'Z') {
            temp += (char) (str.charAt(index) + 'a' - 'A');
            letter(list, str, temp, index + 1);
        }
    }
}
