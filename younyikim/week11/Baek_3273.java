package level26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_3273 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int [] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int X = Integer.parseInt(br.readLine());
		Arrays.sort(arr);
		
		
		int start = 0, end = N - 1, cnt = 0;
		
		while(start != end) {
			if(arr[start] + arr[end] == X) {
				cnt++;
				start++;
			} else if(arr[start] + arr[end] > X) {
				end --;
			} else {
				start++;
			}
		}
		System.out.println(cnt);
	}
}
