import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	// 1번부터 N번까지 풍선을 시계방향 원형으로 놓음
	// 1번 풍선 -> 1번 풍선에 적혀있는 순서의 풍선(양수 오른쪽, 음수 왼쪽) -> 반복

	static class Balloon {
		int id;
		int value;

		Balloon(int id, int value) {
			this.id = id;
			this.value = value;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		ArrayDeque<Balloon> ad = new ArrayDeque<>();

		for (int i = 0; i < n; i++) {
			Balloon balloon = new Balloon(i+1, Integer.parseInt(st.nextToken()));
			ad.add(balloon);
		}

		while (ad.size() > 1) {
			Balloon temp = ad.pollFirst();
			sb.append(temp.id).append(" ");

			int num = temp.value;
			if (num > 0) {
				for (int i = 1; i < num; i++) {
					// 덱의 맨 앞 원소를 빼서 맨 뒤로 보냄
					ad.offerLast(ad.pollFirst());
				}
			} else {
				for (int i = num; i < 0; i++) {
					// 덱의 맨 뒤 원소를 빼서 맨 앞으로 보냄
					ad.offerFirst(ad.pollLast());
				}
			}
		}
		
		sb.append(ad.poll().id);

		System.out.println(sb);
	}
}

