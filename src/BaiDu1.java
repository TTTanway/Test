import java.math.BigDecimal;
import java.util.Scanner;

public class BaiDu1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] str = new String[n];
        for(int i=0;i<n;i++){
            str[i] = scanner.next();
        }
        //算出秒
        int[] seconds = new int[n];
        for(int i=0;i<n;i++){
            String[] parts = str[i].split(":");
            int h = Integer.parseInt(parts[0]);
            int m = Integer.parseInt(parts[1]);
            int s = Integer.parseInt(parts[2]);
            seconds[i] = h*60*60+m*60+s;
        }

        for(int i=0;i<n-1;i++){
            int diff = seconds[i+1]-seconds[i];
            if(diff < 0){
                diff += 24*60*60;
            }
            double turns = diff/60.0;
            System.out.printf("%.10f\n", turns);
        }
    }
}
