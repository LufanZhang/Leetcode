package array;
/*
 * Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class BestTimetoBuyandSellStockIII {
	   public int maxProfit(int[] prices) {
	        int length = prices.length;
	        if(prices==null||length<2)
	        return 0;
	        int profit = 0;
	        int min = prices[0];
	        int max = prices[length-1];
	        int[] left = new int[length];
	        int[] right = new int[length];
	        for(int i=0;i<length;i++){
	            if(prices[i]<min)
	            min = prices[i];
	            else if(prices[i]-min>profit)
	            profit = prices[i]-min;
	            left[i] = profit;
	        }
	        profit = 0;
	        for(int i=length-1;i>=0;i--){
	            if(prices[i]>max)
	            max = prices[i];
	            else if(max-prices[i]>profit)
	            profit = max-prices[i];
	            right[i] = profit;
	        }
	        profit = 0;
	        for(int i=0;i<length;i++){
	            if(left[i]+right[i]>profit)
	            profit = left[i]+right[i];
	        }
	        return profit;
	    }
}
