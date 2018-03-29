import java.util.*; 
 public class Test {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       System.out.println("Please Enter:>");
       double num = sc.nextDouble();
       System.out.println(Factorial(num));
    }
    public static double Factorial(double n){
       if (n == 1) {
          return 1;
       }else {
          return n * Factorial(n-1);
       }
    }
 }