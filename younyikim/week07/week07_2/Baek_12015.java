package level21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baek_12015 {
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); 
		List<Integer> list = new ArrayList<>();
		list.add(0);
		
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			int X = Integer.parseInt(st.nextToken());

			if (X > list.get(list.size() - 1)) {
				list.add(X);
			} 
			else {
				int start = 0;
				int end = list.size() - 1;
				
				while (start < end) {
					int mid = (start + end) / 2;
				
					if (list.get(mid) >=  X) {
						end = mid;
					}
					else {
						start = mid + 1;
					}
				}
				list.set(end, X);
			}

		}
		
		System.out.println(list.size() - 1);
	}
}
