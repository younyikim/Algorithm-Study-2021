import java.io.*;

public class Step12_2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[8001];
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[num + 4000]++;
            sum += num;

            if (max < num) {
                max = num;
            }
            if (min > num) {
                min = num;
            }
        }

        int count = 0;
        int median = 5000;  // 중앙값
        int mode = 5000;    // 최빈값
        int modeMax = 0;    // 최빈값 최대
        boolean flag = false;   // 동일한 최빈값이 한 번만 나왔는지 아닌지 (두번째 값으로 해야되므로)

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                /* 
                    전체 개수에서 절반이 아니면 빈도수를 더해서 이동하는 것
                    더하다가 그냥 절반 넘어갈 수 있으니 중앙값 저장
                */
                if (count < (n + 1) / 2) {
                    count += arr[i];
                    median = i - 4000;
                }

                /* 
                    최빈값 찾는 것
                    지금까지 찾은 빈도수 최대값이 새로 나온 빈도수보다 작으면
                    갱신하고 빈도수에 저장. 처음 찾은 최빈값이라고 표시.
                    근데 같은 최대값인 빈도수 나왔을 경우에는
                    두번째걸로 해야되니까 이걸로 변경하고 더 이상 같은 빈도수에서
                    바꾸지 못하도록 표시
                */
                if (modeMax < arr[i]) {
                    modeMax = arr[i];
                    mode = i - 4000;
                    flag = true;
                }
                else if (arr[i] == modeMax && flag == true) {
                    mode = i - 4000;
                    flag = false;
                }
            }
        }

        System.out.println((int)Math.round((double)sum / n));
        System.out.println(median);
        System.out.println(mode);
        System.out.println(max - min);
    }
}