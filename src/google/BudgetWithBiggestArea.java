package google;

public class BudgetWithBiggestArea {
	public int biggestArea(int sum,int[][] matrix){
		if(matrix == null || matrix.length == 0){
			return 0;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		int max = 0;
		for(int i=1;i<m;i++){
			for(int j=0;j<n;j++){
				matrix[i][j] = matrix[i-1][j] + matrix[i][j];
			}
		}
		for(int i=0;i<m;i++){
			for(int j=0;j<=i;j++){
				int[] temp = new int[n];
				for(int h=0;h<n;h++){
					if(j == 0){
						temp[h] = matrix[i][h];
					}
					else{
						temp[h] = matrix[i][h] - matrix[j-1][h];
					}
				}
				int height = i - j + 1;
				int start = 0;
				int end = 0;
				int total = 0;
				while(end < n){
					total += temp[end];
					if(total > sum){
						while(start <= end && total > sum){
							total -= temp[start];
							start++;
						}
					}
					if((end - start + 1) * height > max){
						max = (end - start + 1) * height;
					}
					end++;
				}
			}
		}
		return max;
	}
}
