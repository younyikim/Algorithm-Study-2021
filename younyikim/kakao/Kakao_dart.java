package kakao;

public class Kakao_dart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String dartResult = "1D2S#10S";
		int x = solution(dartResult);
		System.out.println("score : " + x);
	}

    public static int solution(String dartResult) {
    	char[] result = dartResult.toCharArray();
    	int[] score = new int[3];
    	int cnt = -1;
    	
    	for(int i = 0; i < result.length; i++) {
    		if(result[i] >= '0' && result[i] <= '9') {
    			cnt++;
    			
    			// 10점인 경우
    			if(result[i] == '1' && result[i + 1] == '0') {
    				score[cnt] = 10;
    				i++;
    			} else {
    				score[cnt] = result[i] - '0';
    			}
    		} else if(result[i] == 'D') {
    			score[cnt] = (int) Math.pow(score[cnt], 2);
    		} else if(result[i] == 'T') {
    			score[cnt] = (int) Math.pow(score[cnt], 3);
    		} else if(result[i] == '*') {
    			if(cnt > 0) {
    				score[cnt - 1] *= 2;
    			}
    			score[cnt] *= 2;
    		} else if(result[i] == '#') {
    			score[cnt] *= -1;
    		}
    	}
    	
        return score[0] + score[1] + score[2];
    }
}
