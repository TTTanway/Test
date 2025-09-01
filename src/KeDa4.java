import java.util.HashMap;
import java.util.Scanner;

public class KeDa4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        HashMap<Character, Integer> map = new HashMap<>();
        int len = str.length();
        for (int i = 0; i < len; i++) {
            if (!map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), 1);
            } else {
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
            }
        }
        int count = map.size();
        int num = 0;
        for (Character key : map.keySet()) {
            if (map.get(key) % 2 != 0) {
                num++;
            }
        }
        //int ans = num == 0 ? 1 : num;
        System.out.println(num);
    }
}
