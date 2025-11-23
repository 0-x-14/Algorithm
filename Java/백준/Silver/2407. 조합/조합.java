import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int cnt = Math.min(m, n-m);
		BigInteger result = BigInteger.ONE;

		if (n == m) { // n과 m이 같을 경우 그대로 1 출력
			System.out.println(result);
		} else {

			for (int i = 0; i < cnt; i++) {
				result = result.multiply(BigInteger.valueOf(n - i));
			}
			for (int j = 1; j <= cnt; j++) {
				result = result.divide(BigInteger.valueOf(j));
			}

			System.out.println(result);
		}
	}
}
