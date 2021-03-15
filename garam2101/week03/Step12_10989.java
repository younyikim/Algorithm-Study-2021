import java.io.*;

/*public class Step12_10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int num;
        int index;

        int[] arr = new int[n];
        int[] counting = new int[10001];
        int[] sort = new int[n];

        for (int i = 0; i < n; i++) {
            num = Integer.parseInt(br.readLine());
            arr[i] = num;
            counting[num]++;
        }

        for (int i = 1; i < counting.length; i++) {
            counting[i] = counting[i - 1] + counting[i];
        }

        for (int i = 0; i < n; i++) {
            index = counting[arr[n - i - 1]] - 1;
            counting[arr[n - i - 1]]--;
            sort[index] = arr[n - i  -1];
        }

        for (int value : sort) {
            System.out.println(value);
        }
    }
}*/
public class Step12_10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] counting = new int[10001];

        for (int i = 0; i < n; i++) {
            counting[Integer.parseInt(br.readLine())]++;
        }

        for (int i = 1; i < counting.length; i++) {
            while (counting[i] > 0) {
                sb.append(i).append('\n');
                counting[i]--;
            }
        }

        System.out.println(sb);
    }
}