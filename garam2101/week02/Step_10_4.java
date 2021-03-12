import java.io.*;

public class Step_10_4 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
            int num = Integer.parseInt(br.readLine());
            bw.write((int)(Math.pow(2, num) - 1) + "\n");

            hanoi(num, 1, 2, 3);
            
            br.close();
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public static void hanoi(int n, int s, int m, int t) throws IOException {
        if (n == 1) {
            bw.write(s + " " + t + "\n");
            return;
        }

        hanoi(n - 1, s, t, m);
        bw.write(s + " " + t + "\n");
        hanoi(n - 1, m, s, t);
    }
}
