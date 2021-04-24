package level18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_10773 {
	
	static int top = -1;
	static int[] stack;
	
	private static void push(int item) {
		stack[++top] = item;
	}
	
	private static void pop() {
		stack[top--] = 0;
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		int N = Integer.parseInt(br.readLine());
		stack = new int[N];
		
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken());
			
			if (num == 0) pop();
			else push(num);
		}
		
		int total = 0;
		for (int i = 0; i < stack.length; i++) {
			total += stack[i];
		}
		System.out.println(total);
	}
}
