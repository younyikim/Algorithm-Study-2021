package level19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_18258 {
	
	private static int front = 0;
	private static int rear = 0;
	private static int size = 0;
	private static int maxSize;
	private static int[] queue = new int[2000000];
	
	static StringBuilder sb = new StringBuilder();
	
	public static void push(int item) {
		queue[rear++] = item;
		size++;
	}
	
	public static void pop() {
		if(size == 0) {
			sb.append(-1).append('\n');
		}else {
			sb.append(queue[front]).append('\n');
			front++;
			size--;
		}
	}
	
	public static void size() {
		sb.append(size).append('\n');
	}
	public static void empty() {
		if(size == 0) {
			sb.append(1).append('\n');
		}
		else sb.append(0).append('\n');
	}
	public static void front() {
		if(size == 0) { 
			sb.append(-1).append('\n');
		}
		else {
			sb.append(queue[front]).append('\n');	
		};
	}
	public static void back() {
		if(size == 0) { 
			sb.append(-1).append('\n');
		}
		else {
			sb.append(queue[rear - 1]).append('\n');	 // 맨 앞의 원소 출력 
		}
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		maxSize = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for (int i = 0; i < maxSize ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			switch(st.nextToken()) {
				case "push": push(Integer.parseInt(st.nextToken())); break;
				case "pop" : pop(); break;
				case "size" : size(); break;
				case "empty" : empty(); break;
				case "front" : front(); break;
				case "back" : back(); break;
			}
		}
		System.out.println(sb);
	}
}
