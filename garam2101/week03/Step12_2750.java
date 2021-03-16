import java.io.*;
import java.util.Arrays;

public class Step12_2750 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(arr);

        for (int num : arr) {
            System.out.println(num);
        }
    }
}

/*public class Step12_2750 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        
        // range: -1000 ~ 1000 절댓값이 1000보다 작거나 같기때문
        boolean[] arr = new boolean[2001];
    
        for (int i = 0; i < n; i++) {
            // -1000이면 인덱스가 0이 돼야하므로 +1000을 하는 것
            // 숫자가 존재하면 해당하는 boolean배열에 true로 표시
            arr[Integer.parseint(br.readLine()) + 1000] = true;
        }

        for (int i = 0; i < 2001; i++) {
            if (arr[i]) {
                sb.append(i - 1000).append('\n');
            }
        }

        System.out.println(sb);
    }
}
*/