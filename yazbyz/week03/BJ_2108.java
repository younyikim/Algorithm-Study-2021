//BaekJoon2108
//author : Hyejin Eom
// 3번 참조 : 출처: https://st-lab.tistory.com/108
//20210315

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BJ_2108 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		if(1 > N || N > 5000000) return;

		int[] numbers = new int[N];
		for(int i = 0; i < N; i++) {
			int temp = Integer.parseInt(br.readLine());
			if(temp > 4000) return;
			numbers[i] = temp;
		}

		Arrays.sort(numbers);

		double total = 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		Map<Integer, Integer> memo = new HashMap<Integer, Integer>();
		int max_frequency = 0;
		int max_frequency_index = -1;

		for(int i = 0; i < N; i++) {
			total += numbers[i];

			if(memo.containsKey(numbers[i]) == false){
				memo.put(numbers[i], 1);
			} else {
				int temp = memo.get(numbers[i]);
				memo.put(numbers[i], ++temp);

				if(max_frequency < temp) {
					max_frequency = temp;
					max_frequency_index = numbers[i];
				}
			}
		}

		// 첫째 줄에는 산술평균을 출력한다. 소수점 이하 첫째 자리에서 반올림한 값을 출력한다.
		double arith = total / N;
		bw.write(String.format("%.0f", arith) + "\n");

		// 	둘째 줄에는 중앙값을 출력한다.
		bw.write(String.valueOf(numbers[numbers.length/2]) + "\n");

		// 	셋째 줄에는 최빈값을 출력한다. 여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력한다.
		// int[] tmp = new int[N];
		// int tmp_index = 0;
		// for(int i = 0; i < N; i++) {
		// 	int frequency = memo.get(numbers[i]);
		// 	if(frequency == max_frequency_index) {
		// 		tmp[tmp_index] = numbers[i];
		// 		tmp_index++;
		// 	}
		// }

		// Arrays.sort(tmp);
		//
		// if(tmp[1] == 0) {
		// 	bw.write(String.valueOf(tmp[0]) + "\n");
		// } else {
		// 	bw.write(String.valueOf(tmp[1]) + "\n");
		// }
		boolean flag = false;
		int mode_max = 0;
		int mode = 10000;
		for(int i = 0; i < N; i++) {
			int jump = 0; // 동일한 수가 나온만큼 i 값 jump 시킬 변수
			int count = 1;
			int i_value = numbers[i];
			for(int j = i + 1; j < N; j++){
				if(i_value != numbers[j]) {
					break;
				}
				count++;
				jump++;
			}
			if(count > mode_max) {
				mode_max = count;
				mode = i_value;
				flag = true;
			}
			else if(count == mode_max && flag == true) {
				mode = i_value;
				flag = false;
			}
			i += jump;
		}
		bw.write(String.valueOf(mode) + "\n");
		// 출처: https://st-lab.tistory.com/108 [Stranger's LAB]

		// 	넷째 줄에는 범위를 출력한다.
		int range = numbers[N-1] - numbers[0];
		bw.write(String.valueOf(range) + "\n");

		bw.flush();
		bw.close();
	}
}
