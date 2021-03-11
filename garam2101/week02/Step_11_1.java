import java.io.*;
import java.util.StringTokenizer;

public class Step_11_1 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] arr = new int[n];

            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            System.out.println(sum(n, m, arr));


        } catch(IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public static int sum(int n, int m, int[] arr) {
        int result = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int sum = arr[i] + arr[j] + arr[k];
                    if (sum == m) {
                        return sum;
                    }
                    if (result < sum && sum < m) {
                        result = sum;
                    }
                }
            }
        }
        return result;
    }
}