import java.util.*;

public class KeDa2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // 读入序列长度
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        while (!list.isEmpty()) {
            Collections.sort(list); // 排序
            int size = list.size();
            int midIndex;

            if (size % 2 == 1) { // 奇数个
                midIndex = size / 2;
            } else { // 偶数个
                int x = list.get(size / 2 - 1);
                int y = list.get(size / 2);
                if (x == y) midIndex = size / 2; // 任意一个
                else midIndex = size / 2 - 1;    // 取较小的
            }

            // 输出中位数
            int midValue = list.get(midIndex);
            System.out.print(midValue + " ");

            // 删除该中位数
            list.remove(midIndex);
        }
    }
}
