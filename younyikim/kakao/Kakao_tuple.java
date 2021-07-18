package kakao;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Kakao_tuple {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
		
		int[] arr = solution(str);
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	 public static int[] solution(String s) {
	
	    	Map<String, Integer> map = new HashMap();
	        
	        s = s.replace("{", "");
	        s = s.replace("}", "");
	       
	        String [] arr = s.split(",");
	        
	        /*
	         * 튜플의 첫 원소는 모든 배열에 등장하고, 그 다음 원소는 하나 적게, 마지막 원소는 한 번만 등장한다.
	         * 이 횟수를 key의 value로 저장한다.
	         */
	        for(int i = 0 ; i < arr.length; i++) {
	        	int count = map.containsKey(arr[i]) ? map.get(arr[i]) + 1 : 1;
	        	map.put(arr[i], count);
	        }
	        
	        List<String> list = new ArrayList<>(map.keySet());
	        
	        // 등장횟수가 많은 순으로 정렬한다.
	        Collections.sort(list, (o1, o2) -> 
	        		(map.get(o2).compareTo(map.get(o1))));
	        
	        int[] answer = new int[map.size()];
	        
	        int i = 0;
	        for(String key : list) {
	        	answer[i++] = Integer.parseInt(key);
	        }
	        
	        return answer;
	    }

}
