import java.util.PriorityQueue;
import java.util.Scanner;

public class DianDian_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n= scanner.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i]=scanner.nextInt();
        }
        Long result = minCost(nums);
        System.out.println(result);
    }
    public static long minCost(int[] a) {
        PriorityQueue<Long> min = new PriorityQueue<>(); //按照从小到大的顺序排列
        for(int num:a){
            min.offer((long)num);
        }
        long totalCost = 0;
        while(min.size()>1){
            long first = min.poll();
            long second = min.poll();
            long cost = first+second;
            totalCost += cost;
            min.offer(cost);
        }
        return totalCost;
    }
}
