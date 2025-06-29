import java.util.HashMap;
import java.util.Scanner;

public class SubarraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入数组长度 n：");
        int n = scanner.nextInt();
        int[] nums = new int[n];
        System.out.println("请输入数组元素：");
        for(int i=0;i<n;i++){
            scanner.nextInt();
        }
        System.out.println("请输入目标值：");
        int k = scanner.nextInt();

        int result1 = subarraySum1(nums, k);
        int result2 = subarraySum2(nums, k);
        System.out.println("满足条件的子数组个数为：" + result1);
        //例子：[1,1,1]  k=2
    }

    private static int subarraySum2(int[] nums, int k) {
        //那么「[j..i] 这个子数组和为 k 」这个条件我们可以转化为: pre[i]−pre[j−1]==k
        int count = 0, pre = 0;
        HashMap<Integer,Integer> mp = new HashMap<Integer,Integer>();
        mp.put(0,1);
        for(int i=0;i<nums.length;i++){
            pre += nums[i];
            if(mp.containsKey(pre-k)){
                count += mp.get(pre-k);
            }
            mp.put(pre,mp.getOrDefault(pre,0)+1);
        }
        return count;
    }

    private static int subarraySum1(int[] nums, int k) {
        int count = 0;
        for(int start=0;start<nums.length;start++){
            int sum = 0;
            for(int end = start;end>=0;end--){
                sum += nums[end];
                if(sum == k){
                    count++;
                }
            }
        }
        return count;
    }


}
