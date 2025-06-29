import java.util.Scanner;

public class MaxSubArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入数组长度：");
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("输入数组元素：");
            nums[i] = scanner.nextInt();
        }

        int result = maxSubArray(nums);
        System.out.println("最大子数组和为：" + result);
    }

    private static int maxSubArray(int[] nums) {
        int p=0, maxans = nums[0];
        for(int i:nums){
            p = Math.max(p+i,i);
            maxans = Math.max(p,maxans);
        }
        return maxans;
    }
}
