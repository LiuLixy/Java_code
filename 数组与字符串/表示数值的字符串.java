题目：请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 
但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。

public class Test {
    public static void main(String[] args) {
        String str = "+100e556";
        System.out.println(isNumeric(str));
    }
    public static boolean isNumeric(String str) {
		
    	// 第一种
		// String string = String.valueOf(str);
		// return string.matches("[\\+-]?[0-9]*(\\.[0-9]*)?([eE][\\+-]?[0-9]+)?");

    	// 第二种
        try {
            double re = Double.parseDouble(new String(str));
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}