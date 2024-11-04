import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// (), (()), ()() -> VPS
		// VPS면 YES, 아니면 NO 출력하기

		int n = Integer.parseInt(br.readLine());
		boolean[] isVPS = new boolean[n]; // n개의 각 문자열이 VPS인지 여부를 저장하는 배열

		// (와 )의 쌍의 개수가 안 맞거나, 안 맞은 채로 ) 다음 (가 나오면 VPS가 아닌 문자열
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			int cnt = 0;
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) == '(') {
					cnt++;
				}
				else if (str.charAt(j) == ')') {
					cnt--;
				}

				if (cnt < 0) {
					isVPS[i] = false;
					break;
				}
			}
			if (cnt == 0) {
				isVPS[i] = true;
			}
		}

		for (int i = 0; i < n; i++){
			if (isVPS[i] == true) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}
