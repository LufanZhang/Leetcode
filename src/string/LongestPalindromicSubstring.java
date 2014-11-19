package string;
/*
 * Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 */
public class LongestPalindromicSubstring {
	  public String longestPalindrome(String s) {
	      int length = s.length();
	      if(s==null||length==0)
	      return "";
	      int index1 = 0;
	      int index2 = 0;
	      int[][] result = new int[length][length];
	      int max = 0;
	      for(int i=length-1;i>=0;i--){
	          for(int j=0;j<length;j++){
	              if(j<i)
	              continue;
	              else if(i==j)
	              result[i][j] = 1;
	              else if((j-i==1)&&s.charAt(i)==s.charAt(j)){
	                  result[i][j] = 2;
	              }
	              else{
	                  if(result[i+1][j-1]!=0&&s.charAt(i)==s.charAt(j))
	                  result[i][j] = 2+result[i+1][j-1];
	                  else
	                  result[i][j] = 0;
	              }
	              if(result[i][j]>max){
	                  max = result[i][j];
	                  index1 = i;
	                  index2 = j+1;
	              }
	          }
	      }
	      return s.substring(index1,index2);
	    }
}
