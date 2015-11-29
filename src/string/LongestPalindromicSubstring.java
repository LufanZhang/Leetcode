package string;
/*
 * Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 */
public class LongestPalindromicSubstring {
//	  public String longestPalindrome(String s) {
//	      int length = s.length();
//	      if(s==null||length==0)
//	      return "";
//	      int index1 = 0;
//	      int index2 = 0;
//	      int[][] result = new int[length][length];
//	      int max = 0;
//	      for(int i=length-1;i>=0;i--){
//	          for(int j=0;j<length;j++){
//	              if(j<i)
//	              continue;
//	              else if(i==j)
//	              result[i][j] = 1;
//	              else if((j-i==1)&&s.charAt(i)==s.charAt(j)){
//	                  result[i][j] = 2;
//	              }
//	              else{
//	                  if(result[i+1][j-1]!=0&&s.charAt(i)==s.charAt(j))
//	                  result[i][j] = 2+result[i+1][j-1];
//	                  else
//	                  result[i][j] = 0;
//	              }
//	              if(result[i][j]>max){
//	                  max = result[i][j];
//	                  index1 = i;
//	                  index2 = j+1;
//	              }
//	          }
//	      }
//	      return s.substring(index1,index2);
//	    }
	public static String longestPalindrome(String s) {
        if(s == null || s.length() == 0){
            return s;
        }
        int length = s.length();
        int[] res = new int[length];
        int max = 1;
        String result = s.substring(0,1);
        for(int i=length-1;i>=0;i--){
            char cur = s.charAt(i);
            for(int j=length-1;j>i;j--){
                char second = s.charAt(j);
                if(cur == second){
                    if(j-i == 1){
                        res[j] = 2;
                    }
                    else{
                        if(res[j-1] == 0){
                            res[j] = 0;
                        }
                        else{
                            res[j] = res[j-1] + 2;
                        }
                    }
                }
                else{
                    res[j] = 0;
                }
                if(max < res[j]){
                    max = res[j];
                    result = s.substring(i,j+1);
                }
            }
            res[i] = 1;
        }
        return result;
    }
	public static void main(String args[]){
		String s = "bb";
		//String res = longestPalindrome(s);
		s = s.substring(1,1);
		System.out.println("res = "+s);
		
	}
}
