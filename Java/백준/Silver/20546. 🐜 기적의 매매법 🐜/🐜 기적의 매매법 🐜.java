import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// 준현 - 살 수 있으면 바로 최대한 구매
		// 성민 - 가격이 3일 연속 올랐다면 전량 매도함
		// 성민 - 가격이 3일 연속 떨어졌다면 전량 매수함
		// 성민 - 가격이 동일한 경우는 상승 혹은 하락했다고 판단하지 않음
		// 14일간 한 기업으로만 내기, 초기 자금 동일함
		// 더 많은 자산 보유한 사람 승리, (현금 + 1월 14일의 주가 X 주식 수)

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int money = Integer.parseInt(br.readLine()); // 초기 자금
		int[] machineDuck = new int[14]; // MachineDuck의 14일 간의 주가
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < 14; i++) {
			machineDuck[i] = Integer.parseInt(st.nextToken());
		}

		int m1 = money; // 준현이가 보유하고 있는 현금
		int s1 = 0; // 준현이가 보유하고 있는 주식 수
		int m2 = money; // 성민이가 보유하고 있는 현금
		int s2 = 0; // 성민이가 보유하고 있는 주식 수

		for (int i = 0; i < 14; i++) {
			if (m1 / machineDuck[i] > 0) { // 준현이는 구매 가능하면 바로 구매함
				int stocksToBuy = m1 / machineDuck[i];
				s1 += stocksToBuy;
				m1 -= stocksToBuy * machineDuck[i];
			}

			if (i >= 3 && s2 > 0 && machineDuck[i-3] < machineDuck[i-2] && machineDuck[i-2] < machineDuck[i-1] && machineDuck[i-1] < machineDuck[i]) {
				// 3일 연속 가격이 상승했을 경우 전량 매도함
				m2 += s2 * machineDuck[i];
				s2 = 0;
			}

			if (i >= 3 && m2 / machineDuck[i] > 0 && machineDuck[i-3] > machineDuck[i-2] && machineDuck[i-2] > machineDuck[i-1] && machineDuck[i-1] > machineDuck[i]) {
				// 3일 연속 가격이 하락했을 경우 전량 매수함
				int stocksToBuy = m2 / machineDuck[i];
				s2 += stocksToBuy;
				m2 -= stocksToBuy * machineDuck[i];
			}
		}

		m1 += s1 * machineDuck[13];
		m2 += s2 * machineDuck[13];

		if (m1 > m2) {
			System.out.println("BNP");
		} else if (m1 < m2) {
			System.out.println("TIMING");
		} else {
			System.out.println("SAMESAME");
		}
	}
}
