import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class threeSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入目标值：");
        int n = scanner.nextInt();
        scanner.nextLine();
        int[] strs = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("请输入第 " + (i + 1) + " 个字符串：");
            strs[i] = scanner.nextInt();
        }
        List<List<Integer>> result = threesum(strs);
        System.out.println("结果为" + result);
    }
    public static List<List<Integer>> threesum(int[] nums){
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(n<3||nums[0]>=0){
            return ans;
        }
        for(int first = 0;first<n;first++){
            if(first>0&&nums[first]==nums[first-1]){
                continue;
            }
            int third = n-1;
            int target = -nums[first];
            for(int second = first+1;second<n;second++){
                if(second>first+1&&nums[second]==nums[second-1]){
                    continue;
                }
                while(second<third&&nums[second]+nums[third] > target){
                    third--;
                }
                if(second == third){
                    break;
                }
                if(nums[first]+nums[second]+nums[third]==0){
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }

            }
        }
        return ans;
    }
}
