import java.util.Scanner;

public class BaiDu2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine(); // 读掉换行符
        String[] str = new String[t];
        for(int i=0;i<t;i++){
            str[i] = scanner.nextLine();//读取整行
            //scanner.next()，它只会读取一个连续的字符串，遇到空格就结束了
            //scanner.nextLine()，它会读取整行，包括空格
        }
        for(int i=0;i<t;i++){
            String s = str[i];
            String[] parts = s.split(" ");
            int a = Integer.parseInt(parts[0]);
            int b = Integer.parseInt(parts[1]);
            String op = parts[2];
            switch (op) {
                case "+" -> System.out.println("=");
                case "-" -> {
                    int n = a - b;
                    int m = b - a;
                    System.out.println(n > m ? ">" : "<");
                }
                case "*" -> System.out.println("=");
                case "/" -> {
                    double n = (double) a / b;
                    double m = (double) b / a;
                    System.out.println(n > m ? ">" : "<");
                }
            }
        }
    }
}
