import java.util.Arrays;
import java.util.Scanner;

public class SpiralOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        input = input.substring(2, input.length() - 2);
        String[] rows = input.split("\\],\\[");
        int[][] matrix = new int[rows.length][];
        for (int i = 0; i < rows.length; i++) {
            String[] nums = rows[i].split(",");
            matrix[i] = new int[nums.length];
            for (int j = 0; j < nums.length; j++) {
                matrix[i][j] = Integer.parseInt(nums[j].trim());
            }
        }

        int[] result = spiralOrder(matrix);
        System.out.println(Arrays.toString(result));
    }

    public static int[] spiralOrder(int[][] matrix) {
    return null;
    }
}
