import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] strArr = br.readLine().split(" ");
        int[] arr = new int[n];
        long sum = 0;
        long cumulativeSum = 0;
        
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }
        
        for (int i = n - 2; i >= 0; i--) {
            cumulativeSum += arr[i + 1]; 
            sum += arr[i] * cumulativeSum;
        }

        System.out.println(sum);
    }
}