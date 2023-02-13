package com.StriverSDEsheet.Array;

public class StockBuyAndSell {
    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        int ans = maxProfit(arr);
        System.out.println(ans);
    }
    public static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int todayPrice= 0;
        int overAllProfit = 0;
        for(int i = 0; i < prices.length; i++){
            if(prices[i]< min){
                min = prices[i];
            }
            todayPrice = prices[i]-min;
            if(overAllProfit < todayPrice){
                overAllProfit = todayPrice;
            }
        }

        return overAllProfit;
    }
}
