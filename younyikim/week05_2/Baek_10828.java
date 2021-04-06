package level18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_10828 {
	
	static int N;
	
	static int top = -1;
	static int[] stack;
	static int size = 0;
	
	private static int push(int item) {
		stack[++top] = item;
		return stack[top];
	}
	
	private static int pop() {
		if (top == -1) return -1;
		return stack[top--];
	}
	
	private static int size() {
		return top + 1;
	}
	
	private static int empty() {
		if (top == -1) return 1;
		return 0;
	}
	
	private static int top() {
		if(top == -1) return -1;
		return stack[top];
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		
		stack = new int[N];
		
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			switch(st.nextToken()) {
				case "push" : 
					push(Integer.parseInt(st.nextToken()));
					break;
				case "pop" : 
					sb.append(pop()).append('\n');
					break;
				case "size" : 
					sb.append(size()).append('\n');
					break;
				case "empty" : 
					sb.append(empty()).append('\n');
					break;	
				case "top" : 
					sb.append(top()).append('\n');
					break;	
					
			}
		}
		System.out.println(sb);
	}

}
