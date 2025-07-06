import java.util.Collections;
import java.util.LinkedList;
public class DecodeString {
    public static void main(String[] args) {
        DecodeString ds = new DecodeString();
        String s = "3[a]2[bc]";
        System.out.println(ds.decodeString(s));
    }
    int ptr;
    public String decodeString(String s) {
        LinkedList<String> stk = new LinkedList<>(); // 这里用 LinkedList 来模拟 栈（先进后出）
        ptr = 0;
        while(ptr < s.length()){
            char cur = s.charAt(ptr);
            if(Character.isDigit(cur)){
                String digits = getDigits(s);
                stk.addLast(digits);
            }else if(Character.isLetter(cur) || cur =='['){
                stk.addLast(String.valueOf(cur)); //把一个字符 char cur 转换成一个字符串 String 类型。
                ptr++;
            }else{ //处理 ']'
                ptr++;
                LinkedList<String> sub = new LinkedList<>();
                while(!"[".equals(stk.peekLast())){
                    sub.addLast(stk.removeLast());
                }
                Collections.reverse(sub); //你先用 addLast() 正常顺序收集，再统一翻转，就不用每次插入都控制位置，写法更简单。
                stk.removeLast();
                int repTime = Integer.parseInt(stk.removeLast());
                StringBuilder t = new StringBuilder();
                String o = getString(sub);
                while(repTime-- > 0){
                    t.append(o);
                }
                stk.addLast(t.toString());
            }
        }
        return getString(stk);
    }
    public String getDigits(String s){
        StringBuilder ret = new StringBuilder();
        while(Character.isDigit(s.charAt(ptr))){
            ret.append(s.charAt(ptr));
            ptr++;
        }
        return ret.toString();
    } //为了输出完整的数字，可能是两位或三位数字，所以需要循环遍历字符串，直到遇到非数字字符为止。

    public String getString(LinkedList<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s);
        }
        return sb.toString();
    } //将链表中的所有字符串连接成一个完整的字符串。

    /*在 Java 中，LinkedList 其实同时实现了：

    List（双向链表结构）

    Deque（双端队列）*/
    /*操作	方法名	       等价于栈的什么操作
    入栈	   addLast(x)	       push
    出栈	  removeLast()	       pop
 查看栈顶元素	peekLast()	       top*/
}
