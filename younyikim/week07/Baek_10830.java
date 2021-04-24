package level20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_10830 {
	 static  StringBuilder sb = new StringBuilder();
	 static int N;
     static long B;
     
     static int[][] arr;
     static int[][] res;
     
	 public static void main(String[] args) throws IOException{
	     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	      // Çà·Ä
	      StringTokenizer st = new StringTokenizer(br.readLine());
	      
	      N = Integer.parseInt(st.nextToken());
	      B = Long.parseLong(st.nextToken());
	        
	      arr = new int[N][N];
          res = new int[N][N];
	        
          StringTokenizer t;
	      for(int i = 0; i < N; i++) {
	    	  t = new StringTokenizer(br.readLine());
	    	  for(int j = 0; j < N; j++) {
	        	arr[i][j] = Integer.parseInt(t.nextToken());
	       	}
	      }
	        
	       res = square(arr, B);
	       
	       for(int i = 0; i < N; i++) {
	    	   
	           for(int j = 0; j < N; j++) {
	        	   System.out.print(res[i][j] % 1000 + " ");
	           }
	           System.out.println();
	       }
	 } 
	 
	 // Çà·Ä °ö¼À
	 public static int[][] matrix(int[][] A, int[][] a) {
		 int[][] tmp = new int[N][N];
		 
		 for(int i = 0; i < N; i++) {
	        	for(int j = 0; j < N; j++) {
	        		for(int k = 0; k < N; k++) {
	        			tmp[i][j] += A[i][k] * a[k][j];
	        		}
	        		tmp[i][j] = tmp[i][j] % 1000;
	        	}
	        }
		 return tmp;
	 }
	 
	 public static int[][] square(int[][] a, long B) {
		 
		 if (B == 1) 
			 return a;
		 //if B is Even ==> A^B = (A^2)^ B/2
		 else if(B % 2 == 0) {
			 int [][] tmp = square(a, B / 2);
			 return matrix(tmp, tmp);
		 }
		 // B is odd  ==> A^B = A * A^B-1
		 else {
			return matrix(square(a, B - 1), a);
		 }
	 }
}














