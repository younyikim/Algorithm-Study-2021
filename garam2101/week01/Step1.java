/* 01
print("Hello World!")
*/

/* 02 - 10718
public class Step1 {
	public static void main(String[] args) {
		for (int i = 0; i < 2; i++) {
            System.out.println("강한친구 대한육군");
        }
	}
}
*/

/* 03 - 10171 
public class Step1 {
    public static void main(String[] args) {
        System.out.println("\\    /\\");
        System.out.println(" )  ( ')");
        System.out.println("(  /  )");
        System.out.println(" \\(__)|");
    }
}
*/

/* 04 - 10172
public class Step1 {
    public static void main(String[] args) {
        System.out.println("|\\_/|");
        System.out.println("|q p|   /}");
        System.out.println("( 0 )\"\"\"\\");
        System.out.println("|\"^\"`    |");
        System.out.println("||_/=\\\\__|");
    }
}
*/

/* 05 - 1000 
import java.util.Scanner;

public class Step1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        System.out.println(A + B);
    }
}
*/

/* 06 - 1001
import java.util.Scanner;

public class Step1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        sc.close();
        System.out.println(A - B);
    }
}
*/

/* 07 - 10998
import java.util.Scanner;

public class Step1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        sc.close();
        System.out.println(A * B);
    }
}
*/

/* 08 - 1008 
import java.util.Scanner;

public class Step1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double A = sc.nextDouble();
        double B = sc.nextDouble();
        sc.close();
        System.out.println(A/B);
    }
}
*/

/* 09 - 10869
import java.util.Scanner;

public class Step1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        sc.close();
        System.out.println(A+B);
        System.out.println(A-B);
        System.out.println(A*B);
        System.out.println(A/B);
        System.out.println(A%B);
    }
}
*/

/* 10 - 10430
import java.util.Scanner;

public class Step1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        sc.close();
        System.out.println((A+B)%C);
        System.out.println(((A%C) + (B%C))%C);
        System.out.println((A*B)%C);
        System.out.println(((A%C) * (B%C))%C);
    }
}
*/

/* 11 - 2588 
import java.util.Scanner;

public class Step1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        String B = sc.next();

        sc.close();
        System.out.println(A * (B.charAt(2) - '0'));
        System.out.println(A * (B.charAt(1) - '0'));
        System.out.println(A * (B.charAt(0) - '0'));
        System.out.println(A * Integer.parseInt(B));
    }
}
*/