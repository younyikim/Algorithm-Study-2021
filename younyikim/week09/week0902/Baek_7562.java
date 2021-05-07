package level24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Baek_7562 {
	static int[][] chess;
	static boolean[][] check;
	
	static int[] dx = {-2,-1,2,1,2,1,-2,-1};
	static int[] dy = {1,2,1,2,-1,-2,-1,-2};
	
	static int e;
	static int targetX, targetY;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st; 
		for (int i = 0; i < n; i ++) {
			e = Integer.parseInt(br.readLine());
			chess = new int[e][e];
			check = new boolean[e][e];
			
			st = new StringTokenizer(br.readLine(), " "); 
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine(), " "); 
			targetX = Integer.parseInt(st.nextToken());
			targetY = Integer.parseInt(st.nextToken());
			
			
			bfs(x, y);
			sb.append(chess[targetX][targetY]).append('\n');
		}
		System.out.println(sb);
	}
	
	public static void bfs(int x, int y) {
		 Queue<Integer> queue_x = new LinkedList<Integer>(); 
		 Queue<Integer> queue_y = new LinkedList<Integer>();
		
		 if(targetX == x && targetY == y) {
			 return;
		 }
		 queue_x.offer(x); 
		 queue_y.offer(y);
		
		 check[x][y] = true;
		 
		  while(!queue_x.isEmpty()) {
			  int xq = queue_x.poll();
		      int yq = queue_y.poll();
		      
	
			  for(int i = 0; i < 8; i++) {
		            int nx = xq + dx[i];
		            int ny = yq + dy[i];
		            
		            if(nx >= 0  && nx < e && ny >= 0 && ny < e ) {
		            	if(chess[nx][ny] == 0 && check[nx][ny] == false) {
		            		queue_x.offer(nx);
		 		            queue_y.offer(ny);
		 		            
		 		           check[nx][ny] = true;
		 		           chess[nx][ny] = chess[xq][yq] + 1;
		            	}
		            }
		            
		         }
		  }
		
	}
}
