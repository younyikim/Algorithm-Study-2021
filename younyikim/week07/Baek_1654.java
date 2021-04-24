package level21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_1654 {
	static int K;
	static int N;
	
	static int[] arr;
	static int[] find;
	
	static boolean isFirst = true;
	static int last = 0;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[K];

        for(int i = 0; i < K; i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr); 
      
        long left = 1;
        long right = arr[K - 1];
        long mid = 0;
        
        while(left <= right) {
        	long cnt = 0;
        	mid = (left + right) / 2;
        	
        	for (int i = 0; i < K; i++) {
    			cnt += (arr[i] / mid);
    		}
        	
        	if(cnt < N) {
        		right = mid - 1;
        	} else if(cnt >= N) {
        		left = mid + 1;
        	}
        }
        System.out.println(right);
      }
	
}
