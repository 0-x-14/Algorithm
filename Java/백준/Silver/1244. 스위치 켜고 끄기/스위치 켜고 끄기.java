import java.io.*;
import java.util.StringTokenizer;

public class Main {
	// 1부터 n번까지의 스위치 존재 (1 켜짐, 0 꺼짐)
	// 학생 몇 명 뽑은 후 자연수 나눠줌
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 스위치 개수
		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] switches = new int[n];
		for (int i = 0; i < n; i++) {
			switches[i] = Integer.parseInt(st.nextToken());
		}

		int students = Integer.parseInt(br.readLine());
		int[] gender = new int[students];
		int[] stud_num = new int[students];
		for (int i = 0; i < students; i++) {
			st = new StringTokenizer(br.readLine());
			gender[i] = Integer.parseInt(st.nextToken());
			stud_num[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < students; i++) {
			if (gender[i] == 1) {
				// 남학생일 경우
				// stud_num[i]번을 받고 배수인 스위치들의 상태 변경
				for (int j = 1; j <= n / stud_num[i]; j++) {
					if (switches[stud_num[i] * j - 1] == 0)
						switches[stud_num[i] * j - 1] = 1;
					else
						switches[stud_num[i] * j - 1] = 0;
				}
			} else {
				// 여학생일 경우
				// stud_num[i]번을 중심으로 좌우가 대칭이면서
				// 가장 많은 스위치를 포함하는 구간 찾아서 상태 변경
				// 이때 구간에 속한 스위치 개수는 항상 홀수 (대칭이므로)
				// 예를 들어 총 8개인데 3번을 받았다, 2번 체크
				// 예를 들어 총 8개인데 5번을 받았다, 3번 체크
				int left = stud_num[i] -2;
				int right = stud_num[i];
				while (left >= 0 && right < n && switches[left] == switches[right]) {
					// 대칭인지 확인
					left--;
					right++;
				}

				left++; right--;

				for (int j = left; j <= right; j++) {
					if (switches[j] == 0)
						switches[j] = 1;
					else
						switches[j] = 0;
				}
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			sb.append(switches[i]).append(" ");

			if ((i + 1) % 20 == 0) sb.append("\n");
		}

		System.out.print(sb.toString());
	}
}
