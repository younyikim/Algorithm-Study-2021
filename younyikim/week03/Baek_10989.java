package week03;

import java.util.Scanner;

public class Baek_10989 {
	static int B[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt(); 
				
		int A[] = new int[size];
		System.out.println(size);
		for (int i = 0; i < size ; i++) {
			A[i] = sc.nextInt();
		}
		
		B = new int[size];
		countingSort(A, B, size);
		for (int i = 0; i < size ; i++) {
			System.out.println(B[i]);
		}
	}
	
	public static void countingSort(int A[], int B[], int n) {
		int C[] = new int[10000];
		for (int i = 1; i < C.length; i++) {
			C[i] = 0;
		}
		for (int j = 0; j < n; j++) {
			C[A[j]]++;
		}
		for (int i = 1; i < C.length; i++) {
			C[i] = C[i] + C[i - 1];
		}
		for (int j = n - 1; j >= 0; j--) {
			B[--C[A[j]]] = A[j];
		}
	}

}
