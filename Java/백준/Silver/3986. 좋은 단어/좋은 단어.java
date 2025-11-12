import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringTokenizer st;
		Stack<Character> stack;
		Stack<Character> prev;
		int cnt = 0;

		while (n-- > 0) {
			stack = new Stack<>();
			prev = new Stack<>();
			st = new StringTokenizer(br.readLine());

			// 만약 조건 충족 X인 부분이 발견된다면 이번 루프를 건너뜀
			boolean skip = false;

			while (st.hasMoreTokens()) {
				String token = st.nextToken();

				if (token.length() % 2 == 1) {
					// token의 길이가 홀수일 경우 좋은 단어일 수 X
					// 짝이 맞지 않기 때문
					skip = true;
					break;
				}

				for (int i = 0; i < token.length(); i++) {
					stack.push(token.charAt(i));
				}
			}

			if (skip) continue;

			while (!stack.isEmpty()) {
				if (prev.isEmpty()) {
					prev.push(stack.pop());
				} else if (stack.peek() == prev.peek()) {
					// 이전에 pop된 원소와 쌍을 이루는 경우
					// 각 원소를 pop한 후 정상적으로 넘어감
					prev.pop();
					stack.pop();
				} else {
					// 이전에 pop된 원소와 쌍을 이루지 않는 경우 (AB, BA)
					// 일단 한 번 더 prev에 push해서 저장함
					prev.push(stack.pop());
				}
			}

			if (prev.isEmpty())
				cnt++;
		}

		System.out.println(cnt);
	}
}