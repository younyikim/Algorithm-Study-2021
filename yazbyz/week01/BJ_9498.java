//BaekJoon9498
//author : Hyejin Eom
//20210228

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_9498 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int score;

		do{
			score = Integer.parseInt(br.readLine());
		}while(score < 0 || score > 100);

		if(score >= 90)
		{
			System.out.println("A");
		} else if (score >= 80){
			System.out.println("B");
		} else if (score >= 70){
			System.out.println("C");
		} else if (score >= 60){
			System.out.println("D");
		} else {
			System.out.println("F");
		}
	}

}