package step13;

import java.util.Scanner;

public class BJ_14889 {
    public static int[][] map;
    public static boolean[] visited;
    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
    	
        Scanner sc = new Scanner(System.in);
        
        int size = sc.nextInt();
        
        map = new int[size][size];
        visited = new boolean[size];
       
        for (int i = 0; i < size; i++) 
            for (int j = 0; j < size; j++) 
                map[i][j] = sc.nextInt();
    
        dfs(0, 0);
        
        System.out.println(min);
        
        sc.close();
    }

    public static void dfs(int index, int depth) {
    	
        if (depth == map.length / 2) {
        	
            int startTeam = 0;
            int linkTeam = 0;
            
            for (int i = 0; i < map.length - 1; i++) { 
            	
                for (int j = i + 1; j < map.length; j++) {
                	
                    if (visited[i] && visited[j])
                        startTeam += (map[i][j] + map[j][i]);
                    
                    else if (!visited[i] && !visited[j])
                        linkTeam += (map[i][j] + map[j][i]);
                }
            }
            
            min = Math.min(min, Math.abs(startTeam - linkTeam));
            
            return;
        }
        
        for (int i = index; i < map.length; i++) {
        	
            if (!visited[i]) {
                visited[i] = true;
                dfs(i + 1, depth + 1);
                visited[i] = false;
            }
        }

    }
}