package kakao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Kakao_newId {

	public static void main(String[] args)  throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String userId = br.readLine();
		System.out.println(solution(userId));
	}
	
	public static String solution(String new_id) {
		String answer = "";
		
		// step 1. 모든 대문자를 대응되는 소문자로 치환
		new_id = new_id.toLowerCase();
		
		/*
		 * 정규 표현식 사용
		 *  answer = answer.replaceAll("[^-_.a-z0-9]", ""); // 2단계
        	answer = answer.replaceAll("[.]{2,}", "."); // 3단계
        	answer = answer.replaceAll("^[.]|[.]$", "");    // 4단계
		 * */
		
		// step 2. 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거
		String id = "";
		for(int i = 0; i < new_id.length(); i++) {
			char c = new_id.charAt(i);
			
			if(c >= 'a' && c <= 'z') { // 알파벳 소문자인 경우
				id += String.valueOf(c);
			} else if(c >= '0' && c <= '9') { // 숫자인 경우
				id += String.valueOf(c);
			} else if(c == '-' || c == '_' || c == '.') {
				id += String.valueOf(c);
			}
		}
		new_id = id;
		
		// step 3. 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환
		String step3 = new_id.replace("..", ".");
		while(step3.contains("..")) {
			step3 = step3.replace("..", ".");
		}
		new_id = step3;
		
		//step 4. 마침표(.)가 처음이나 끝에 위치한다면 제거
		if(new_id.startsWith(".") ){
			new_id = new_id.substring(1, new_id.length());
		} 
		if(new_id.endsWith(".")) {
			new_id = new_id.substring(0, new_id.length() - 1);
		}
		
		//step 5. new_id가 빈 문자열이라면, new_id에 "a"를 대입
		if(new_id.equals("")) {
			new_id = "a";
		}
		
		//step 6. new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거
	    //만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거
		
		if(new_id.length() >= 16) {
			new_id = new_id.substring(0, 15);
			
			if(new_id.charAt(new_id.length() - 1) == '.') {
				new_id = new_id.substring(0, new_id.length() - 1);
			}
		}
		
		// step 7. new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙인다.
		if(new_id.length() <= 2) {
			char last = new_id.charAt(new_id.length() - 1);
			
			while(new_id.length() < 3) {
				new_id += last;
			}
		}

		answer = new_id;
		return answer;
	}

}
