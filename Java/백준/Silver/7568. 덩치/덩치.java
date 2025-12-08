import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		
		int[][] students = new int[n][3];
	
		
		for(int i=0 ; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			students[i][0] = weight;
			students[i][1] = height;
			students[i][2] = 1;
		}
		
		for(int i=0 ; i<n ;i++) {
			for(int j=0 ;j<n; j++){
				if( j==i || students[i][0] == students[j][0]) continue; 				
				if(students[i][0] > students[j][0] && students[i][1] > students[j][1]){
					students[j][2] = students[j][2]+1;  
				}
			}			
		}
		for(int[] info : students)
			bw.write(info[2]+" ");
		
		bw.flush();
		bw.close();
		br.close();

	}

}