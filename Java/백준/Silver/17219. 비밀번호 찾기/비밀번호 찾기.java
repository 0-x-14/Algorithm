import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 저장된 사이트의 수
		int m = Integer.parseInt(st.nextToken()); // 비밀번호를 찾으려는 사이트의 수
		
		HashMap<String, String> hashmap = new HashMap<String, String>(n);
		
		while (n-- > 0) {
			st = new StringTokenizer(br.readLine());
			String site = st.nextToken(); // 사이트 주소, 중복 없음
			String password = st.nextToken(); // 해당 사이트 주소의 비밀번호
			hashmap.put(site, password);
		}
		
		while (m-- > 0) {
			String find = br.readLine();
			bw.append(hashmap.get(find) + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}
