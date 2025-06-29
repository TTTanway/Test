import java.util.Scanner;

public class OPPO_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] v = new int[n];
            int[] w = new int[n];
            for (int i = 0; i < n; i++) {
                v[i] = scanner.nextInt();
                w[i] = scanner.nextInt();
            }
            int[][] dp = new int[n + 1][k + 1];//dp[i][j] 表示前 i 个物品中，按位与为 j 时，所能获得的最大 w 的位或值（OR值）。
            for (int i = 0; i < n+1; i++) {
                for(int j=0;j<k+1;j++){
                    dp[i][j] = Integer.MIN_VALUE; // 表示不可达状态
                }
            }
            dp[0][0] = 0;
            for (int i = 1; i < n+1; i++) {
                for (int j = 0; j < k + 1; j++) {
                    dp[i][j] = dp[i - 1][j];
                }
                for (int j = 0; j < k + 1; j++) {
                    if (dp[i - 1][j] != Integer.MIN_VALUE) {
                        int newXor = j & v[i - 1];
                        if (newXor <= k) {
                            dp[i][newXor] = Math.max(dp[i][newXor], dp[i - 1][j] | w[i - 1]);
                        }
                    }
                }
            }
            int ans = 0;
            for (int i = 0; i < k + 1; i++) {
                ans = Math.max(ans, dp[n][i]);
            }
            System.out.println(ans);
        }
    }

}
