package array;
/*
 *  There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

    Each child must have at least one candy.
    Children with a higher rating get more candies than their neighbors.

What is the minimum candies you must give? 
 */
public class Candy {
	  public int candy(int[] ratings) {
	        int length = ratings.length;
	        if(ratings==null||length==0)
	        return 0;
	        int[] downRight = new int[length];
	        int[] downLeft = new int[length];
	        for(int i=0;i<length;i++){
	            if(i==0)
	            downRight[i] = 1;
	            else{
	                if(ratings[i]<=ratings[i-1])
	                downRight[i] = 1;
	                else
	                downRight[i] = downRight[i-1]+1;
	            }
	        }
	        for(int i=length-1;i>=0;i--){
	            if(i==length-1)
	            downLeft[i] = 1;
	            else{
	                if(ratings[i]<=ratings[i+1])
	                downLeft[i] = 1;
	                else
	                downLeft[i] = downLeft[i+1]+1;
	            }
	        }
	        int sum = 0;
	        for(int i=0;i<length;i++){
	            sum+=downRight[i]>downLeft[i]?downRight[i]:downLeft[i];
	        }
	        return sum;
	    }
}
