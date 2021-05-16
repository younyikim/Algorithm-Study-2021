package level26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baek_1644 {
	static int idx = 0;
	static ArrayList<Integer> arr = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

		// 소수 구하기 : 에라토스테네스의 체 (일반적 소수 구하기 방법으로는 시간초과)
		int count = 0;

		boolean arrcheck[] = new boolean[N + 1];

		arrcheck[0] = arrcheck[1] = true;
		for (int i = 2; i * i <= N; i++) {
			if (!arrcheck[i]) {
				for (int j = i * i; j <= N; j += i) {
					arrcheck[j] = true;
				}
			}
		}
		for (int i = 1; i <= N; i++) {
			if (!arrcheck[i]) {
				arr.add(i);
			}
		}
		
		// 연속합으로 주어진 정수를 구할 수 있는지 판별 
		int start = 0;
		int end = 0;
		int sum = 0;
		int cnt = 0;
		
		while(true){
			if(sum >= N) {
				sum -= arr.get(start++);
			} else if(end == arr.size()) {
				break;
			} else {
				sum += arr.get(end++);
			}
			
			if(sum == N) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
	}
	
}
