import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Step12_11651 {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();
      StringTokenizer st;
      
      int n = Integer.parseInt(br.readLine());
      int[][] arr = new int[n][2];
      
      for (int i = 0; i < n; i++) {
         st = new StringTokenizer(br.readLine());
         arr[i][1] = Integer.parseInt(st.nextToken());
         arr[i][0] = Integer.parseInt(st.nextToken());
      }

      Arrays.sort(arr, (e1, e2) -> {
         if (e1[0] == e2[0]) {
            return e1[1] - e2[1];
         }
         else {
            return e1[0] - e2[0];
         }
      });

      for (int i = 0; i < n; i++) {
         sb.append(arr[i][1] + " " + arr[i][0]).append('\n');
      }
      System.out.println(sb);
   } 
}
