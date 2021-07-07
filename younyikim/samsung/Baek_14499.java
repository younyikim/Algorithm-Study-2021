package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_14499 {
	static int N, M, X, Y, K;
	static int[][] map;
	static int[] order;
	static int[] dice = {0, 0, 0, 0, 0, 0};
	
	static int dx[] = {0, 0, -1, 1};
	static int dy[] = {1, -1, 0, 0};
	
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		order = new int[K];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < K; i++) {
			order[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < K; i++) {
			int idx = order[i] - 1;
			int nx = X + dx[idx];
			int ny = Y + dy[idx];
			
			if(ny < 0 || ny >= M || nx < 0 || nx >= N) {
				nx = X - dx[idx];
				ny = Y - dy[idx];
				continue;
			}
			
			moveDice(idx + 1);
			
			if(map[nx][ny] == 0) {
				map[nx][ny] = dice[5];
			} else {
				dice[5] = map[nx][ny];
				map[nx][ny] = 0;
			}
			
			X = nx;
			Y = ny;
			
			System.out.println(dice[0]);
		}
	}
	
	public static void moveDice(int order) {
		int rollDice[] = new int[6];
		
		switch(order) {
			case 1 : // 悼率
				rollDice[0] = dice[2];
				rollDice[1] = dice[0];
				rollDice[2] = dice[5];
				rollDice[3] = dice[3];
				rollDice[4] = dice[4];
				rollDice[5] = dice[1];
				break;
			case 2 : // 辑率
				rollDice[0] = dice[1];
				rollDice[1] = dice[5];
				rollDice[2] = dice[0];
				rollDice[3] = dice[3];
				rollDice[4] = dice[4];
				rollDice[5] = dice[2];
				break;
			case 3 : // 合率
				rollDice[0] = dice[4];
				rollDice[1] = dice[1];
				rollDice[2] = dice[2];
				rollDice[3] = dice[0];
				rollDice[4] = dice[5];
				rollDice[5] = dice[3];
				break;
			case 4 : // 巢率
				rollDice[0] = dice[3];
				rollDice[1] = dice[1];
				rollDice[2] = dice[2];
				rollDice[3] = dice[5];
				rollDice[4] = dice[0];
				rollDice[5] = dice[4];
				break;	
			default :
				break;
		}
		
		for(int i = 0; i < 6; i++) {
			dice[i] = rollDice[i];
		}
	}
}
