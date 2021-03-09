//BaekJoon2884
//author : Hyejin Eom
//20210228

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_2884 {
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int h, m;
		String h_string, m_string;

		String HAndM = br.readLine();

		String[] array = HAndM.split(" ");

		h = Integer.parseInt(array[0]);
		m = Integer.parseInt(array[1]);

		if(m < 45) {
			h -= 1;
			m += 60;

			if(h < 0) {
				h = 23;
			}
		}
		m -= 45;

		h_string = Integer.toString(h);
		m_string = Integer.toString(m);


		System.out.println(h_string + " " + m_string);


	}
}