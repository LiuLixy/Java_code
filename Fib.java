public class Fib {
   public static void main(String[] args) {
      if(args.length<0) {
      System.out.println("没有传递参数");
      } else {
         int n = Integer.parseInt(args[0]);
         for(int i = 1; i <= n; i++) {
            System.out.print(fibonacci(i)+"、");
         }
         System.out.println(" ");
      }
   }
   public static int fibonacci(int args) {
      if(args <= 1){
         return args;
      } else {
         return fibonacci(args-1)+ fibonacci(args-2);
      }
   }
}
