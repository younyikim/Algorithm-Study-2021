//BaekJoon1181
//author : Hyejin Eom
// reference : https://st-lab.tistory.com/112?category=857114
//20210315

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BJ_1181 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력
		int N = Integer.parseInt(br.readLine());
		if(1 > N || N > 20000) { return; }

		String[] words = new String[N];
		for(int i = 0; i < N; i++) {
			words[i] = br.readLine();
		}

		Arrays.sort(words, new Comparator<String>() {
			public int compare(String s1, String s2) {
				// 단어 길이가 같을 경우
				if (s1.length() == s2.length()) {
					return s1.compareTo(s2);
				}
				// 그 외의 경우
				else {
					return s1.length() - s2.length();
				}
			}
		});

		StringBuilder sb = new StringBuilder();
		sb.append(words[0]).append('\n');
		for (int i = 1; i < N; i++) {
			// 중복되지 않는 단어만 출력
			if (!words[i].equals(words[i - 1])) {
				sb.append(words[i]).append('\n');
			}
		}
		System.out.println(sb);
	}
}
