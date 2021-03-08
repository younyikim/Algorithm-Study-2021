/* 01 - 2739
import java.util.Scanner;

public class Step3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 1; i < 10; i++) {
            System.out.println(N + " * " + i + " = " + (N * i));
        }
    }
}
*/

/* 02 - 10950
import java.util.Scanner;

public class Step3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] sum = new int[N][2];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                sum[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.println(sum[i][0] + sum[i][1]);
        }
    }
}
*/

/* 03 - 8393
import java.util.Scanner;

public class Step3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int sum = 0;

        for (int i = 1; i <= N; i++) {
            sum += i;
        }
        System.out.println(sum);
    }
}
*/

/* 04 - 15552
import java.io.*;
import java.util.StringTokenizer;

public class Step3 {
    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            
            int N = Integer.parseInt(br.readLine());
            
            StringTokenizer st;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                bw.write((Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())) + "\n");
            }

            br.close();
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        
    }

}
*/

/* 05 - 2741_1
import java.util.Scanner;

public class Step3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            System.out.println(i);
        }
    }

}

// 05 - 2741_2
import java.io.*;
import java.util.Scanner;


public class Step3 {
    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            //int N = sc.nextInt();

            int N = Integer.parseInt(br.readLine());

            for (int i = 1; i <= N; i++) {
                bw.write(i + "\n");
            }

            br.close();
            bw.flush();
            bw.close();
            
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

}
*/

/* 06 - 2742_1
import java.util.Scanner;

public class Step3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        for (int i = N; i > 0; i--) {
            System.out.println(i);
        }
    }

}

// 06 - 2742_2
import java.io.*;

public class Step3 {
    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            //int N = sc.nextInt();

            int N = Integer.parseInt(br.readLine());

            for (int i = N; i > 0; i--) {
                bw.write(i + "\n");
            }

            br.close();
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

}
*/

/* 07 - 11021
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Step3 {
    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            //int N = sc.nextInt();

            int N = Integer.parseInt(br.readLine());

            StringTokenizer st;

            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                bw.write("Case #" + i + ": ");
                bw.write(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()) + "\n");
            }

            br.close();
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

}
*/

/* 08 - 11022
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Step3 {
    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            //int N = sc.nextInt();

            int N = Integer.parseInt(br.readLine());
            int A;
            int B;

            StringTokenizer st;

            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                bw.write("Case #" + i + ": ");
                A = Integer.parseInt(st.nextToken());
                B = Integer.parseInt(st.nextToken());

                bw.write(A + " + " + B + " = " + (A + B) + "\n");
            }

            br.close();
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

}
*/

/* 09 - 2438
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Step3 {
    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            //int N = sc.nextInt();

            int N = Integer.parseInt(br.readLine());

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= i; j++) {
                    bw.write("*");
                }
                bw.newLine();
            }

            br.close();
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

}
*/

/* 10 - 2439
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Step3 {
    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            //int N = sc.nextInt();

            int N = Integer.parseInt(br.readLine());

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N - i; j++) {
                    bw.write(" ");
                }
                for (int k = 1; k <= i; k++) {
                    bw.write("*");
                }
                bw.newLine();
            }

            br.close();
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

}
*/

/* 11 - 10871
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Step3 {
    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            StringBuilder sb = new StringBuilder();

            int N = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");

            for (int i =0; i < N; i++) {
                int v = Integer.parseInt(st.nextToken());
                if (v < X) {
                    sb.append(v).append(" ");
                }
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