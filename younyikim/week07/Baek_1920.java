package level21;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_1920 {
	
	static int N;
	static int M;
	
	static int[] arr;
	static int[] find;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");; 
        
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
        	find[i] = Integer.parseInt(st.nextToken());
        }
       
        for(int i = 0; i < M; i++)
        {
        	sb.append(binarySearch(find[i], arr)).append('\n');
        } 
        System.out.println(sb);
	} 
	
	public static int binarySearch(int key, int[] A) {
		int mid;
		int left = 0;
		int right = A.length - 1;
		
		while(right >= left) {
			mid = (left + right) / 2;
			if(key == A[mid]) {
				return 1;
			}
			
			if(key < A[mid]) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return 0;
	}
}
