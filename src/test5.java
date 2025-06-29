import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class test5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<Integer>();
        while(scanner.hasNextInt()){
            list.add(scanner.nextInt());
        }
        int[] strs = new int[list.size()];
        for(int i = 0;i<list.size();i++){
            strs[i] = list.get(i);
        }
        int[] result = MoveZero(strs);
        System.out.println(Arrays.toString(result));
    }

    private static int[] MoveZero(int[] strs) {
        int n = strs.length;
        int left = 0;
        int right = 0;
        while(right < n){
            if(strs[right] != 0){
                int temp = strs[right];
                strs[right] = strs[left];
                strs[left] = temp;
                left++;
            }
            right++;
        }
        return strs;
    }

}
