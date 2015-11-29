package google;

public class SumWithMultiple {
	public static int largestMultiple(int n){
		if(n == 0){
			return 0;
		}
		int[] res = new int[n+1];
		res[0] = 0;
		res[1] = 0;
		for(int i=2;i<=n;i++){
			int end = i / 2;
			int max = 0;
			for(int j=1;j<=end;j++){
				int cur = Math.max(j,res[j]) * Math.max(i-j, res[i-j]);
				if(cur > max){
					max = cur;
				}
			}
			res[i] = max;
		}
		for(int i=0;i<=n;i++){
			System.out.print(res[i]+" ");
		}
		System.out.println("");
		return res[n];
	}
	public static void main(String args[]){
		int n = 9;
		int res = largestMultiple(n);
		System.out.println("Res="+res);
	}
}
