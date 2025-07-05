import java.util.*;

public class Permute {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // 读取数组长度
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }

        List<List<Integer>> result = permute(nums); //Java 的泛型集合），不是数组。
        System.out.println(result);
    }

    private static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        for(int num:nums){
            output.add(num);
        }
        int n = nums.length;
        backtrack(n,output,res,0);
        return res;
    }
    public static void backtrack(int n,List<Integer> output,List<List<Integer>> res,int first){
        if(first == n){
            res.add(new ArrayList<Integer>(output));
        }
        for(int i=first;i<n;i++){
            Collections.swap(output,first,i); //Collections.swap(List<?> list, int i, int j)
            backtrack(n,output,res,first+1);
            Collections.swap(output,first,i);
        }
        /*list	     List<?>	     要交换元素的列表（如 ArrayList、LinkedList）
        i	         int	         第一个元素的索引
        j	         int	         第二个元素的索引*/
    }
}
