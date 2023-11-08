package Arrays;

public class Best_Time_To_Buy_Sell_Stocks {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int maxProfit = 0;
        int n = prices.length;

        for (int price : prices) {
            int cost = price - min;
            maxProfit = Math.max(maxProfit, cost);
            min = Math.min(min, price);
        }

        return maxProfit;
    }
}


