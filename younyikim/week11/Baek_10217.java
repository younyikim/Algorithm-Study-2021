package level25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * dp[i][j] = 시작 공할부터 i공항까지 j의 비용을 소비하여 이동한 시간 중 최소시간
 * 다익스트라 알고리즘을 사용하여 dp[n][0]~dp[n][m] 중 가장 작은 값을 구하면 된다.
 */
public class Baek_10217 {
	static List<Airport>[] graph;	
	static int[][] dp;
	static final int INF = Integer.MAX_VALUE / 2;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int tc = Integer.valueOf(st.nextToken());
		StringBuilder sb = new StringBuilder();
		
		while(tc --> 0) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.valueOf(st.nextToken());
			int m = Integer.valueOf(st.nextToken());
			int k = Integer.valueOf(st.nextToken());
			dp = new int[n + 1][m + 1];	// i : i번 공항까지의 경로, j : 비용 j만큼 소모함, 값 : 가장 작은 시간 (최단시간)   
			graph = new ArrayList[n + 1];
			
			for(int i = 1; i <= n; i++) {
				graph[i] = new ArrayList<Airport>();
				Arrays.fill(dp[i], INF);
			}
			
			// 공항 정보 입력받음 
			for(int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.valueOf(st.nextToken());
				int v = Integer.valueOf(st.nextToken());
				int c = Integer.valueOf(st.nextToken()); // 비용 
				int d = Integer.valueOf(st.nextToken()); // 소요시간 
				graph[u].add(new Airport(v, c, d));
			}
			
			dijkstra(n, m, 1);	
			
			int min = INF;
			for(int i = 0; i <= m; i++) { // 최소 시간
				min = Math.min(min, dp[n][i]);
			}
			
			if(min == INF) { // 도착하지 못했을 때 
				sb.append("Poor KCM");
			}
			else {
				sb.append(min);
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	static void dijkstra(int n, int m, int start) {
		PriorityQueue<Airport> pq = new PriorityQueue<Airport>();
		pq.offer(new Airport(start, 0, 0));
		dp[start][0] = 0;	// 1번 공항까지 0원을 소모했을 때, 최단시간은 0.
		
		while(!pq.isEmpty()) {
			Airport airport = pq.poll();
			int nowAirport = airport.number;
			int nowMoney = airport.money;
			int nowTime = airport.time;
			
			if(nowAirport == n) { // 최단 시간에 목적지 도착. 
				break;
			}
			
			for(Airport air : graph[nowAirport]) {
				int nextNum = air.number;
				int nextMoney = air.money + nowMoney;
				int nextTime = air.time + nowTime;
				
				if(nextMoney > m) {
					continue;
				}
				
				if(dp[nextNum][nextMoney] <= nextTime) {	// 이미 해당 금액으로 해당 번 공항으로 왔을 때의 최소 시간보다 크면 업데이트할 의미가 없다. 
					continue;
				}
				
				// 불필요한 삽입 방지를 위해 그 이상의 모든 값에 현재 최단시간 값을 설정해준다.
                for(int j = nextMoney; j <= m; j++){
                    if(dp[nextNum][j] > nextTime) {
                    	dp[nextNum][j] = nextTime;
                    }
                }
                
				dp[air.number][nextMoney] = nextTime;
				pq.offer(new Airport(air.number, nextMoney, nextTime));
			}
		}
	}
}

class Airport implements Comparable<Airport> {
	int number;
	int money;
	int time;
	
	
	Airport(int number, int money, int time) {
		this.number = number;
		this.time = time;
		this.money = money;
	}
	
	@Override
	public int compareTo(Airport o) {
		if(this.time < o.time) {
			return -1;
		}
		else if(this.time == o.time) {
			if(this.money < o.money) {
				return -1;
			}
			return 0;
		}
		return 1;
	}
}