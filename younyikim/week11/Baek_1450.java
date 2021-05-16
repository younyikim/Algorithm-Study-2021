package level26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Baek_1450 {
	static int N, C, idx;
	static ArrayList<Integer> firstSum, lastSum;
	static int [] arr;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new int[N + 1];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		firstSum = new ArrayList<>();
		lastSum = new ArrayList<>();
		
		// start ~ N/2까지 완전 탐색하여 모든 가능한 무게를 arrayList에 각각 저장 
		firstBruteForce(0,0);
		// N/2 ~ end 까지 완전 탐색하여 모든 가능한 무게를 arrayList에 각각 저장 
		lastBruteForce(N / 2, 0);
		
		// firstSum을 기준으로 이진탐색 수행. 기준이 아닌 arrayList를 오름차순으로 정렬 
		Collections.sort(lastSum);
		
		/*
		 * firstSum 각각의 모든 무게에 대해 lastSum 의 무게중 하나를 합쳐 
		 * C보다 작은 lastSum에서의 인덱스를 찾는다. 
		 */
		
		int ans = 0;
		for(int i = 0; i < firstSum.size(); i++) {
			idx = -1;
			binarySearch(0, lastSum.size() - 1, firstSum.get(i));
			ans += (idx + 1);
		}
		System.out.println(ans);
	}
	
	static void firstBruteForce(int i, int sum) {
		if(sum > C) {
			return;
		}
		
		if(i == N / 2) {
			firstSum.add(sum);
			return;
		}
		
		firstBruteForce(i + 1, sum + arr[i]);
		firstBruteForce(i + 1, sum);
	}
	
	static void lastBruteForce(int i, int sum) {
		if(sum > C) {
			return;
		}
		
		if(i == N) {
			lastSum.add(sum);
			return;
		}
		
		lastBruteForce(i + 1, sum + arr[i]);
		lastBruteForce(i + 1, sum);
	}
	
	static void binarySearch(int s, int e, int v) {
		if(s > e) {
			return;
		}
		
		int mid = (s + e) / 2;
		
		if(lastSum.get(mid) + v <= C) {
			idx = mid;
			binarySearch(mid + 1, e, v);
		} else {
			binarySearch(s, mid - 1, v);
		}
	}
}
