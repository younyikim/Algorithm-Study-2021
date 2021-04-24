package level21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_10816 {
	static int N;
	static int M;
	
	static int[] arr;
	static int[] find;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        for(int i = 0; i < N; i++)
        {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
       
        M = Integer.parseInt(br.readLine());
        find = new int[M];
        
        st = new StringTokenizer(br.readLine(), " ");
        
        for(int i = 0; i < M; i++)
        {
        	int key = Integer.parseInt(st.nextToken());
        	int low = lower_bound(key);
        	int up = upper_bound(key);
        	sb.append(up - low).append(' ');
        } 
        System.out.println(sb);
	} 
	
	public static int lower_bound(int key) {
		int left = 0;
		int right = arr.length - 1;
		int mid;
		
		while(left < right) {
			mid = (left + right) / 2;
			if(arr[mid] >= key) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return right;
	}
	
	public static int upper_bound(int key) {
		int left = 0;
		int right = arr.length - 1;
		int mid;
		
		while(left < right) {
			mid = (left + right) / 2;
			if(arr[mid] > key) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		if(arr[right] == key)
			right++;
		return right;
	}
	
}
