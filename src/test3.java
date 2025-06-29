import java.util.*;

public class test3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个整数n：");
        int n = scanner.nextInt();
        scanner.nextLine(); // 吃掉 nextInt() 后残留的换行符
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.println("请输入第 " + (i + 1) + " 个字符串：");
            strs[i] = scanner.nextLine();
        }
        //next()	读取一个“单词”（遇到空格、回车就结束）	scanner.next()
        //nextLine()	读取一行（遇到回车就结束）	scanner.nextLine()
        //hasNext()	判断是否还有下一个“单词”	scanner.hasNext()
        //hasNextLine()	判断是否还有下一行	scanner.hasNextLine()
        //nextInt()	读取一个整数	scanner.nextInt()
        //nextDouble()	读取一个浮点数	scanner.nextDouble()
        //nextFloat()	读取一个浮点数	scanner.nextFloat()
        //nextLong()	读取一个长整数	scanner.nextLong()
        //nextShort()	读取一个短整数	scanner.nextShort()

        List<List<String>> result1 = groupAnagrams1(strs);
        System.out.println("结果为" + result1);
        List<List<String>> result2 = groupAnagrams2(strs);
        System.out.println("结果为" + result2);
    }

    public static List<List<String>> groupAnagrams1(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String str:strs){
            int[] counts = new int[26];
            int length = str.length();
            for(int i = 0;i < length;i++){
                counts[str.charAt(i) - 'a']++;
            }
            StringBuffer sb = new StringBuffer();
            for(int i = 0;i < 26;i++){
                if(counts[i] != 0){
                    sb.append((char)('a' + i));
                    sb.append(counts[i]);
                }
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key,new ArrayList<String>());
            list.add(str);
            map.put(key,list);
        }
        return new ArrayList<List<String>>(map.values());//map.values() 返回的是一个 Collection，但不是 ArrayList。所以我们用 new ArrayList<>(...) 把它包起来，创建一个新的 ArrayList。
    }

    public static List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] array = str.toCharArray();//将字符串 `str` 转换成字符数组。 例如：`"eat"` → `['e', 'a', 't']`
            Arrays.sort(array);//对字符数组进行字典序排序。 例如：`['e', 'a', 't']` → `['a', 'e', 't']`
            String key = new String(array);//将排序后的字符数组重新转为字符串，作为 map 的 key
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }

}
