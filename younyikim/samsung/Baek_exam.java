package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Baek_exam {
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		long cnt = 0; // 감독관 수
		int[] a = new int[n]; // 응시자 수
		
		StringTokenizer st = new StringTokenizer(br.readLine(), "");
		for(int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		int b = Integer.parseInt(br.readLine()); // 총감독이 맡을 수 있는 사람수
		int c = Integer.parseInt(br.readLine()); // 부감독이 맡을 수 있는 사람수
		
		for(int i = 0; i < n; i++) {
			a[i] -= b; // 총 응시자 수에서 총 감독이 맟을 수 있는 응시자 만큼 빼준다.
			cnt++;
			
			// 총 감독이 맡을 수 있는 경우는 부감독 필요 없으므로 넘어감
			if(a[i] <= 0) {
				continue;
			}
			// 부감독이 추가로 필요한 경우
			else {
				cnt += a[i] / c;
				// 나머지가 0보다 크면 부감독 한명 더 추가
				if(a[i] % c > 0) {
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}
}
