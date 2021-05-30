package level28;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Baek_4803 {
	static int node,edge;
    static int par[];
    static HashSet<Integer> hs;
    
    static int findP(int x){
        if(par[x]==x) return x;
        return par[x] = findP(par[x]);
    }
    
    static void make_union(int a,int b){
        int pa = findP(a);
        int pb = findP(b);
        if(pa==pb){     //이미 같은 트리
            par[pb] = pa;
            par[pa] = 0;
        }
        else if(pa<pb) par[pb] = pa;
        else par[pa] = pb;
    }
    
	public static void main (String[] args) throws java.lang.Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   
	    int a,b,test = 1;
	    
	    while(true){
	        String ss = br.readLine();
    	    StringTokenizer st = new StringTokenizer(ss);
    	    node = Integer.parseInt(st.nextToken());
    	    edge = Integer.parseInt(st.nextToken());
    	    if(node==0 && edge==0) break;
    	    
    	    //초기화
    	    par = new int[node+1];
    	    for(int i=1;i<=node;i++)
    	        par[i]=i;   	    
    	    hs = new HashSet<>();
    	    
    	    for(int i=0;i<edge;i++){
    	        ss = br.readLine();
    	        st = new StringTokenizer(ss);
    	        a = Integer.parseInt(st.nextToken());
    	        b = Integer.parseInt(st.nextToken());
    	        make_union(a,b);
    	    }
    	    for(int i=1;i<=node;i++){
    	        int pi = findP(i);
    	        if(pi>0)
    	            hs.add(pi);
    	    }
    	    if(hs.isEmpty())
    	        System.out.println("Case "+test+": No trees.");
    	    else if(hs.size()==1)
    	        System.out.println("Case "+test+": There is one tree.");
    	    else
    	        System.out.println("Case "+test+": A forest of "+hs.size()+" trees.");
    	    test++;
	    }
	}
}
