import java.io.*;
import java.util.StringTokenizer;
public class Step_11_3 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st;

            int[][] arr = new int[n][2];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < n; i++) {
                int rank = 1;
                
                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
                            rank++;
                        }
                    }
                }
                System.out.print(rank + " ");
            }
            
        } catch(IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
