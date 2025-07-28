public class quickSort {
    public void quickSort(int[] nums, int left, int right) {
        if(left < right){
            int pi = partition(nums,left,right);

            quickSort(nums,left,pi-1);
            quickSort(nums,pi+1,right);
        }
    }
    public int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left - 1;

        for(int j = left;j < right;j++){
            if(nums[j] < pivot){
                i++;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        int temp = nums[i+1];
        nums[i+1] = nums[right];
        nums[right] = temp;
        return i+1;
    }

    public static void main(String[] args) {
        quickSort quickSort = new quickSort();
        int[] nums = {3,5,2,1,4,6,7,8};
        quickSort.quickSort(nums,0,nums.length-1);
        for(int num:nums) {
            System.out.println(num);
        }
    }
}
