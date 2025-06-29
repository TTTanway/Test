import java.util.Scanner;

public class test1 {
    // 计算数字各位之和
    public static int digitSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    // 统计区间内自余数数量
    public static int countSelfRemainderNumbers(int l, int r) {
        int count = 0;
        for (int i = l; i <= r; i++) {
            int sum = digitSum(i);
            if (sum != 0 && i % sum == 1) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入区间左端点 l：");
        int l = scanner.nextInt();

        System.out.print("请输入区间右端点 r：");
        int r = scanner.nextInt();

        if (l > r) {
            System.out.println("错误：左端点不能大于右端点！");
            return;
        }

        int result = countSelfRemainderNumbers(l, r);
        System.out.println("区间 [" + l + ", " + r + "] 内的自余数个数为: " + result);
    }
}
