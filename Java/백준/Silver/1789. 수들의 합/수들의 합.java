import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	// 1부터 가장 작은 수들부터 더해간 뒤, 그 합이 s를 초과하면 초과한만큼만 빼주면 됨
	// ex) s = 13일 경우, 1+2+3+4+5=15 -> 여기서 2만 빼주면 됨
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long s = Long.parseLong(br.readLine());
		// s는 1보다 크고, 4,294,967,295보다 작으므로 long으로 처리함
		long num = 0, n = 0;

		for (long i = 1; ; i++) {
			// s = 1인 경우를 고려하여 i < s라는 조건은 삭제함
			num += i;
			n++;
			if (num >= s) {
				if (num > s) {
					// num이 s를 초과했다면, 초과한만큼 자연수 하나를 빼야하기 때문에 n--를 해줌
					// num == s일 경우 그대로 n값을 출력하면 됨
					n--;
				}
				break;
			}
		}

		System.out.println(n);
	}
}
