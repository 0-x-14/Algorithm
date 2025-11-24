import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] arr = new int[n+1][m+1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			// n개의 줄 동안 m개의 정수로 배열이 주어짐
			for (int j = 1; j <= m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int k = Integer.parseInt(br.readLine());
		for (int s = 0; s < k; s++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int sum = 0;

			// (i, j)부터 (x,y) 위치까지 수들의 합
			// (i, j)는 i행 j열
			for (int p = i; p <= x; p++) {
				for (int q = j; q <= y; q++) {
					sum += arr[p][q];
				}
			}
			System.out.println(sum);
		}
	}
}