import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Deque<Integer> deque = new ArrayDeque<>();

		for (int i = 0; i < n; i++) {
			String[] str = br.readLine().split(" ");
			switch (str[0]) {
				case "push_front": {
					deque.addFirst(Integer.parseInt(str[1]));
					break;
				}
				case "push_back": {
					deque.addLast(Integer.parseInt(str[1]));
					break;
				}
				case "pop_front": {
					if (deque.isEmpty()) {
						System.out.println(-1);
					} else {
						System.out.println(deque.pollFirst());
					}
					break;
				}
				case "pop_back": {
					if (deque.isEmpty()) {
						System.out.println(-1);
					} else {
						System.out.println(deque.pollLast());
					}
					break;
				}
				case "size": {
					System.out.println(deque.size());
					break;
				}
				case "empty": {
					System.out.println(deque.isEmpty() ? 1 : 0);
					break;
				}
				case "front": {
					if (deque.isEmpty()) {
						System.out.println(-1);
					} else {
						System.out.println(deque.getFirst());
					}
					break;
				}
				case "back": {
					if (deque.isEmpty()) {
						System.out.println(-1);
					} else {
						System.out.println(deque.getLast());
					}
					break;
				}
			}
		}
	}
}
