import java.util.Scanner;

public class OPPO_22 {
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

                int ans = 0;
                // 枚举所有子集
                for (int mask = 0; mask < (1 << n); mask++) {         // 枚举所有 n 个物品的选法（子集）
                    int andSum = -1;  // 注意，初始值设置为所有位为 1（即全选时的按位与）
                    int orSum = 0;
                    for (int i = 0; i < n; i++) {
                        if ((mask & (1 << i)) != 0) {
                            if (andSum == -1) {
                                andSum = v[i];
                            } else {
                                andSum &= v[i];
                            }
                            orSum |= w[i];
                        }
                    }
                    if (andSum != -1 && andSum <= k) {
                        ans = Math.max(ans, orSum);
                    }
                }
                System.out.println(ans);
            }
        }
    }
