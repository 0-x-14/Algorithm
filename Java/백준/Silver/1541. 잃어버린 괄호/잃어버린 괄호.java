import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 숫자, +, -로 입력값 주어짐
        // 처음, 마지막은 무조건 숫자
        // 연속해서 두 개 이상의 연산자 X, 5자리 이상 연속하는 숫자 X
        // 괄호 적절히 쳐서 최솟값 만들도록

        Scanner sc = new Scanner(System.in);

        // 뺄셈 기호를 기준으로!!!
        // 최솟값을 만들기 위해서는 빼는 값이 커져야 함

        int sum = Integer.MAX_VALUE;

        // 뺄셈 기호를 기준으로 분리
        String[] sub = sc.nextLine().split("-");

        for (int i = 0; i < sub.length; i++) {
            int temp = 0;

            // 덧셈 기호를 기준으로 분리
            String[] add = sub[i].split("\\+");

            for (int j = 0; j < add.length; j++) {
                temp += Integer.parseInt(add[j]); // 덧셈 기호로 연결된 수식 계산
            }

            if (sum == Integer.MAX_VALUE) {
                sum = temp; // 입력값의 첫 번째는 무조건 수식 기호가 아니라 숫자이므로
            } else {
                sum -= temp;
            }
        }

        System.out.println(sum);
    }
}
