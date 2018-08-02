题目：将字符串 "student. a am I" 转换为 "I am a student."；

解法一：

import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        String string = "student. a am I";
        System.out.println(ReverseSentence(string));
    }
    public static String ReverseSentence(String str) {
        Stack<String> stringStack = new Stack<String>();
        if (str == null) {
            return null;
        }
        String[] strings = str.split(" ");
        for (int i = 0; i < strings.length; i++) {
            stringStack.push(strings[i]);
        }
        String result = new String();
        for (int i = 0; i < strings.length; i++) {
            if (i == strings.length - 1) {
                result = result + stringStack.peek();
            } else {
                result = result + stringStack.peek() + " ";
            }
            stringStack.pop();
        }
        return result;
    }
}


解法二：

public class Test {
    public static void main(String[] args) {
        String string = "student. a am I";
        System.out.println(ReverseSentence(string));
    }
    public static String ReverseSentence(String str) {
        Stack<String> stringStack = new Stack<String>();
        if (str == null) {
            return null;
        }
        String[] strings = str.split(" ");
        StringBuilder sb=new StringBuilder();

        for(int i = strings.length - 1; i >= 0; i--){
            if(i != 0){
                sb.append(strings[i]).append(" ");
            }else{
                sb.append(strings[i]);
            }
        }
        return sb.toString();
    }
}