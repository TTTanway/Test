import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String input = scanner.nextLine();
        int ans = lengthOfLongestSubstring(input);
        System.out.println("结果是: " + ans);
    }
    public static int lengthOfLongestSubstring(String s){
        int n = s.length();
        int ans = 0,r=-1;
        Set<Character> occ = new HashSet<Character>();
        for(int l=0;l<n;l++){
            if(l != 0){
                occ.remove(s.charAt(l-1));
            }
            while(r+1<n && !occ.contains(s.charAt(r+1))){
                occ.add(s.charAt(r+1));
                r++;
            }
            ans = Math.max(ans,r-l+1);
        }
        return ans;
    }
}
