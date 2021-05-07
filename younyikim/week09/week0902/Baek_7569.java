package level24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point2 {
	int x, y, z, day;
	public Point2(int x, int y, int z, int day) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.day = day;
	}
}

public class Baek_7569 {
	static int[][][] tomato;
	static int[] dx = {-1, 0, 1, 0, 0, 0}; 
	static int[] dy = {0, 1, 0, -1, 0, 0};
	static int[] dz = {0, 0, 0, 0, -1, 1};
	
	static int N;
	static int M;
	static int H;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		tomato = new int[H][M][N]; 
	
		for (int h = 0; h < H; h++) {
			for(int i = 0; i < M; i++) { 
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					tomato[h][i][j] = Integer.parseInt(st.nextToken());
				}
			}
		}
		bfs();
	}
	
	private static void bfs() {
		Queue<Point2> queue = new LinkedList<>();
		int day = 0;
		
		// 토마토가 있는 좌표를 Queue에 넣는다.
		for (int h = 0; h < H; h++) {
			for(int i = 0; i < M; i++) { 
				for (int j = 0; j < N; j++) {
					if(tomato[h][i][j] == 1) {
						queue.offer(new Point2(i,j,h,0));
					}
				}
			}
		}
		
		while(!queue.isEmpty()) {
			Point2 point = queue.poll();
			day = point.day;
			
			//bfs를 돌면서 상하좌우에 있는 토마토를 익힌다.
			for(int i = 0; i < 6; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];
                int nz = point.z + dz[i];
 
                if(0 <= nx && nx < M && 0 <= ny && ny < N && nz >= 0 && nz < H) {
                	if(tomato[nz][nx][ny] == 0) {
                		tomato[nz][nx][ny] = 1;
                		queue.offer(new Point2(nx, ny, nz, day + 1));
                	}
                }
                
             }
		}
		
		
		if(checkTomato()) {
			System.out.println(day);
		} else {
			System.out.println(-1);
		}
	}
	
	// tomato 배열 중 0이 남아있으면 -> false || 아니면 true
		static boolean checkTomato() {
			for (int h = 0; h < H; h++) {
				for(int i = 0; i < M; i++) {
			         for(int j = 0; j < N; j++) {
			        	 if(tomato[h][i][j] == 0)
				            	return false;
			        }
				 }
			}
			 
			 return true;
		}
}
