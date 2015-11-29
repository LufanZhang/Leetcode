package string;

public class minCut {
	public static int minCut(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int length = s.length();
        //create a 2D boolean to mark if a substring is palindrome
        boolean[][] isPalindrome = new boolean[length][length];
        for(int i=length-1;i>=0;i--){
            for(int j=i;j<length;j++){
                if(i == j){
                    isPalindrome[i][j] = true;
                }
                else if(j == i + 1){
                    isPalindrome[i][j] = s.charAt(i) == s.charAt(j)? true:false;
                }
                else{
                    if(s.charAt(i) == s.charAt(j) && isPalindrome[i+1][j-1] == true){
                        isPalindrome[i][j] = true;
                    }
                }
            }
        }
        int[] res = new int[length+1];
        res[length] = -1;
        for(int i=length-1;i>=0;i--){
            int temp = Integer.MAX_VALUE;
            for(int j=i;j<length;j++){
                if(isPalindrome[i][j] == true && 1+res[j+1] < temp){
                    temp = 1+res[j+1];
                    res[i] = temp;
                }
            }
        }
        return res[0];
    }
	 public static void main(String args[]){
		 String s = "efe";
		 System.out.println("res = "+minCut(s));
	 }
}
