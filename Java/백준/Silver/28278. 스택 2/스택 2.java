import java.io.*;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();

		int N = Integer.parseInt(br.readLine());

		while(N --> 0){
			String query = br.readLine();
			char c = query.charAt(0);

			switch (c){
				case '1' : stack.push(Integer.parseInt(query.substring(2))); break;
				case '2' : sb.append(stack.isEmpty() ? -1 : stack.pop()).append("\n"); break;
				case '3' : sb.append(stack.size()).append("\n"); break;
				case '4' : sb.append(stack.isEmpty() ? 1 : 0).append("\n"); break;
				case '5' : sb.append(stack.isEmpty() ? -1 : stack.peek()).append("\n"); break;
				default: break;
			}
		}

		br.close();

		System.out.println(sb);
	}
}
