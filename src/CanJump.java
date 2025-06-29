import java.util.Scanner;

public class CanJump {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println(canJump(nums));
    }

    private static boolean canJump(int[] nums) {
        int maxReach = 0;
        if(nums.length == 1){
            return true;
        }
        for(int i=0;i<=nums[0];i++){
            if(i+nums[i]>=maxReach){
                maxReach = i+nums[i];
                if(maxReach>=nums.length-1){
                    return true;
                }
            }
        }
        return false;
    }
}
