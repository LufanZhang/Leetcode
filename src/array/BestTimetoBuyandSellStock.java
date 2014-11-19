package array;
/*
 * Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 */
public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        int length = prices.length;
       if(prices==null||length<2)
       return 0;
       int result = 0;
       int min = prices[0];
       for(int i=0;i<length;i++){
           if(prices[i]<min)
           min = prices[i];
           else if(prices[i]-min>result)
           result = prices[i]-min;
       }
       return result;
    }
}
