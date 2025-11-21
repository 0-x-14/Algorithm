/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	// 빌딩 정보 -> 조망권 확보된 세대 수 반환
	// 왼쪽, 오른쪽 창문 모두 거리 2 이상의 공간 확보되어야 함
	// 맨 왼쪽 두 칸과 맨 오른쪽 두 칸은 항상 높이 0
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int n = sc.nextInt();
			int[] buildings = new int[n];
			int cnt = 0;

			for (int i = 0; i < n; i++) {
				buildings[i] = sc.nextInt();
			}

			for (int i = 2; i < (n-2); i++) {
				if (buildings[i] > buildings[i-1] && buildings[i] > buildings[i-2]
					&& buildings[i] > buildings[i+1] && buildings[i] > buildings[i+2]) {
					cnt += buildings[i] - Math.max(Math.max(buildings[i-1], buildings[i-2]), Math.max(buildings[i+1], buildings[i+2]));
				}
			}

			System.out.println("#" + test_case + " " + cnt);
		}
	}
}