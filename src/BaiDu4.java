import java.util.Scanner;

public class BaiDu4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            long n = scanner.nextLong();
            long k = scanner.nextLong();
           /* long m = n / 2;
            if (n % 2 == 0) {
                if (k <= m) {
                    System.out.println(k);
                } else {
                    System.out.println(n-k+1);
                }
            }else{
                if (k <= m+1) {
                    System.out.println(k);
                } else {
                    System.out.println(n-k+1);
                }
            }*/
            long ans = Math.min(k,n-k+1);
            System.out.println(ans);
        }
    }
}
