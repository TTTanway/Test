import java.util.Scanner;

public class KeDa1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int num = Integer.MAX_VALUE;
        if(n < 6 || n % 2 == 1){
            System.out.println(-1);
        }else{
            for(int i=0;i<n/6;i++){
                int temp = n - i * 6;
                if(temp % 8 == 0){
                    num = Math.min(num,i + temp / 8);
                }else{
                    continue;
                }
            }
            System.out.println(num == Integer.MAX_VALUE ? -1 : num);
        }
    }
}
