import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class test2 {
    public static int countBalancedRedLetters(String s) {
        Map<Character, Integer> redCount = new HashMap<>();
        Map<Character, Integer> nonRedCount = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);//charAt(i) 是 Java 中 String 类的一个方法，用来获取字符串中下标为 i 的字符
            if ((i + 1) % 2 == 1) { // 奇数位（从1开始计数）
                redCount.put(ch, redCount.getOrDefault(ch, 0) + 1);
                //put(key, value) —— 插入或更新键值对
                //getOrDefault(key, defaultValue) —— 查找键对应的值，如果不存在则返回默认值
                //get(key) —— 获取指定键的值
                //containsKey(key) —— 检查是否包含指定键
                //remove(key) —— 删除指定键的键值对
                //size() —— 获取键值对数量
                //clear() —— 清空所有键值对
                //isEmpty() —— 判断是否为空
                //keySet() —— 获取所有键的集合
                //values() —— 获取所有值的集合
                //entrySet() —— 获取所有键值对的集合
            } else {
                nonRedCount.put(ch, nonRedCount.getOrDefault(ch, 0) + 1);
            }
        }

        int result = 0;
        for (char ch : redCount.keySet()) {
            int red = redCount.getOrDefault(ch, 0);
            int nonRed = nonRedCount.getOrDefault(ch, 0);
            if (red == nonRed) {
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入字符串长度 n：");
        int n = scanner.nextInt();

        System.out.print("请输入字符串（只包含小写字母）：");
        String input = scanner.next();

        if (input.length() != n) {
            System.out.println("输入的字符串长度与 n 不一致！");
            return;
        }

        int result = countBalancedRedLetters(input);
        System.out.println("满足条件的字母个数为: " + result);
    }
}
