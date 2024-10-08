import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static int n, connect;
	public static boolean[][] graph;
	public static boolean[] visited;
	public static int count;

	public static void dfs(int x) {
		visited[x] = true; // 방문하였으므로 true로 바꿔준 뒤
		count++;

		for (int i = 1; i <= n; i++) {
			if (!visited[i] && graph[x][i]) {
				// 연결된 노드를 찾은 후 방문하지 않은 상태라면 재귀 호출
				dfs(i);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// 1번 컴퓨터가 바이러스에 걸렸을 때, 연결된 컴퓨터도 모두 감염
		// 컴퓨터 수, 네트워크 상 직접 연결된 컴퓨터 쌍의 수, 네트워크 상에서 직접 연결된 컴퓨터 번호 쌍 주어짐
		// 바이러스에 감염되는 컴퓨터 수 출력하기

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine()); // 컴퓨터의 수
		connect = Integer.parseInt(br.readLine()); // 네트워크 상 직접 연결된 컴퓨터 쌍의 수

		graph = new boolean[n+1][n+1];
		visited = new boolean[n+1];

		int x, y;
		for(int i = 0; i < connect; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			graph[x][y] = true;
			graph[y][x] = true;
		}

		// 입력받은 값을 기준으로 1번부터 DFS 탐색 시작
		dfs(1);

		count -= 1; // 1번 제외 후 출력
		System.out.println(count);
	}
}
