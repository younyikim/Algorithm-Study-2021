package level28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Baek_2263 {
	 public static int size;
	    
	    public static int[] in_order;
	    public static int[] in_order_idx; // 중위 순회에 루트들의 인덱스 정보
	    public static int[] post_order;
	    
	    public static StringBuilder sb;
	    public static void main(String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st = null;
	        size = Integer.parseInt(br.readLine());
	        
	        in_order = new int[size+1];
	        in_order_idx = new int[size+1];
	        post_order = new int[size+1];
	        
	        sb = new StringBuilder();
	        
	        
	        st = new StringTokenizer(br.readLine());
	        
	        for(int i=1; i <= size; i++) 
	            in_order[i] = Integer.parseInt(st.nextToken());
	        
	        st = new StringTokenizer(br.readLine());
	        for(int i=1; i <= size; i++) post_order[i] = Integer.parseInt(st.nextToken());
	        
	        // 중위순회에 노드들이 루트일경우 인덱스 정보를 저장
	        for(int i=1; i <= size; i++) in_order_idx[in_order[i]] = i;
	        
	        getPreOrder(1, size, 1, size);
	        System.out.println(sb.toString());
	    }
	    
	    public static void getPreOrder(int inO_start, int inO_end, int poO_start, int poO_end) {
	        
	        if(inO_start > inO_end || poO_start > poO_end) return;

	        int root = post_order[poO_end];
	        sb.append(root + " ");

	        int rootIdx = in_order_idx[root];
	        int left = rootIdx - inO_start;
	        
	        //좌측 자식 노드
	        getPreOrder(inO_start, rootIdx-1, poO_start, poO_start+ left-1);
	        
	        // 우측 자식 노드
	        getPreOrder(rootIdx+1, inO_end, poO_start + left, poO_end - 1);
	    }
}
