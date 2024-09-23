import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // a를 b로 바꾸려고 함. 2를 곱하거나 1을 수의 가장 오른쪽에 추가
        // a를 b로 바꾸는데 필요한 최솟값에 +1 출력
        // 만들 수 없는 경우에는 -1 출력

        Scanner sc = new Scanner(System.in);

        // 1 <= a < b <= 10^9
        int a = sc.nextInt();
        int b = sc.nextInt();

        // b -> a로 찾는 식으로 풀이
        // b의 일의 자리 수가 1이라면 b의 가장 오른쪽 1을 제거
        // b가 짝수라면 2로 나눔
        // 해당 과정 반복, 둘 다 해당하지 않는 값이 나오거나 b가 0이 되면 -1 출력

        int num = 0;
        boolean possible = true;

        while (b != a) {
            if (b % 10 == 1 && b / 10 > 0) {
                b /= 10;
            } else if (b % 2 == 0) {
                b /= 2;
            } else {
                System.out.println(-1);
                possible = false;
                break;
            }
            num += 1;
        }

        if (possible) {
            System.out.println(num + 1);
        }
    }
}
