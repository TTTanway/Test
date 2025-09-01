import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BaiDu5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int len = str.length();
        Deque<Character> queue = new ArrayDeque<>();
        for(char c:str.toCharArray()){
            queue.add(c);
        }
        String[] ans = new String[len];
        for(int i=0;i<len;i++){
            char c = queue.remove();
            queue.add(c);
            ans[i] = queue.remove().toString();
        }
        for(String s:ans){
            System.out.print(s);
        }
    }
}
