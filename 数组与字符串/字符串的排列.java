题目描述：
输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,
则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。 结果请按字母顺序输出。

输入描述：输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。

思路：
把字符串分成两部分，一部分是第一个字符，另一个部分是后面其余的字符串
拿第一个字符和后面的字符串依次交换，这是一个递归的过程
注意：在递归里第一次交换是自身和自身的交换，保证不缺少字符串


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            if (str.length() > 9) {
                System.out.println("输入的字符串长度不符合要求...");
                return;
            }
            for (int i = 0; i < str.length(); i++) {
                boolean bool = str.matches("[A-z]+");
                if (!bool) {
                    System.out.println("输入的字符串不是纯字母...");
                    return;
                }
            }
            System.out.println(Permutation(str));
        }
    }

    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if (str == null || str.length() <= 0) {
            return result;
        }
        char[] chars = str.toCharArray();
        Permutation(result, chars, 0);
        Collections.sort(result);
        return result;
    }

    public static void Permutation(ArrayList<String> arrayList, char[] chars, int start) {
        if (start == chars.length - 1) {
            String string = String.valueOf(chars);
            if (arrayList.indexOf(string) < 0) {
                arrayList.add(String.valueOf(chars));
            }
        }
        for (int i = start; i < chars.length; i++) {
            char temp = chars[i];
            chars[i] = chars[start];
            chars[start] = temp;
            Permutation(arrayList, chars, start + 1);
            temp = chars[i];
            chars[i] = chars[start];
            chars[start] = temp;
        }
        return;
    }
}