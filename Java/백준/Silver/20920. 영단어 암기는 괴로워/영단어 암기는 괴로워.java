import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 단어의 개수
		int m = Integer.parseInt(st.nextToken()); // 외울 단어의 길이 기준, 10 이하, m 이하의 단어는 외우지 않음
		
		HashMap<String, Integer> hashmap = new HashMap<String, Integer>(n);
		
		while (n-- > 0) {
			String word = br.readLine();
			if (word.length() >= m) {
				hashmap.put(word, hashmap.getOrDefault(word, 0) + 1);
			}
		}
		
		// 자주 나오는 단어일수록 > 단어의 길이가 길수록 > 알파벳 사전 순으로 앞일수록
		String word_cnt = "a";
		int word_length = 10;
		
		List<String> list = new ArrayList<>(hashmap.keySet());
		
		list.sort((o1, o2) -> {
			int c1 = hashmap.get(o1); // 빈도수
			int c2 = hashmap.get(o2); // 빈도수
			
			if (c1 == c2) {
				if (o1.length() == o2.length()) {
					return o1.compareTo(o2);
				}
				return o2.length() - o1.length();
			}
			return c2 - c1;
		});
		
		
		for (int i = 0; i < list.size(); i++) {
			bw.write(list.get(i) + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}
