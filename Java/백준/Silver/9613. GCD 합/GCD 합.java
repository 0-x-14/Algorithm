import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            int[] arr = new int[num];
            long GCDSum = 0;
            for (int j = 0; j < arr.length; j++) {
                arr[j] = sc.nextInt();
            }

            for (int k = 0; k < arr.length - 1; k++) {
                for (int s = k + 1; s < arr.length; s++) {
                    GCDSum += GCD(arr[k], arr[s]);
                }
            }

            System.out.println(GCDSum);
        }
    }
    public static long GCD(int a,int b){
        if (b == 0) {
            return a;
        } else {
            return GCD(b, a % b);
        }
    }
}
