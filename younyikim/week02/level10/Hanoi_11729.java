package week02.level10;
import java.io.*;

/*
 * 1. 원반 1개일때, 바로 옮기고 종료(종료 조건)
 * 2. 1) 원반이 n개 일 때, 원반 n-1개를 1번 기둥(start)에서 2번 기둥(end)으로 옮김. (3번기둥-stopover)
 * 	  2) 1번 기둥에 남은 가장 큰 원반을 3번 기둥으로 옮김.
 *    3) 2번 기둥(start)에 남아있는 N-1개의 원반을 다시 3번(end)으로 옮김.(1번기둥-stopover)	
 * */
public class Hanoi_11729 {
	static int count = 0;
	static StringBuilder sb = new StringBuilder();

	static void hanoi(int start, int stopover, int end, int n) {
		if (n == 1) {
			move(start, end, n);
			return;
		}
		else {
			hanoi(start, end, stopover, n -1);
			move(start, end, stopover);
			hanoi(stopover, start, end, n -1);
		}
	}
	static void move(int start, int end, int n) {
		sb.append(start);
		sb.append(' ');
		sb.append(end);
		sb.append('\n');
		count++;
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		hanoi(1, 2, 3, n);
		System.out.println(count);
		System.out.print(sb);
	}

}
