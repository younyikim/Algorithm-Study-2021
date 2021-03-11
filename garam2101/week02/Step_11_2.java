import java.util.Scanner;

public class Step_11_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i = 0;
        sc.close();

        for (; i < n; i++) {
            int num = i;
            int sum = 0;

            while (num != 0) {
                sum += num % 10;
                num /= 10;
            }
            
            if (sum + i == n) {
                break;
            }
        }

        if (i == n) {
            System.out.println("0");
        }
        else {
            System.out.println(i);
        }
    }
}
