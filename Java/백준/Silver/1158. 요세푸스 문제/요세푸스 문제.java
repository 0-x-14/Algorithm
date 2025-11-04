import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	// n명의 사람이 원을 이루며 앉아있을 때, 순서대로 k번째 사람을 제거해감
	// 이때 제거되는 사람의 순서, 즉 요세푸스 순열을 출력할 것
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		// 값을 제거해나가야 하기 때문에 배열이 아닌 리스트로 구현
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			list.add(i + 1);
		}

		// 요세푸스 순열 결과를 저장하는 배열
		int[] yo = new int[n];
		int cnt = 0;

		for (int i = 0; i < n; i++) {
			cnt += k; // 5
			while (cnt > list.size()) {
				// 만약 cnt가 리스트 길이보다 크다면 리스트 길이값만큼 빼준다.
				// ex) 리스트에 (1, 4)만 남았는데 cnt가 5일 경우, 2번 실행해서 cnt를 1로 만들어야 함
				cnt -= list.size();
			}

			yo[i] = list.get(cnt-1);
			list.remove(cnt-1);
			cnt -= 1;
		}

		System.out.print("<");
		for (int i = 0; i < n-1; i++) {
			System.out.print(yo[i] + ", ");
		}
		System.out.println(yo[n-1] + ">");
	}
}