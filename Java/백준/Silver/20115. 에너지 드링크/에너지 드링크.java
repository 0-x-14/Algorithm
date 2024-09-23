import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // A, B 고른 후 하나를 다른 하나에 부음. 이때 반은 흘림. 부은 뒤 빈 건 버림
        // A를 B에 부을지 B에 A를 부을지 -> 합쳐진 양을 최대로!

        Scanner sc = new Scanner(System.in);

        // 가지고 있는 에너지 드링크 수
        int n = sc.nextInt();

        // 각 에너지 드링크의 양 배열에 저장
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 흘리는 양이 최대한 적어야 함. 따라서 가장 큰 값은 고정
        // 가장 큰 값에 나머지를 더한 값 1/2 더하기
        Arrays.sort(arr); // 오름차순 정렬
        int max = arr[n-1]; // 배열 중 가장 큰 값

        double sum = 0;

        for (int i = 0; i < n -1; i++) {
            sum += arr[i];
        }

        sum /= 2;
        sum += max;

        System.out.println(sum);
    }
}
