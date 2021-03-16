package week03;

import java.util.Arrays;
import java.util.Comparator;
import java.io.*;

public class Baek_1181 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String str[] = new String[N];		
		
		for(int i = 0; i < N; i++) {
			str[i] = br.readLine();
		}
		
		Arrays.sort(str, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				if(a.length() == b.length())
					return a.compareTo(b);
				else
					return a.length() - b.length();
			}
		});
		
		StringBuilder sb = new StringBuilder();
		sb.append(str[0]).append('\n');
		
		for(int i = 1; i < N; i++) {
			if (!str[i].equals(str[i - 1]))
				sb.append(str[i]).append('\n');
		}
		System.out.println(sb);
		
		
	}

}
