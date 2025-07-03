import java.util.*;

public class TopKFrequent {
    //优先队列默认是升序：默认优先级最高的是最小的元素，会被最早弹出（poll()）

    /*Java 中的比较器 compare(a, b) 返回值的含义如下：
    返回值	          意义
    负数 (a < b)	a 排在 b 前面（升序）
            0	a 和 b 相等
    正数 (a > b)	a 排在 b 后面（降序）*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        int[] result = topKFrequent(nums, k);
        System.out.println(Arrays.toString(result));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] ans = new int[k];
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] m, int[] n) {
                return m[1] - n[1];
            }//升序排序
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            if (pq.size() == k) {
                if (pq.peek()[1] < count) {
                    pq.poll();
                    pq.offer(new int[]{num, count});
                }
            } else {
                pq.offer(new int[]{num, count});
            }
        }
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll()[0];
        }
        return ans;
    }

    public static int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }
        List<int[]> values = new ArrayList<int[]>();
        for(Map.Entry<Integer,Integer> entry:occurrences.entrySet()){//遍历 occurrences 这个 Map<Integer, Integer> 中的所有键值对，每次循环取出一个键值对 entry。
            int num = entry.getKey();//获取键值对中的键（即数组中的元素），并将其赋值给变量 num。
            int count = entry.getValue();
            values.add(new int[]{num,count});   //获取 Map 中所有 value 的集合（不包含 key）
        }
        //时间复杂度为O(nlogk)
        int[] ans = new int[k];
        qsort(values,0,values.size()-1,ans,0,k);
        return ans;

    }

    public static void qsort(List<int[]> values, int start, int end, int[] ans,int ansIndex, int k) {
        int picked = (int) (Math.random()*(end-start+1))+start; //随机选择一个下标 picked，然后将 values 列表中下标为 picked 和 start 的两个元素交换位置。
        Collections.swap(values,picked,start); //交换 values 列表中下标为 picked 和 start 的两个元素的位置。
        int pivot = values.get(start)[1];// 以这个元素的 count 作为比较标准，将列表分成两个部分，左边的元素的 count 都小于等于 pivot，右边的元素的 count 都大于 pivot。
        int index = start;
        for(int i=start;i<=end;i++){
            if(values.get(i)[1]>=pivot){
                Collections.swap(values,index+1,i);
                index++;
            }
        }
        Collections.swap(values,start,index);
        //递归地对左右两个部分进行快速排序，直到找到前 k 个高频元素。
        if(k<=index-start){
            qsort(values,start,index-1,ans,ansIndex,k);
        }else{
            for(int i=start;i<=index;i++){
                ans[ansIndex++] = values.get(i)[0];
            }
            if(k>index-start+1){
                qsort(values,index+1,end,ans,ansIndex,k-(index-start+1));
            }
        }
    }

    public static int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<Map.Entry<Integer, Integer>>((a,b) -> b.getValue()-a.getValue());
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            pq.offer(entry);
        }
        //时间复杂度为O(nlogn)
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = Objects.requireNonNull(pq.poll()).getKey();
        }
        return ans;
    }
}
