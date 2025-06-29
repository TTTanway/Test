import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FirstMissingPositive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        input = input.substring(1,input.length()-1);  //startIndex	截取的起始位置（包含这个位置） endIndex	截取的结束位置（不包含这个位置）
        String[] numbers = input.split(",");
        int[] nums = new int[numbers.length];
        for(int i =0;i<numbers.length;i++){
            nums[i] = Integer.parseInt(numbers[i]);
        }
        int result = firstMissingPositive(nums);
        System.out.println(result);
    }

    private static int firstMissingPositive(int[] nums) {
        //实际上，对于一个长度为 N 的数组，其中没有出现的最小正整数只能在 [1,N+1] 中。
        // 这是因为如果 [1,N] 都出现了，那么答案是 N+1，否则答案是 [1,N] 中没有出现的最小正整数。
        // 这样一来，我们将所有在 [1,N] 范围内的数放入哈希表，也可以得到最终的答案。
        Set<Integer> set = new HashSet<Integer>();
        for(int num:nums){
            if(num <= 0){
                continue;
            }else{
                set.add(num);
            }
        }
        int ex = 1;
        for(int i:set){ //Set 中的元素没有顺序（特别是 HashSet）
            if(set.contains(ex)){
                ex++;
            }else{
                break;
            }
        }
        return ex;
    }
}
