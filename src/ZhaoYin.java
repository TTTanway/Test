import java.util.Scanner;

public class ZhaoYin {
        public static boolean validateCreditCard(String cardNumber) {
            int len = cardNumber.length();
            if(len<13 || len > 19){
                return false;
            }
            int[] nums = new int[len+1];
            for(int i=1;i<len+1;i++){
                char c = cardNumber.charAt(i-1);
                nums[i] = c - '0';
            }
            int m = 0;
            int n = 0;
            for(int i=len;i>0;i--){
                if(i%2 == 0){
                    m += (nums[i] * 2 % 10 + nums[i] * 2 / 10);
                }else{
                    n += nums[i];
                }
            }
            return (m + n) % 10 == 0;
            // 补充代码逻辑
        }
    public static void main(String[] args){
        Scanner scanner  = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();
        boolean isValid = validateCreditCard(input);
        System.out.print(isValid);
    }
}
