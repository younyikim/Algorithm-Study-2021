/* 01 - 1330
import java.util.Scanner;

public class Step2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();

        if (A < B)
            System.out.println("<");
        else if (A > B)
            System.out.println(">");
        else
            System.out.println("==");
    }
}
*/

/* 02 - 9498 
import java.util.Scanner;

public class Step2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int score = sc.nextInt();
        
        if (score >= 90)
            System.out.println("A");
        else if (score >= 80)
            System.out.println("B");
        else if (score >= 70)
            System.out.println("C");
        else if (score >= 60)
            System.out.println("D");
        else
            System.out.println("F");
    }
}
*/

/* 03 - 2753 
import java.util.Scanner;

public class Step2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();

        if (year % 4 == 0 && year % 100 != 0)
            System.out.println("1");
        else if (year % 400 == 0)
            System.out.println("1");
        else
            System.out.println("0");
    }
}
*/

/* 04 - 14681
import java.util.Scanner;

public class Step2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();

        if (x > 0 && y > 0)
            System.out.println("1");
        else if (x > 0 && y < 0)
            System.out.println("4");
        else if (x < 0 && y < 0)
            System.out.println("3");
        else if (x < 0 && y > 0)
            System.out.println("2");
    }
}
*/

/* 05 - 2884
import java.util.Scanner;

public class Step2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        int M = sc.nextInt();

        if (M - 45 < 0) {
            H = H - 1;
            M -= 45;
            M = 60 + M;
            if (H < 0) {
                H = 23;
            }
        }
        else {
            M = M - 45;
        }
        System.out.println(H + " " + M);
    }
}
*/