import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Subsets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (sc.hasNextInt()) {
            list.add(sc.nextInt());
        }
        // 转为数组
        int[] nums = list.stream().mapToInt(i -> i).toArray(); //用于 将 List<Integer> 转换成 int[] 数组

        /*      1️⃣ list.stream()
        把 List<Integer> 变成 Stream 流
        Stream<Integer> 是一个可以链式操作的“流式结构”
        类似：你把列表扔进管道里，接下来可以对它加工处理
        2️⃣ .mapToInt(i -> i)
        把每个 Integer 映射（转换）成 int
        因为 List<Integer> 是包装类，而 int[] 是基本类型数组，必须做拆箱
        i -> i 是一个 Lambda 表达式，表示“保持不变”，只是把 Integer 转成 int
        你也可以写成 .mapToInt(Integer::intValue)
        3️⃣ .toArray()
        把所有流中的元素 收集成一个 int[] 数组
        返回值就是你要的 int[] nums*/

        List<List<Integer>> ans = new Subsets().subsets(nums);
        System.out.println(ans);
    }
    public List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> t = new ArrayList<>();
        int n = nums.length;
        for(int mask=0;mask<(1<<n);mask++){
            t.clear();
            for(int i =0;i<n;i++){
                // 位运算枚举子集 //从一个整数 mask 的二进制位，来决定从 nums 中选择哪些元素放进 t。
                // 例如，当 mask 的二进制表示为 0101 时，说明选择了 nums[1] 和 nums[3] 这两个元素。
                if((mask&(1<<i))!=0){ //&:位与运算
                    t.add(nums[i]);
                }
            }
            ans.add(new ArrayList<Integer>(t));
        }
        return ans;
    }
}
