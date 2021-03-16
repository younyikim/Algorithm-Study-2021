package week03;

import java.util.Arrays;
import java.io.*;

public class Baek_1427 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String STR = br.readLine();
		char[] sort = STR.toCharArray();
		Arrays.sort(sort);
		
		for (int i = sort.length - 1; i >= 0; i--)
			System.out.print(sort[i]);
	}

}
