编写一个方法，确定其字符串的所有排列组合。
给定一个 String A，代表字符串，请返回所有该字符串字符的排列，
保证字符串长度小于等于11且字符串中的字符均为大写英文字符，
排列中的字符串按字典序从大到小排序(不合并重复字符串)。

例如：
输入：  "ABC"
返回：  ["CBA", "CAB", "BCA", "BAC", "ACB", "ABC"]


解法1：
思路：向将该字符串的所有排序列出，再排序。
缺点：时间复杂度较大

import java.util.ArrayList;

/**
 * @Author: LiuWang
 * @Created: 2018/7/27 18:53
 */
public class Permutation {
    public static void main(String[] args) {
        String A = "ADJBVAE";
        ArrayList<String> result = getPermutation(A);
        System.out.println(result);
    }
    public static ArrayList<String> getPermutation(String A) {
        ArrayList<String> result = new ArrayList<String>();
        if (A.length() > 11) {
            return null;
        }
        if (A.length() == 0) {
            result.add("");
            return result;
        }
        char first = A.charAt(0);
        String remind = A.substring(1);
        ArrayList<String> words = getPermutation(remind);
        for(String word : words)
        {
            for(int j = 0; j <= word.length(); j++)
            {
                String s = insertCharAt(word,first,j);
                result.add(s);
            }
        }
        sortArrayList(result);
        return result;
    }
    public static String insertCharAt(String word, char c, int i) {
        String start = word.substring(0,i);
        String end = word.substring(i);
        return start + c + end;
    }
    public static void sortArrayList(ArrayList<String> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            for (int j = i + 1; j < arrayList.size(); j++) {
                if (arrayList.get(i).compareTo(arrayList.get(j)) < 0) {
                    swap(arrayList, i, j);
                }
            }
        }
    }
    public static void swap(ArrayList<String> arrayList, int i, int j) {
        String temp = arrayList.get(i);
        arrayList.set(i, arrayList.get(j));
        arrayList.set(j, temp);
    }
}

解法2：


import java.util.ArrayList;
import java.util.Collections;

/**
 * @Author: LiuWang
 * @Created: 2018/7/26 18:53
 */
public class Permutation {
    public static void main(String[] args) {
        String A = "ADJBVAE";
        ArrayList<String> result = getPermutation(A);
        System.out.println(result);
    }
    public static ArrayList<String> getPermutation(String A) {
        ArrayList<String> list = new ArrayList<String>();
        permutation(list, A.toCharArray(), 0);
        // 得到的结果为升序，所以需要逆置以下
        Collections.sort(list);
        Collections.reverse(list);
        return list;
    }
    // 将字符串转换为 char 数组处理，得到所有的排列结果
    public static void permutation(ArrayList<String> list, char[] array, int k) {
        if(k == array.length) {
            list.add(new String(array));
            return ;
        }
        for(int i = k; i < array.length; i++) {
        swap(array, i, k);
        permutation(list, array, k + 1);
        swap(array, i, k);
        }
    }
    public static void swap(char[] array, int i, int j) {
        if(i != j) {
            char temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }