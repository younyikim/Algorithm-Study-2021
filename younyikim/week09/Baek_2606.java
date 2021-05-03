package level24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Baek_2606 {
  	static int cnt = 0; // 감염시킨 컴퓨터 수
  	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int e = Integer.parseInt(br.readLine());
		
		int a[][] = new int[n+1][n+1]; 
		boolean check[] = new boolean[n+1]; 
	
		StringTokenizer st; 
		for(int i = 0;i < e; i++) { 
			st = new StringTokenizer(br.readLine(), " ");
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			a[v1][v2] = 1;
			a[v2][v1] = 1;
		}
			
		dfs(a,check,1); 
		
		System.out.println(cnt-1); 
	  }
	
	static void dfs(int[][] a, boolean[] check, int v) {
		if(check[v] == true) {
			return; 
		}
		check[v] = true; 
		cnt++; // 감염된 컴퓨터 수 증가, 여기엔 최초 방문 1번 컴퓨터도 포함된다.
		
		for(int i = 0;i < a[v].length; i++) { // 인접행렬을 탐색
			if(a[v][i] == 1 && !check[i]) // 연결된 정점이면서 방문하지 않은 경우
				dfs(a,check,i); 
		}				
	}
    
}
 