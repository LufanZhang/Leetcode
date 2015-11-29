package dynamicProgram;

public class LongestCommonSubsequence {
	public int longestCommonSubsequence(String A, String B) {
        // write your code here
        if(A == null || B == null || A.length() == 0 || B.length() == 0){
            return 0;
        }
        int m = B.length();
        int n = A.length();
        int[][] result = new int[m][n];
        if(A.charAt(0) == B.charAt(0)){
            result[0][0] = 1;
        }
        for(int i=1;i<n;i++){
            if(A.charAt(i) != B.charAt(0)){
                result[0][i] = result[0][i-1];
            }
            else{
                result[0][i] = 1;
            }
        }
        for(int i=1;i<m;i++){
            if(B.charAt(i) != A.charAt(0)){
                result[i][0] = result[i-1][0];
            }
            else{
                result[i][0] = 1;
            }
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(B.charAt(i) == A.charAt(j)){
                    result[i][j] = result[i-1][j-1] + 1;
                }
                else{
                    result[i][j] = Math.max(result[i-1][j],result[i][j-1]);
                }
            }
        }
        return result[m-1][n-1];
    }
}
