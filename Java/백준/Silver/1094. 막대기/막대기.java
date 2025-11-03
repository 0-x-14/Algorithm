import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	// 길이가 64인 막대 -> 자름 -> 풀로 붙임 -> 길이 X 막대 완성
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());

		List<Integer> list = new ArrayList<Integer>();
		list.add(64);

		int sum = 64;

		// 가지고 있는 막대 길이 모두 더한 값 > X일 경우 아래 과정 반복
		while (sum > x) {
			// 가지고 있는 막대 중 길이 가장 짧은 것 절반으로 자름
			int min = list.get(0) / 2;
			list.remove(0);

			if ((sum - min) >= x) {
				// 절반 중 하나는 버린 후 남은 막대 합이 X보다 크거나 같다면 절반 중 하나를 버림
				list.add(0, min);
				sum -= min;
			} else {
				// 아닐 경우 절반으로 자른 상태로 그대로 둠
				list.add(0, min);
				list.add(0, min);
			}
		}
		
		System.out.println(list.size());
	}
}
