package kakao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Kakao_change {

	public static int pos = 0;
	
	public static void main(String[] args) throws Exception, IOException {
		String p = "()))((()";
		
		String ans = solution(p);
		
		System.out.println(ans);
	}
	
	public static String solution(String p) {
        
		// 빈 문자열인 경우, 그대로 반환
        if(p.isEmpty()) {
        	return p;
        }
        
        // 올바른 괄호 문자열인지 확인
        boolean check = isCorrect(p);
        
        String u = p.substring(0, pos);
        String v = p.substring(pos, p.length());
        
        
     // 올바른 괄호 문자열인 경우
        if(check) {
        	return u + solution(v);
        }
        
     // 올바른 괄호 문자열이 아닌 경우
        String answer = "(" + solution(v) + ")";
        
        for(int i = 1; i < u.length() - 1; i++) {
        	if(u.charAt(i) == '(') {
        		answer += ")";
        	} else {
        		answer += "(";
        	}
        }
        
        return answer;
    }

//	올바른 문자열과 균형 잡힌 문자열 확인
	public static boolean isCorrect(String str) {
		
		boolean ret = true; // true 인 경우, '균형잡힌 괄호 문자열'
		int left = 0, right = 0; // left와 right이 동일한 경우 '올바른 괄호 문자열'
		
		Stack<Character> stack = new Stack<Character>();
		
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '(') {
				left++;
				stack.push('(');
			} else {
				right++;
				
				if(stack.isEmpty()) {
					ret = false;
				} else {
					stack.pop();
				}
			}
			
			if(left == right) {
				pos = i + 1;
				return ret;
			}
		}
		
		return ret;
	}
}
