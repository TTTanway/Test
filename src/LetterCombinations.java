import java.util.*;

public class LetterCombinations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String digits = sc.nextLine();
        LetterCombinations lc = new LetterCombinations();
        List<String> combinations = lc.letterCombinations(digits);
        System.out.println(combinations);
    }
    public List<String> letterCombinations(String digits){
        List<String> combinations = new ArrayList<>();
        if(digits.length()==0){
            return combinations;
        }
        Map<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        backtrack(combinations,map,digits,0,new StringBuffer());
        return combinations;
    }
    public void backtrack(List<String> combinations,Map<Character,String> map,String digits,int index,StringBuffer combination){
        if(index == digits.length()){
            combinations.add(combination.toString());
        }else{
            char digit = digits.charAt(index);
            String letters = map.get(digit);
            int lettersCount = letters.length();
            for(int i=0;i<lettersCount;i++){
                combination.append(letters.charAt(i));//选择，添加一个可能的字母
                backtrack(combinations,map,digits,index+1,combination);//进入下一层选择
                combination.deleteCharAt(index);//回溯，移除最后一次的选择
            }
        }
    }
}
