package kakao;

import java.util.*;

public class Kakao_cache {
	public static void main(String[] args) {
		int cacheSize = 3;
		String[] cities = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
		
		System.out.println(solution(cacheSize, cities));
	}
	public static int solution(int cacheSize, String[] cities) {
		if(cacheSize == 0) return 5 * cities.length;
		
        int answer = 0;
        int CACHE_HIT = 1;
        int CACHE_MISS = 5;
        
        LinkedList<String> cache = new LinkedList<>();
        
        for(int i = 0; i < cities.length; i++) {
        	
        	String city = cities[i].toUpperCase();
        	
        	// cache hit
        	// Pages already in the cache, fetched first.
        	if(cache.remove(city)) {
        		cache.addFirst(city);
        		answer += CACHE_HIT;
        	} 
        	// cache miss
        	else {
        		int currentSize = cache.size();
        		
        		// when cache is full
        		if(currentSize == cacheSize) {
        			cache.pollLast();
        		}
        	
        		cache.addFirst(city);
        		answer += CACHE_MISS;
        	}
        }
 
        return answer;
    }
	
}
