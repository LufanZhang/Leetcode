package string;
/*
 *  Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false. 
 */
public class InterleavingString {
    public static boolean isInterleave(String s1, String s2, String s3) {
        int lengthS1 = s1.length();
        int lengthS2 = s2.length();
        int lengthS3 = s3.length();
        if(s1==null&&s2==null&&s3==null)
        return true;
        if(s1==null&&s2==null)
        return false;
        if(s1==null||s2==null)
        return s1==null? s3.equals(s2):s3.equals(s1);
        if(lengthS1+lengthS2!=lengthS3)
        return false;
        boolean[][] result = new boolean[lengthS2+1][lengthS1+1];
        result[0][0] = true;
        for(int i=1;i<=lengthS1;i++){
            if(result[0][i-1]==true&&s1.charAt(i-1)==s3.charAt(i-1))
            result[0][i] = true;
            else
            result[0][i] = false;
        }
        for(int i=1;i<=lengthS2;i++){
            if(result[i-1][0]==true&&s2.charAt(i-1)==s3.charAt(i-1))
            result[i][0] = true;
            else
            result[i][0] = false;
        }
        for(int i=1;i<=lengthS2;i++){
            for(int j=1;j<=lengthS1;j++){
                if((result[i-1][j]==true&&s2.charAt(i-1)==s3.charAt(i+j-1))||
                (result[i][j-1]==true&&s1.charAt(j-1)==s3.charAt(i+j-1)))
                result[i][j] = true;
                else
                result[i][j] = false;
            }
        }
        return result[lengthS2][lengthS1];
    }
}
