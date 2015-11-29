package wayfair;

public class Meetqun {
	public int[][] printMatrix(int m,int n){
		int[][] res = new int[m+1][n+1];
		for(int i=0;i<=n;i++){
			res[0][i] = i;
		}
		for(int i=0;i<=m;i++){
			res[i][0] = i;
		}
		for(int i=1;i<=m;i++){
			for(int j=1;j<=n;j++){
				if(j == 0){
					res[i][j] = i;
				}
				else{
					res[i][j] = res[i][j-1] + res[i][0];
				}
			}
		}
		return res;
	}
}
