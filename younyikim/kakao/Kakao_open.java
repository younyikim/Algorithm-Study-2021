package kakao;

import java.util.ArrayList;
import java.util.HashMap;

public class Kakao_open {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234",
				"Enter uid1234 Prodo","Change uid4567 Ryan"};
		String[] result = new String[100000];
		
		result = solution(record);
		for(int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}
	 public static String[] solution(String[] record) {
	        ArrayList<String> arr = new ArrayList<>();
	        HashMap<String, String> map = new HashMap<String, String>();
	        
	        for(int i = 0; i < record.length; i++) {
	        	String[] result = record[i].split(" ");
	        	
	        	if(result[0].equals("Enter")) {
	        		arr.add(result[1]  + "´ÔÀÌ µé¾î¿Ô½À´Ï´Ù.");
	        		map.put(result[1], result[2]);
	        	} else if(result[0].contentEquals("Change")) {
	        		map.put(result[1], result[2]);
	        	} else {
	        		arr.add(result[1] + "´ÔÀÌ ³ª°¬½À´Ï´Ù.");
	        	}
	        }
	        String[] answer = new String[arr.size()];
	        for(int i = 0; i < arr.size(); i++) {
	        	int idx = arr.get(i).indexOf("´Ô");
	        	String id = arr.get(i).substring(0, idx);
	        	String[] tmp = arr.get(i).split(" ");
	        	
	        	answer[i] = map.get(id) + "´ÔÀÌ " + tmp[1];
	        }
	        return answer;
	 }
}
