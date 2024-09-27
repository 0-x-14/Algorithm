import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 가장 왼쪽에서 떨어진 거리만 물이 샘
        // 길이 L인 테이프 무한개, 막을 때 최소 좌우 0.5만큼 간격 줘야 함
        // 물이 새는 곳 위치, 가지고 있는 테이프 길이 L
        // 필요한 테이프 최소 개수? 테이프 겹치는 것 가능

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 물이 새는 곳 개수 n, 테이프 길이 l
        int n = Integer.parseInt(st.nextToken());   //배열크기
        int l = Integer.parseInt(st.nextToken());

        // 물이 새는 곳의 위치
        int arr[] = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i= 0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        // 오름차순으로 정렬된 배열의 0.5만큼 떨어진 곳에서 시작
        double left = arr[0] - 0.5;
        int cnt = 1;

        for(int i=0; i<n; i++) {
            if(left+l < arr[i]) { 
                cnt++;
                left = arr[i] - 0.5;
            }
        }
        System.out.println(cnt);
    }
}
