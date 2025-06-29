import java.util.Scanner;

public class MaxProfit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入股票价格数组，例如 [7,1,5,3,6,4]：");
        String line = scanner.nextLine().trim();
        line = line.substring(1,line.length()-1);
        String[] pricesStr = line.split(",");
        int[] prices = new int[pricesStr.length];
        for(int i=0;i<prices.length;i++){
            prices[i] = Integer.parseInt(pricesStr[i].trim());
        }
        int result = maxProfit(prices);
        int result2 = maxProfit2(prices);
        System.out.println("最大利润为：" + result2);
    }

    private static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int n = prices.length;
        int minPrice = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(prices[i]<minPrice){
                minPrice = prices[i];
            }else if(prices[i]-minPrice>maxProfit){
                maxProfit = prices[i]-minPrice;
            }
        }
        return maxProfit;
    }

    private static int maxProfit2(int[] prices) {
        int maxProfit = 0;
        int n = prices.length;
        for(int i=0;i<n-1;i++) {
            for (int j = i + 1; j < n; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }
}
