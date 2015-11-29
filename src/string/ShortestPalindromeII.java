package string;

public class ShortestPalindromeII {
	public static String shortestPalindrome2(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        String[][] dp = new String[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = String.valueOf(s.charAt(i));
        }
        for (int len = 2; len <= s.length(); len++) {
            for (int i = 0; i <= s.length() - len; i++) {
                if (s.charAt(i) == s.charAt(i + len - 1)) {
                    if (len == 2) {
                        dp[i][i + 1] = s.substring(i, i + 2);
                    } else {
                    	System.out.println("i="+i+" len="+len+" dp[i + 1][i + len - 2]="+dp[i + 1][i + len - 2]);
                        dp[i][i + len - 1] = s.charAt(i) + dp[i + 1][i + len - 2] + s.charAt(i + len - 1);
                    }
                } else {
                    if (len == 2) {
                        dp[i][i + 1] = s.substring(i, i + 2) + s.charAt(i);
                    } else {
                        dp[i][i + len - 1] = dp[i + 1][i + len - 1].length() < dp[i][i + len - 2].length() ?
                                s.charAt(i) + dp[i + 1][i + len - 1] + s.charAt(i) : s.charAt(i + len - 1) + dp[i][i + len - 2] + s.charAt(i + len - 1);
                    }
                }
            }
        }
        for(int i=0;i<dp.length;i++){
        	for(int j=0;j<dp.length;j++){
        		System.out.print(dp[i][j]+"         ");
        	}
        	System.out.println("");
        }
        return dp[0][s.length() - 1];
    }
	public static void main(String args[]){
		String s = "acdba";
		String res = shortestPalindrome2(s);
		System.out.println("res="+res);
	}
}
