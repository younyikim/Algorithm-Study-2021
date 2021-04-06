package level18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_9012 {
	
	static int top = -1;
	static char[] stack;
	
	private static void push(char item) {
		stack[++top] = item;
	}
	
	private static void pop() {
		top--;
	}
	
	private static boolean empty() {
		return top == -1;
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		char[] arr;
		for (int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr = st.nextToken().toCharArray();

			top = -1;
			stack = new char[50];
			for (int j = 0; j < arr.length; j++)
			{
				if (arr[j] == ')') {
					push(arr[j]);
					if (top >= 1 && stack[top - 1] == '(') {
						pop();
						pop();
					}
				} else {
					push(arr[j]);
				}
			}
			if (empty() && arr[0] != ')') sb.append("YES").append('\n');
			else sb.append("NO") .append('\n');
		}
		System.out.println(sb);	
	}
}	

