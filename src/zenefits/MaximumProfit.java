package zenefits;

public class MaximumProfit {
	 public static int maxProfit(int[] prices){
	        if(prices == null || prices.length == 0){
	            return 0;
	        }
	        int length = prices.length;
	        int[] max = new int[length];
	        int curMax = prices[length-1];
	        for(int i=length-1;i>=0;i--){
	            max[i] = Math.max(prices[i],curMax);
	            curMax = Math.max(curMax,max[i]);
	        }
	        int res = 0;
	        for(int i=0;i<length;i++){
	            res += max[i] - prices[i];
	        }
	        return res;
	    }
	 public static void main(String args[]){
		 int[] prices = {1,3,1,2};
		 int res = maxProfit(prices);
		 System.out.println("res="+res);
	 }
}
