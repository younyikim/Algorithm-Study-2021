//BaekJoon10814
//author : Hyejin Eom
// reference : https://st-lab.tistory.com/113?category=857114
//20210315

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BJ_10814 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력
		int N = Integer.parseInt(br.readLine());
		if(1 > N || N > 100000) { return; }

		String[][] persons = new String[N][2];
		for(int i = 0; i < N; i++) {
			String temp[] = br.readLine().split(" ");
			persons[i][0] = temp[0];
			persons[i][1] = temp[1];
		}

		Arrays.sort(persons, new Comparator<String[]>() {
			// 나이순으로 정렬
			@Override
			public int compare(String[] s1, String[] s2) {
				return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
			}
		});
		for(int i = 0; i < N; i++) {
			System.out.println(persons[i][0] + " " + persons[i][1]);
		}

	}
}
