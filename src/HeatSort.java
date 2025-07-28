import java.util.Arrays;

public class HeatSort {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9};
        heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void heapSort(int[] nums){
        int n = nums.length;
        for(int i=n/2-1;i>=0;i--){
            heapify(nums,n,i);
        }

        for(int i=n-1;i>0;i--){
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            heapify(nums,i,0);
        }
    }
    private static void heapify(int[] nums,int n,int i){
        int largest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;
        if(left<n&&nums[left]>nums[largest]){
            largest = left;
        }
        if(right<n&&nums[right]>nums[largest]){
            largest = right;
        }
        if(largest != i){
            int swap = nums[i];
            nums[i] = nums[largest];
            nums[largest] = swap;
            heapify(nums,n,largest);
        }
    }
}
