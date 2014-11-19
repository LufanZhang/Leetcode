package array;
/*
 * Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class BestTimetoBuyandSellStockII {
	   public int maxProfit(int[] prices) {
	        int length = prices.length;
	        if(prices==null||length<2)
	        return 0;
	        int result = 0;
	        boolean flag = false;
	        for(int i=0;i<length-1;i++){
	            if(flag==false){
	                if(prices[i+1]>prices[i]){
	                    result-=prices[i];
	                    flag = true;
	                }
	            }
	            else{
	                if(prices[i+1]<prices[i]){
	                    result+=prices[i];
	                    flag = false;
	                }
	            }
	        }
	        if(flag==true)
	        result+=prices[length-1];
	        return result;
	    }
}
