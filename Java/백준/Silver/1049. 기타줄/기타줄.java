import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	// 끊어진 기타줄 개수 N, 기타줄 브랜드 개수 M
	// 브랜드별 6개 패키지 가격, 낱개 가격
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int money = 0;

		int[] unit = new int[m];
		int[] pack = new int[m];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			pack[i] = Integer.parseInt(st.nextToken());
			unit[i] = Integer.parseInt(st.nextToken());
		}


		Arrays.sort(unit);
		Arrays.sort(pack);

		money = Math.min(((n/6)+1)*pack[0], n*unit[0]);
		money = Math.min(money, ((n/6))*pack[0] + (n%6)*unit[0]);

		System.out.println(money);
	}
}
