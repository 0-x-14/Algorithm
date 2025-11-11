import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	// Queue에서 가장 앞에 있는 문서의 중요도 확인
	// -> 나머지 문서 중 중요도 더 높은 문서가 있다면 가장 앞에 있는 문서 출력 X, 가장 뒤로 재배치
	// 큐에 있는 문서의 수와 중요도가 주어짐 -> 어떤 문서가 몇 번째로 인쇄되는지
	// 테스트 케이스 수 t, 문서의 개수 n,현재 큐에서 몇 번째에 놓여져있는지 m
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			// queue에는 인덱스와 중요도 저장, pq에는 중요도만 저장함
			Queue<int[]> queue = new LinkedList<>();
			PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < n; i++) {
				int importance = Integer.parseInt(st.nextToken());
				queue.add(new int[] {i, importance});
				pq.add(importance);
			}

			int cnt = 0;

			while (!queue.isEmpty()) {
				int[] current = queue.poll();
				if (current[1] == pq.peek()) { // 가장 중요도가 높은 문서인지 확인
					pq.poll();
					cnt++;

					if (current[0] == m) {
						System.out.println(cnt);
						break;
					}
				} else {
					// 중요도가 높지 않은 문서라면 poll한 것을 그대로 맨뒤에 삽입해줌
					queue.add(current);
				}
			}
		}
	}
}