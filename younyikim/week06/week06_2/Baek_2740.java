package level20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_2740 {
	 public static void main(String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringBuilder sb = new StringBuilder();
	        
	        // 첫번째 행렬
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        
	        int an = Integer.parseInt(st.nextToken());
	        int am = Integer.parseInt(st.nextToken());
	        
	        int[][] arr = new int[an][am];
	        
	        StringTokenizer t;
	        for(int i = 0; i < an; i++) {
	        	t = new StringTokenizer(br.readLine());
	        	for(int j = 0; j < am; j++) {
	        		arr[i][j] = Integer.parseInt(t.nextToken());
	        	}
	        }
	        
	        // 두번째 행렬
	        StringTokenizer st2 = new StringTokenizer(br.readLine());
	        
	        int bn = Integer.parseInt(st2.nextToken());
	        int bm = Integer.parseInt(st2.nextToken());
	        
	        int[][] arr2 = new int[bn][bm];
	        
	        StringTokenizer t2;
	        for(int i = 0; i < bn; i++) {
	        	t2 = new StringTokenizer(br.readLine());
	        	for(int j = 0; j < bm; j++) {
	        		arr2[i][j] = Integer.parseInt(t2.nextToken());
	        	}
	        }
	        
	        // 행렬 곱셈 계산
	        int[][] res = new int[an][bm];
	        
	        for(int i = 0; i < an; i++) {
	        	for(int j = 0; j < bm; j++) {
	        		for(int k = 0; k < am; k++) {
	        			res[i][j] += arr[i][k] * arr2[k][j];
	        		}
	        		sb.append(res[i][j]).append(" ");
	        	}
	        	sb.append("\n");
	        }
	        
	        System.out.println(sb);
	 }      
}
