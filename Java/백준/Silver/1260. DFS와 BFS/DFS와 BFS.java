import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int n, m, v;
	public static boolean[][] graph;
	public static boolean[] visited;
	public static Queue<Integer> queue;

	public static void main(String[] args) throws IOException {
		// DFS, BFS 구현
		// 방문 가능 정점이 여러 개일 경우 정점 번호가 작은 것 먼저 방문

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());

		graph = new boolean[n+1][n+1];

		int x, y;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			graph[x][y] = true;
			graph[y][x] = true;
		}

		visited = new boolean[n+1];
		dfs(v);
		System.out.print("\n");

		visited = new boolean[n+1];
		bfs(v);
	}

	public static void dfs(int x) {
		visited[x] = true;
		System.out.print(x + " ");

		for (int i = 1; i <= n; i++) {
			if (!visited[i] && graph[x][i]) {
				dfs(i);
			}
		}
	}

	public static void bfs(int x) {
		queue = new LinkedList<>();
		queue.add(x);
		visited[x] = true;

		System.out.print(x + " ");

		while (!queue.isEmpty()) {
			int current = queue.poll(); // 큐의 첫 번째 요소 삭제 및 반환

			for (int i = 1; i <= n; i++) {
				if (!visited[i] && graph[current][i]) {
					queue.add(i);
					visited[i] = true;
					System.out.print(i + " ");
				}
			}
		}
	}
}
