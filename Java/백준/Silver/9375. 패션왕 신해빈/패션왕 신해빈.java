import java.io.*;
import java.util.*;

public class Main {
	// 한 번 입었던 옷들의 조합 재착용 X
	// 종류별로 옷 개수 + 1해서 종류만큼 곱한다음 - 1 (아무것도 안 입는 경우)
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(br.readLine());
		
		while (test_case-- > 0) {
			int n = Integer.parseInt(br.readLine());
			
			HashMap<String, Integer> hashmap = new HashMap<String, Integer>(n);
			
			for (int i = 0; i < n; i++) {
				// 의상 이름, 종류 주어짐
				StringTokenizer st = new StringTokenizer(br.readLine());
				String name = st.nextToken();
				String type = st.nextToken();
				
				if (hashmap.containsKey(type)) {
					hashmap.put(type, hashmap.get(type) + 1);
				} else {
					hashmap.put(type, 1);
				}
			}
			
			int sum = 1;
			for (String key: hashmap.keySet()) { // hashmap만큼 순회
				sum *= (hashmap.get(key) + 1);
			}
			
			System.out.println(sum - 1);
		}
	}
}