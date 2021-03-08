/* 01 - 10952
import java.io.*;

public class Step4 {
    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            StringBuilder sb = new StringBuilder();

            int A;
            int B;
            String str;

            while (true) {
                str = br.readLine();
                A = str.charAt(0) - '0';
                B = str.charAt(2) - '0';

                if (A == 0 && B == 0) {
                    break;
                }
                sb.append((A + B)).append("\n");
            }

            System.out.println(sb);
            br.close();
            
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

}
*/

/* 02 - 10951
import java.io.*;

public class Step4 {
    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            StringBuilder sb = new StringBuilder();

            int A;
            int B;
            String str;

            while ((str = br.readLine()) != null) {
                A = str.charAt(0) - '0';
                B = str.charAt(2) - '0';

                sb.append((A + B)).append("\n");
            }

            System.out.println(sb);
            br.close();
            
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

}
*/

/* 03 - 1110
import java.util.Scanner;

public class Step4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int A = n / 10;
        int B = n % 10;
        int sum = A + B;
        int cnt = 1;

        while ((B * 10 + (sum % 10)) != n) {
            A = B;
            B = sum % 10;
            sum = A + B;
            cnt++;
        }
        System.out.println(cnt);

    }

}
 */