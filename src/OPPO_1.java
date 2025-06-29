import java.util.Scanner;

public class OPPO_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int[] minmax = countONumber(input);
        System.out.println(minmax[1] + " " + minmax[0]);
    }

    public static int[] countONumber(String input) {
        int minCount = 0;
        int maxCount = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'o') {
                minCount++;
                maxCount++;
            }
            if (input.charAt(i) == '?') {
                maxCount++;
            }
        }
        return new int[]{minCount, maxCount};
    }
}
