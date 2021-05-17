package level26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_1806 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		int [] arr = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0;
		int end = 0;
		int sum = 0;
		int len = Integer.MAX_VALUE;
		boolean findAns = false;
		
		while(start <= end){
			if(sum >= S) {
				sum -= arr[start++];
				len = Math.min(len, end - start + 1);
				findAns = true;
			} else if(end == N) {
				break;
			} else {
				sum += arr[end++];
			}
		}
		
		if(findAns) {
			System.out.println(len);
		} else {
			System.out.println(0);
		}
	}
}
