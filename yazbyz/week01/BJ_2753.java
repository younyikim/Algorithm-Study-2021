//BaekJoon2753
//author : Hyejin Eom
//20210228

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_2753 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int year;

		do{
			year = Integer.parseInt(br.readLine());
		}while(year < 1 || year > 4000);

		if(year % 4 == 0 && year % 100 != 0)
		{
			System.out.println("1");
		} else if(year % 400 == 0) {
			System.out.println("1");
		} else {
			System.out.println("0");
		}

	}

}