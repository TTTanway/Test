import java.util.Arrays;
import java.util.Scanner;

public class ProductExceptSelf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入数组长度: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];
        System.out.print("输入数组元素: ");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int[] result = productExceptSelf(nums);
        System.out.print("输出数组: "+ Arrays.toString(result));
    }

    private static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        ans[0] = 1; // 第一个元素的前缀积为1
        for(int i=0;i<n;i++){
            ans[i] = ans[i-1]*nums[i-1];
        }//i左侧的前缀积
        int R = 1;
        for(int i=n-1;i>=0;i--){
            ans[i] = ans[i]*R;
            R = R*nums[i];
        }
        return ans;
    }
}
