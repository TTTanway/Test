import java.util.Arrays;
import java.util.Scanner;

public class SetZeroes {
    /*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 输入行和列
        System.out.print("请输入行数：");
        int rows = scanner.nextInt();
        System.out.print("请输入列数：");
        int cols = scanner.nextInt();
        int[][] matrix = new int[rows][cols];
        // 提示用户输入矩阵元素
        System.out.println("请输入矩阵的每一行（每行输入 " + cols + " 个数字，用空格隔开）：");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        // 输出矩阵
        System.out.println("你输入的矩阵是：");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }*/

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入矩阵，例如 [[1,1,1],[1,0,1],[1,1,1]]：");
        String line = scanner.nextLine().trim();

        // 去除最外层的 "[[" 和 "]]"，然后按 "],[" 分割
        line = line.substring(2, line.length() - 2);
        String[] rows = line.split("\\],\\["); //split("X") 表示按照字符串 X 来拆分字符串；但 split() 的参数是正则表达式，所以特殊字符必须转义。
        //] 是正则表达式中的特殊字符，要表示普通的 ]，需要写成 \\]；[ 也是正则表达式中的特殊字符，也需要写成 \\[；Java 字符串中 \ 本身是转义符，所以要写成 \\ 才代表正则里的 \
        int[][] matrix = new int[rows.length][];
        for (int i = 0; i < rows.length; i++) {
            String[] nums = rows[i].split(",");
            matrix[i] = new int[nums.length];  //给二维数组 matrix 的第 i 行 分配一个长度为 nums.length 的一维整型数组
            for (int j = 0; j < nums.length; j++) {
                matrix[i][j] = Integer.parseInt(nums[j].trim()); //字符串转整数函数  Java 的 trim() 方法会去掉字符串两端的空格
            }
        }
        // 输出结果验证
        System.out.println("你输入的矩阵为：");
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        int[][] result = setZeroes(matrix);
        System.out.println("处理后的矩阵为：" + Arrays.deepToString(result)); //deepToString() 方法用于将多维数组转换为字符串表示
    }

    private static int[][] setZeroes(int[][] matrix) {
        int r = matrix.length, c = matrix[0].length;
        boolean[] row = new boolean[r];
        boolean[] col = new boolean[c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(matrix[i][j]==0){
                    row[i]=col[j]=true;
                }
            }
        }
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(row[i]||col[j]){
                    matrix[i][j]=0;
                }
            }
        }
        return matrix;
    }


}
