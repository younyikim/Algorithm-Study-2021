import java.util.Scanner;

public class Step_11_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int title = 666;
        int cnt = 1;

        while (cnt != n) {
            title++;
            if (Integer.toString(title).contains("666")) {
                cnt++;
            }
        }
        System.out.println(title);
        sc.close();
    }
}
