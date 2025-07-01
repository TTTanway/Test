import java.util.Arrays;
import java.util.Scanner;

public class MaxSlidingWindow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int[] result = maxslidingWindow(nums,k);
        System.out.println(Arrays.toString(result));
    }
    /*Java 中的 PriorityQueue 是一个 基于堆结构（最小堆） 实现的队列，它可以快速地获取最小值（默认情况下），或者我们可以自定义规则来变成最大堆。

    它的核心特点：

    自动排序：元素会自动按优先级排序。

    队头（peek）总是优先级最高的元素。

    插入（offer）和删除（poll）操作的时间复杂度是 O(log n)。*/

/*    public class Example {
        public static void main(String[] args) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();

            pq.offer(5);
            pq.offer(1);
            pq.offer(3);

            System.out.println(pq.peek()); // 输出 1，最小值
            pq.poll();                     // 移除 1
            System.out.println(pq.peek()); // 输出 3
        }
    }*/

    /*offer(E e)	添加元素
    poll()	移除并返回优先级最高的元素
    peek()	返回优先级最高的元素但不移除
    isEmpty()	判断是否为空
    size()	当前大小*/

    private static int[] maxslidingWindow(int[] nums,int k) {
        int n = nums.length;
        int[] ans = new int[n-k+1];
        return ans;
    }
}
