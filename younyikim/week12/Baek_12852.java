package level27;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baek_12852 {
	
	private static final int INF = 1_000_000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int X = Integer.parseInt(br.readLine());
		int dp[] = new int[X + 1];
		
		Arrays.fill(dp, INF);
		dp[X] = 0;
		
		for(int i = X; i >= 1; i--) {
			int minValue = dp[i] + 1;
			
			if(i % 3 == 0) {
				dp[i / 3] = Math.min(dp[i / 3], minValue);
			} 
            if(i % 2 == 0) {
				dp[i / 2] = Math.min(dp[i / 2], minValue);
			}
			dp[i - 1] = Math.min(dp[i - 1], minValue);
		}
		
		sb.append(dp[1] + "\n");
				
		// 역추적 
        int minValue = dp[1];
        Stack<Integer> stack = new Stack<>();

        for(int i = 1; i <= X; i++){
            if(minValue == dp[i]){
                stack.push(i);

                // 3배의 수의 dp값이 dp[i] - 1과 같은 경우
                if(i * 3 <= X && dp[i * 3] == minValue - 1)
                    // i값은 3배인 수로 변경
                    i = i * 3 - 1;
                // 2배의 수의 dp값이 dp[i] - 1과 같은 경우
                else if(i * 2 <= X && dp[i * 2] == minValue - 1){
                    i = i * 2 - 1;
                }else if(i + 1 <= X && dp[i + 1] == minValue - 1){

                }

                minValue--;
            }
        }
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop() + " ");
		}
		bw.write(sb.toString());

        bw.close();
        br.close();
	}
}
