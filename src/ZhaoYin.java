import java.util.Scanner;

public class ZhaoYin {
    public static boolean validateCreditCard(String cardNumber) {
        // 1. 检查卡号长度（13-19位）
        int len = cardNumber.length();
        if (len < 13 || len > 19) {
            return false;
        }

        // 2. 验证是否全为数字
        for (char c : cardNumber.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        // 3. 将卡号转换为整数数组（从左到右存储，索引1对应卡号第1位）
        int[] nums = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            nums[i] = cardNumber.charAt(i - 1) - '0';
        }

        int sum = 0;
        // 4. 从右向左遍历（i表示从左数的位置，对应从右数是 len - i + 1 位）
        for (int i = 1; i <= len; i++) {
            int digit = nums[i];
            // 计算当前位从右数是第几位
            int positionFromRight = len - i + 1;

            // 从右数偶数位：乘以2，若结果≥10则拆分为个位+十位（等价于减9）
            if (positionFromRight % 2 == 0) {
                digit *= 2;
                if (digit > 9) {
                    digit -= 9; // 等价于 (digit % 10) + (digit / 10)
                }
            }
            sum += digit;
        }

        // 5. 总和能被10整除则有效
        return sum % 10 == 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();
        boolean isValid = validateCreditCard(input);
        System.out.print(isValid);
    }
}
