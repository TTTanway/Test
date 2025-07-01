import java.util.Scanner;
import java.util.Stack;
import java.util.TreeSet;

public class DianDian_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        input = input.substring(1,input.length()-1);
        int result = judge(input);
        System.out.println(result);
    }

    public static int judge(String input) {
        int count = 0;
        Stack<Character> stack = new Stack<>();
        //TreeSet<Character> set = new TreeSet<>();
        for(char c:input.toCharArray()){
            if(Character.isUpperCase(c)){
                stack.push(c);
                count++;
            }else {
                char targetUpper = Character.toUpperCase(c);
                if(stack.contains(targetUpper)) {
                    stack.removeElement(targetUpper);
                }else{
                    return -1;
                }
            }
            if(stack.size() < 0){
                return -1;
            }
        }
        if(!stack.isEmpty()){
            return -1;
        }
        return count;
    }

}
