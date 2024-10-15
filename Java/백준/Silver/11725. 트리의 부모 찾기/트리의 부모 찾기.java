import java.io.*;
import java.util.*;

public class Main {
	public static boolean[] visited;
	public static ArrayList<Integer>[] list;
	public static int[] parent;

	public static void main(String[] args) throws IOException {
		// 트리의 루트 1로 고정
		// 첫째줄에 노드의 개수 n, 둘째줄부터 트리상에 연결된 두 정점 주어짐
		// 2번 노드부터 각 노드의 부모 노드 차례대로 출력하기

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		// 각 노드들의 관계를 저장할 인접리스트 생성
		list = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			list[a].add(b);
			list[b].add(a);
		}

		visited = new boolean[n + 1];
		parent = new int[n + 1];

		dfs(1);

		for (int i = 2; i <= n; i++) {
			System.out.println(parent[i]);
		}
	}

	public static void dfs(int x) {
		visited[x] = true;

		for (int vertex: list[x]) {
			if (!visited[vertex]) {
				parent[vertex] = x;
				dfs(vertex);
			}
		}
	}
}
