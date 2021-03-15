import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
public class Step12_10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        
        String[][] arr = new String[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = st.nextToken();
            arr[i][1] = st.nextToken();
        }

        Arrays.sort(arr, new Comparator<String[]>() {

            @Override
            public int compare(String[] o1, String[] o2) {
                // TODO Auto-generated method stub
                return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
            }
        });

        for (int i = 0; i < n; i++) {
            sb.append(arr[i][0]).append(' ').append(arr[i][1]).append('\n');
        }

        System.out.println(sb);
    }

}
