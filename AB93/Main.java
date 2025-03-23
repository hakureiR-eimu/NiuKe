import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = sc.nextInt();
        }
        if (n == 0) {
            System.out.println(0);
            return;
        }
        int[][] dp = new int[n][2];
        //0代表正数长度，1代表负数长度
        if (arr[0] > 0) dp[0][0] = 1;
        if (arr[0] < 0) dp[0][1] = 1;
        int ans = 0;
        for (int i = 1; i < n; ++i) {
            if (arr[i] == 0) {
                continue;
            } else if (arr[i] > 0) {
                dp[i][0] = dp[i - 1][0] + 1;
                if (dp[i - 1][1] != 0) {
                    dp[i][1] = dp[i - 1][1] + 1;
                }
                ans = Math.max(ans, dp[i][0]);
            } else {
                if (dp[i - 1][1] != 0) {
                    dp[i][0] = dp[i - 1][1] + 1;
                }
                dp[i][1] = dp[i - 1][0] + 1;
                ans = Math.max(ans, dp[i][0]);
            }
        }

        System.out.println(ans);
    }
}