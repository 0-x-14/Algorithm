import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	// 스위치 1~N(1<=N<=1,000), i번 스위치는 i의 배수 번호를 가지는 전구 상태를 모두 반전시킴
	// Y는 전구 켜져있는 경우, N은 전구 꺼져있는 경우
	// 모든 전구를 끄기 위해 스위치를 몇 번 눌러야 하는지
	// 만약 모든 전구 끌 수 없으면 -1 출력

	// 낮은 수부터 차례대로 Y인지 N인지 확인
	// Y일 경우 누름
	// num+1은 num에 영향을 미치지 않음.
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] lights = br.readLine().toCharArray();
		int cnt = 0;

		for (int i = 1; i <= lights.length; i++) {
			if (lights[i-1] == 'Y') {
				// Y일 경우 스위치를 누름
				for (int j = 1; j <= (lights.length / i); j++) {
					// i의 배수에 영향을 미침
					// 예를 들어 length가 16이고 i = 3인 경우, 3,6,9,12,15에만 영향을 미침
					// 배열상으로는 2,5,8,11,14번쨰에 영향을 미침
					// j = 1로 정의한 후, i*j-1인 값들을 탐색하면서 (length / j)번 반복
					if (lights[i*j-1] == 'Y')
						lights[i*j-1] = 'N';
					else
						lights[i*j-1] = 'Y';
				}
				cnt++;
			}
		}

		for (int i = 1; i <= lights.length; i++) {
			if (lights[i-1] == 'Y') {
				cnt = -1;
				break;
			}
		}

		System.out.println(cnt);
	}
}