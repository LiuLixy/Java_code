public class Test {
	public static void main(String[] args) {
		for (int i = 1; i <= 9; i++) { //行
          for (int j = 1; j <= i; j++){  //列
             System.out.print(j+"*"+i+"="+(i*j)+"\t");
          }
          System.out.println();
        }
    }
}