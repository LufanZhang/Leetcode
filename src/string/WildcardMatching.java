package string;
/*
 * mplement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false

 */
//也可以将二维转化成一维
public class WildcardMatching {
	 public boolean isMatch(String s, String p) {
	       if((s == null || s.length() == 0) && (p == null || p.length() == 0)){
	           return true;
	       }
	       if(p == null || p.length() == 0){
	           return false;
	       }
	       int count = 0;
	       int m = p.length();
	       int n = s.length();
	       for(int i=0;i<m;i++){
	           if(p.charAt(i) == '*'){
	               count++;
	           }
	       }
	       if(s == null || m-count > s.length()){
	           return false;
	       }
	       boolean[][] res = new boolean[m][n+1];
	       for(int i=0;i<m;i++){
	           for(int j=0;j<n+1;j++){
	               if(i == 0 && j == 0){
	                   res[i][j] = (p.charAt(i) == '*');
	               }
	               else if(i == 0){
	                   if(p.charAt(0) == '*'){
	                       res[i][j] = true;
	                   }
	                   else{
	                       if(j == 1 && (p.charAt(0) == '?' || p.charAt(0) == s.charAt(0))){
	                           res[i][j] = true;
	                       }
	                       else{
	                           res[i][j] = false;
	                       }
	                   }
	               }
	               else if(j == 0){
	                   if(p.charAt(i) == '*'){
	                       res[i][j] = res[i-1][j];
	                   }
	                   else{
	                       res[i][j] = false;
	                   }
	               }
	               else{
	                   if(p.charAt(i) == '*'){
	                       res[i][j] = res[i][j-1] || res[i-1][j];
	                   }
	                   else if(p.charAt(i) == '?' || p.charAt(i) == s.charAt(j-1)){
	                       res[i][j] = res[i-1][j-1];
	                   }
	                   else{
	                       res[i][j] = false;
	                   }
	               }
	           }
	       }
	       return res[m-1][n];
	    }
	 }
