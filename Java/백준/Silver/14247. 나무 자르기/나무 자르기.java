import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // n일 동안 나무 자름, 나무마다 자라는 속도 다름
        // 나무의 개수 n, 첫날 기준 나무 길이 H1, ... Hn
        // 나무들이 자라는 길이 A1, ... An
        // 최대 양 구해서 출력하기

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        // n과 a가 모두 최댓값일 경우 sum은 10,000,000,000이 되므로 Long타입 사용
        Long sum = 0L;
        for (int i = 0; i < n; i++) {
            sum += Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        // 자라는 속도가 가장 느린 것부터 일찍 자르기
        // 현재 길이는 최대 양에 영향 X
        // 총합에서 h는 무조건 한 번씩 더해지고, a만 정렬에 따라 값이 달라지므로 h는 입력 받을 때 바로 sum에 더했음
        
        Arrays.sort(a);
        for (int i = 0; i < n; i ++) {
            sum += a[i] * i;
        }

        System.out.println(sum);
    }
}
