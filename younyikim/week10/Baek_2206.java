package level24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Map {
	int x, y, wall, dis;
	public Map(int x, int y, int dis,int wall) {
		this.x = x;
		this.y = y;
		this.dis = dis; // 이동거리
		this.wall = wall; // 벽을 부순 횟수
	}
}
public class Baek_2206 {
	static int[][] arr;
	static int[][] visit;
	static int n, m, distance;
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		visit = new int[n][m];
		
		 for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String temp = st.nextToken(); 
			    
			for(int j = 0; j < m; j++) {
			   arr[i][j] = (int)temp.charAt(j) - 48; 
			   visit[i][j] = Integer.MAX_VALUE;
			}
		}
	
		distance = Integer.MAX_VALUE;
		bfs(0,0);
		
		if(distance == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(distance);
		}
	}
	public static void bfs(int x, int y) {
		Queue<Map> q = new LinkedList<>(); 
		q.offer(new Map(0,0,1,0));
		visit[0][0] = 0;
		
		while(!q.isEmpty()) {
			Map map = q.poll();
			
			//도착지점을 만나면 종료
			if(map.x == n - 1 && map.y == m - 1) {
				distance = map.dis;
				return;
			}
			
			for(int i = 0; i < 4; i++) {
                int nx = map.x + dx[i];
                int ny = map.y + dy[i];
                
              
                if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
                	if(visit[nx][ny] <= map.wall) {
                    	continue;
                    }
                	
                	//벽이 아닐때 
                	if(arr[nx][ny] == 0) {
                		visit[nx][ny] = map.wall;
                		q.add(new Map(nx, ny, map.dis + 1, map.wall));
                	}
                	//벽일때
                	else {
                		if(map.wall == 0) {
                			visit[nx][ny] = map.wall + 1;
                			q.add(new Map(nx, ny, map.dis + 1, map.wall + 1));
                		}
                	}
                }
                
			}
		}
	}
}
