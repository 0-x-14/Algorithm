import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());

		HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>(n);

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			// 입력값 받으면서 hashmap에 저장할 때 바로 개수 세서 반영
			int num = Integer.parseInt(st.nextToken());
			if (hashmap.get(num) == null)
				hashmap.put(num, 1);
			else
				hashmap.put(num, hashmap.get(num)+1);
		}

		int m = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (hashmap.get(num) == null)
				sb.append(0 + " ");
			else
				sb.append(hashmap.get(num) + " ");
		}

		System.out.print(sb);
	}
}
