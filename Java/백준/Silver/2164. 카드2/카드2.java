import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	// 1번 카드 제일 위, N번 카드 제일 아래
	// 제일 위에 있는 카드 바닥에 버림 -> 그 다음 위에 있는 카드 제일 아래로 옮김
	// 선입선출 -> 큐로 풀이
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		Queue<Integer> q = new LinkedList<Integer>();

		for (int i = 0; i < n; i++) {
			q.offer(i + 1);
		}

		while (q.size() != 1) {
			q.poll();

			int x = q.poll();
			q.offer(x);
		}

		System.out.println(q.poll());
	}
}