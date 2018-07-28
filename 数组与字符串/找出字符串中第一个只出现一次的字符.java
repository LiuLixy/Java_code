题目：找出字符串中第一个只出现一次的字符，如果没有输出 -1。

思路：先将字符串转换为字符数组，再循环的判定每一个字符在字符串中出现的
第一个位置是否与最后一个位置相等，如果相等，该字符就是在字符串中的第一个
只出现一次的字符，如果没有找到，则输出 -1.

import java.util.Scanner;

/**
 * @Author: LiuWang
 * @Created: 2018/7/27 15:16
 */

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String string = scanner.nextLine();
            char[] chars = string.toCharArray();
            String str = "-1";
            for (int i = 0; i < chars.length; i++) {
                if (string.indexOf(chars[i]) == string.lastIndexOf(chars[i])) {
                    str = chars[i]+"";
                    break;
                }
            }
            System.out.println(str);
        }
        scanner.close();
    }
}