package dynamicProgram;

public class CoinsInALineIII {
	public boolean firstWillWin(int[] values) {
        // write your code here
        if(values == null || values.length == 0){
            return true;
        }
        int length = values.length;
        int[] sum = new int[length+1];
        sum[0] = 0;
        for(int i=1;i<=length;i++){
            sum[i] = sum[i-1] + values[i-1];
        }
        int[][] res = new int[length][length];
        for(int i=length-1;i>=0;i--){
            for(int j=i;i<length;j++){
                if(i == j){
                    res[i][j] = values[i];
                }
                else if(j == i + 1){
                    res[i][j] = Math.max(values[i],values[j]);
                }
                else{
                    res[i][j] = Math.max(values[j]+(sum[j]-sum[i])-res[i][j-1],values[i]+(sum[j+1]-sum[i+1])-res[i+1][j]);
                }
            }
        }
                
        return res[0][length-1] > sum[length] - res[0][length-1];
    }
}
