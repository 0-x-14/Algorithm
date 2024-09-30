import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// 회의실 사용표
		// 각 회의 -> 시작 시간, 끝나는 시간 주어짐
		// N개의 회의에 대해 겹치지 않게 사용할 수 있는 최대 개수 찾기
		// 끝나자마자 다른 회의 시작 가능
		// 시작 시간과 끝나는 시간 같을 수 있음 (시작하자마자 끝남)

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] meeting = new int[n][2];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			meeting[i][0] = Integer.parseInt(st.nextToken()); // 시작 시간
			meeting[i][1] = Integer.parseInt(st.nextToken()); // 끝나는 시간
		}

		// 회의 소요 시간이 짧은 순서대로? -> 겹치는데 회의 시간이 동일한 경우 발생 가능하므로 X
		// 회의 끝나는 시간을 기준으로 오름차순 정렬하기

		Arrays.sort(meeting, new Comparator<int[]>() {
			@Override
			public int compare(int[] m1, int[] m2) {
				if (m1[1] == m2[1]) {
					return Integer.compare(m1[0], m2[0]); // 끝나는 시간이 같으면 시작 시간으로 비교
				}
				return Integer.compare(m1[1], m2[1]);
			}
		});

		int count = 0; // 선택 가능한 회의의 최대 개수
		int lastEndTime = 0; // 마지막으로 선택된 회의의 끝나는 시간

		for (int i = 0; i < n; i++) {
			if (lastEndTime <= meeting[i][0]) {
				lastEndTime = meeting[i][1];
				count++;
			}
		}

		System.out.println(count);
	}
}
