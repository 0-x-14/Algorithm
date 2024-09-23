import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // N개 운동기구 모두 1번씩, PT 1회에 2개씩 선택
        // 운동기구 홀수개일 경우 마지막 PT때는 하나만 선택
        // PT 한 번 받을 때 근손실 M 넘지 않도록
        // M의 최솟값 구하기
        // 1회 PT시 근손실 정도 : 두 운동기구의 근손실 정도의 합

        Scanner sc = new Scanner(System.in);

        // 운동기구 개수
        int n = sc.nextInt();

        // 각 운동기구의 근손실 정도, 각각 모두 다름!!!!
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        // 오름차순으로 정렬 후 n이 짝수라면 arr[0]+arr[n-1], arr[1]+arr[n-2] ... 검사
        // n이 홀수라면 arr[n-1], arr[0]+arr[n-2], arr[1]+arr[n-3] ... 검사
        // 만약 해당 값이 크다면 m의 값을 업데이트하고, 다르다면 업데이트 X
        Arrays.sort(arr);

        long m = 0;

        if (n % 2 == 0) {
            // n이 짝수일 경우
            for (int i = 0; i < n / 2; i++) {
                m = Math.max(m, arr[i] + arr[n-1-i]);
            }
        } else {
            // n이 홀수일 경우
            m = arr[n-1];
            for (int i = 0; i < n / 2; i++) {
                m = Math.max(m, arr[i] + arr[n-2-i]);
            }
        }

        System.out.println(m);
    }
}
