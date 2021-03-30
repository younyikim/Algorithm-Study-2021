//BaekJoon2565
//author : Hyejin Eom
//20210327

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2565 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int total = Integer.parseInt(br.readLine());
		if(1 > total || total > 100) { return; }

		int[][] lines = new int[total][2];
		for(int i = 0; i < total; i++) {
			String[] temp = br.readLine().split(" ");
			lines[i][0] = Integer.parseInt(temp[0]);
			lines[i][1] = Integer.parseInt(temp[1]);
			if(1 > lines[i][0] || lines[i][0] > 500 || 1 > lines[i][1] || lines[i][1] > 500) { return;}
		}
	}
}
