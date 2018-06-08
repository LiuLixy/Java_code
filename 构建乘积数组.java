题目: 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法

思路: 使用一个数组，保存元素组某位置，例如i,保存i前的所以元素的乘积
另外一个数组，保存i后所有元素的乘积，最后这两个数组相乘


public class Main {

    public static void main(String[] args) {
        int[] A = new int[] {1, 2, 3, 4, 5, 6};
        int[] B = multiply(A);
        for (int i: B) {
            System.out.println(i);
        }
    }
    public static int[] multiply(int[] A) {
        int[] B = new int[A.length];
        int[] C = new int[A.length];
        B[0] = 1;
        C[A.length - 1] = 1;
        for (int i = 1; i < A.length; i++) {
            B[i] = B[i -1] * A[i - 1];
            C[A.length - i - 1] = C[A.length - i] * A[A.length - i];
        }
        for (int i = 0; i < A.length; i++) {
            B[i] = C[i] * B[i];
        }
        return  B;
    }
}