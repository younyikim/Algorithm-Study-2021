package week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Baek_10814 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String str[][] = new String[N][2];		
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			str[i][0] = st.nextToken();
			str[i][1] = st.nextToken();
		}
		Arrays.sort(str, new Comparator<String[]>() {
			@Override
			public int compare(String[] a, String[] b) {
				return Integer.compare(Integer.parseInt(a[0]), Integer.parseInt(b[0]));
			}
		});
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			sb.append(str[i][0]).append(' ').append(str[i][1]).append('\n');
		}
		System.out.println(sb);
	}

}
