import java.util.*;

public class Merge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入区间数组：");
        String line = scanner.nextLine();  // 输入: [[1,3],[2,6],[8,10],[15,18]]

        // 解析输入字符串为二维数组
        String[] parts = line.substring(2, line.length() - 2).split("],\\[");
        //parts = {"1,3", "2,6", "8,10", "15,18"}
        int[][] intervals = new int[parts.length][2];
        for (int i = 0; i < parts.length; i++) {
            String[] nums = parts[i].split(",");
            intervals[i][0] = Integer.parseInt(nums[0]);
            intervals[i][1] = Integer.parseInt(nums[1]);
        }

        // 调用 merge 方法
        int[][] result = merge(intervals);
        System.out.println("合并后的区间："+Arrays.deepToString(result));   //此处不能直接输出result，需要使用Arrays.deepToString()方法将二维数组转换为字符串形式输出
    }

    private static int[][] merge(int[][] intervals) {
        if(intervals.length ==0){
            return new int[0][2];   // 返回一个空的二维数组，结构合法，但无数据
        }
        Arrays.sort(intervals,new Comparator<int[]>() {   //对二维数组 intervals 的每一行进行排序，你可以指定自定义的排序规则。
            @Override
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        List<int[]> merged = new ArrayList<>();
        for(int i=0;i<intervals.length;i++){
            int L = intervals[i][0],R = intervals[i][1];
            if(merged.size()==0 || merged.get(merged.size()-1)[1]<L){    //获取 merged 列表中最后一个区间的右边界
                merged.add(new int[]{L,R});
            }else{
                merged.get(merged.size()-1)[1] = Math.max(merged.get(merged.size()-1)[1],R);
            }
        }
        return merged.toArray(new int[merged.size()][]);  //merged.toArray(...) 这是 Java 提供的 List 方法，用来将 List 转为数组
    }
}
