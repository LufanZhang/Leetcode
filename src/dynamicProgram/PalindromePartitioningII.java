package dynamicProgram;
/*
 *  Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut. 
 */
public class PalindromePartitioningII {
	 public int minCut(String s) {
	    	int length = s.length();
	    	if(s==null||length==0)
	    	return 0;
	    	boolean[][] flag = new boolean[length][length];
	    	for(int i=length-1;i>=0;i--){
	    	    for(int j=0;j<length;j++){
	    	        if(j<=i)
	    	        flag[i][j] = true;
	    	        else{
	    	            if(s.charAt(i)==s.charAt(j)&&flag[i+1][j-1]==true)
	    	            flag[i][j] = true;
	    	            else
	    	            flag[i][j] = false;
	    	        }
	    	    }
	    	}
	    	int[] res = new int[length+1];
	    	res[length] = 0;
	    	for(int i=length-1;i>=0;i--){
	    	    int min = Integer.MAX_VALUE;
	    	    for(int j=i+1;j<=length;j++){
	    	        if(flag[i][j-1]==true&&min>1+res[j])
	    	        min = 1+res[j]; 
	    	    }
	    	    res[i] = min;
	    	}
	    	return res[0]-1;
	    }
}
