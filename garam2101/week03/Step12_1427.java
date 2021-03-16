import java.io.*;

public class Step12_1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] counting = new int[10];

        while (n > 0) {
            counting[n % 10]++;
            n /= 10;
        }

        for (int i = counting.length - 1; i >= 0; i--) {
            while (counting[i]-- > 0) {
                System.out.print(i);
            }
        }
    }
}
