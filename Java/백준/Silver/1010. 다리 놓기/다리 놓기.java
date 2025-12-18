import java.io.*;
import java.util.StringTokenizer;
 
public class Main {
	
	private static final int MAX = 31;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		int n = 0 , m = 0;
		StringBuilder sb = new StringBuilder();
		int dp [][] = new int[MAX][MAX];
		
		for(int i = 1 ; i < MAX ; i++) {
			dp[i][0] = 1;
			dp[i][i] = 1;
		} 
		
		for (int i = 2; i < MAX; i++) {
			for (int j = 1; j < MAX; j++) {
				dp[i][j] = dp[i-1][j-1] + dp[i-1][j]; 
			}
		}
				
		for (int i = 0; i < T ; i++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
 
			if(i != T-1) {
				sb.append(dp[m][n]).append("\n");
			}else {
				sb.append(dp[m][n]);
			}
			
			
		}
 
		
		System.out.println(sb.toString());
	} 
}