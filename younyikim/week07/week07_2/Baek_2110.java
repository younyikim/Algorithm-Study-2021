package level21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
	집들의 좌표에서 단위거리가 1이냐, 2이냐 등에 따라 놓을 수 있는 공유기의 갯수가 달라진다.
	
	1 . 우선 주어진 좌표를 정렬한다.
		House = {1,2,4,8,9}로 정렬되고, 좌표간 최소 거리는 1, 최대 거리는 8이다.
		이를 통해 좌표간 거리가 1일때, 놓을 수 있는 공유기의 갯수를 찾고 우리가 놓아야할 공유기의 갯수와 비교한다.
		반복하여 좌표가 거리가 2일때, 3일때, . . . 8일때까지 반복한다.
	
	2. 처음 시작 start = 1, 끝을 end = 8이라고 한다.
	      그리고 중앙값 mid = (start + end) / 2 = 4를 구한다.
	
	3. 먼저 좌표간 거리가 4인 경우부터 살펴본다.
		start = 1임으로, 다음에 놓을 수 있는 좌표는 start + 4 = 5이다. House에 5인 원소가 없으니, 5이상의 값중
		가장 작은 값을 찾는다. House[3] = 8에 놓을 수 있다. start에 공유기를 놓은 뒤, 새로운 공유기를 하나 더 놓았으니
		count값을 하나 증가시켜준다. 
		그다음 좌표 거리가 4로 놓을수 있는 집이 있나 살펴본다. 
	
		최종적으로 좌표 거리가 4일때 놓을 수 있는 공유기는 1, 8에 하나씩, 총 2개이다.
		
	4. 우리가 구하는 공유기의 갯수는 3개이기때문에, 간격을 줄여야한다.
	  (만약 우리가 구하는 공유기의 갯수보다 놓은 공유기의 수가 많은 경우에는 간격을 늘려주면 된다.)
	5. 2~3 반복  
*/

public class Baek_2110 {
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        
        int[] House = new int[N];
        for(int i = 0; i < N; i++) {
        	House[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(House);
        
        int start = 1;
        int mid;
        int end = House[N - 1] - House[0];
        
        
        while(start <= end) {
        	mid = (start + end) / 2;
        	int cnt = 1;
        	int prev = House[0];
        	 
        	for (int i = 0; i < House.length; i++) {
        		if(House[i] >= prev + mid) {
        			cnt++;
        			prev = House[i];
        		}
        	}
        	
        	// 공유기를 C개보다 많이 설치한 경우 => 범위를 넓힘
        	if (cnt >= C) { 
        		start = mid + 1;
        	}
        	// 공유기를 C개보다 적게 설치한 경우 => 범위를 줄임
        	else {
        		end = mid - 1;
        	}
        }
        System.out.println(end);
	}
}
