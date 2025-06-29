import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FindAnagrams {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入第一个字符串:");
        String a = scanner.nextLine();
        System.out.print("请输入第二个字符串：");
        String b = scanner.nextLine();
        List<Integer> result = findAnagrams(a,b);
        System.out.println("结果为：" + result);

    }

    public static List<Integer> findAnagrams(String a, String b) {
        int aLen = a.length(), bLen = b.length();
        if(aLen < bLen){
            return new ArrayList<Integer>();
        }
        List<Integer> ans = new ArrayList<>();
        int[] acount = new int[26];
        int[] bcount = new int[26];
        for(int i=0;i<bLen;i++){
            acount[a.charAt(i) - 'a']++;
            bcount[b.charAt(i) - 'a']++;

        }
        if(Arrays.equals(acount,bcount)){
            ans.add(0);
        }
        for(int i=0;i<aLen-bLen;i++){
            acount[a.charAt(i)-'a']--;
            acount[a.charAt(i+bLen)-'a']++;
            if(Arrays.equals(acount,bcount)){
                ans.add(i+1);
            }
        }
        return ans;
    }
}
