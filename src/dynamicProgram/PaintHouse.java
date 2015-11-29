package dynamicProgram;
//相邻3个不能有重复的
public class PaintHouse {
	public static int housePainter(int n){
		if(n == 0){
			return 0;
		}
		int[] res = new int[n+1];
		res[0] = 1;
		res[1] = 2;
		res[2] = 4;
		for(int i=3;i<=n;i++){
			//res[i] = 2 * res[i-3] + res[i-1];
			res[i] =  2 * res[i-1] - res[i-3];
		}
		return res[n];
	}
	public static void main(String args[]){
		int n = 3;
		int res = housePainter(n);
		System.out.println("res="+res);
	}
}
