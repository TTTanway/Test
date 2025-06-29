import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class test4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入目标值：");
        int n = scanner.nextInt();
        scanner.nextLine();
        System.out.println("请输入若干个整数，输入非数字结束：");
        List<Integer> list = new ArrayList();
        while(scanner.hasNextInt()){
            list.add(scanner.nextInt());
        }
        int[] strs = new int[list.size()];
        for(int i = 0;i<list.size();i++){
            strs[i] = list.get(i);
        }
        // 打印数组内容
        System.out.println("你输入的整数数组为：" + Arrays.toString(strs));
        int[] result = TwoSum(strs,n);
        // 输出结果
        if (result.length == 0) {
            System.out.println("未找到满足条件的两个数。");
        } else {
            System.out.println("结果为：" + Arrays.toString(result));
            System.out.println("对应的数为：" + strs[result[0]] + " 和 " + strs[result[1]]);
        }
    }

    public static int[] TwoSum(int[] nums, int target){
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];
    }
}
