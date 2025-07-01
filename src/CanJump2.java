import java.util.Scanner;

public class CanJump2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println(canJump2(nums));
    }
    private static int canJump2(int[] nums) {
        int n = nums.length;
        int end = 0;
        int maxReach = 0;
        int steps = 0;
        for(int i=0;i<n-1;i++){
            maxReach = Math.max(maxReach,nums[i]+i);
            if(i == end){ //当到达当前能到达的最远位置时，需要进行一次跳跃
                end = maxReach;
                steps++;
            }
        }
        return steps;
    }
}
