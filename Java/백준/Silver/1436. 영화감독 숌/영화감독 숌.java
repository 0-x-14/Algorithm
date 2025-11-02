import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		// 1 <= n <= 10,000
		int cnt = 1;
		int num = 666;

		while (n > cnt) {
			num++;

			if (String.valueOf(num).contains("666")){
				cnt++;
			}
		}

		System.out.println(num);
	}
}
