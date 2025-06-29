import java.util.Arrays;
import java.util.Scanner;

public class Rotate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入数组长度：");
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for(int i = 0;i<n;i++){
            System.out.println("输入数组元素：");
            nums[i] = scanner.nextInt();
        }
        System.out.println("输入右轮转次数：");
        int k = scanner.nextInt();

        int[] result = rotate(nums,k);
        System.out.println("右轮转后的数组为："+ Arrays.toString(result));
    }

    private static int[] rotate(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];
        for(int i=0;i<n;i++){
            newArr[(i+k)%n] = nums[i];
        }
        return newArr;   // System.arraycopy(newArr,0,nums,0,c); 拷贝到原数组
    }
}
