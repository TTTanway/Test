import java.util.Scanner;

public class BaiDu6 {
    static int n;
    static long ans = 0;
    static int[] cnt = new int[20]; // 每种牌的张数

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        dfs(1, 14); // 从第1种牌开始，凑14张
        System.out.println(ans);
    }

    // 递归分配牌，index表示当前牌种，remain表示还需多少张
    static void dfs(int index, int remain) {
        if (index > n) {
            if (remain == 0 && check()) ans++;
            return;
        }
        if (remain < 0) return;
        for (int i = 0; i <= 4; i++) { // 每种牌最多4张
            cnt[index] = i;
            dfs(index + 1, remain - i);
        }
    }

    // 检查是否能胡牌
    static boolean check() {
        // 找对子
        for (int i = 1; i <= n; i++) {
            if (cnt[i] >= 2) {
                cnt[i] -= 2;
                if (canHu()) {
                    cnt[i] += 2;
                    return true;
                }
                cnt[i] += 2;
            }
        }
        return false;
    }

    // 检查剩下的牌能否分成4个面子
    static boolean canHu() {
        int[] tmp = cnt.clone();
        for (int i = 1; i <= n; i++) {
            // 先取刻子
            while (tmp[i] >= 3) tmp[i] -= 3;
            // 再取顺子
            while (i + 2 <= n && tmp[i] > 0 && tmp[i + 1] > 0 && tmp[i + 2] > 0) {
                tmp[i]--; tmp[i + 1]--; tmp[i + 2]--;
            }
        }
        for (int i = 1; i <= n; i++) if (tmp[i] != 0) return false;
        return true;
    }
}
