package dynamicProgram;
//每个石头有自己的价值，求能拿的价值最多是多少
public class KnapSackII {
	public int backPackII(int m, int[] A, int V[]) {
        // write your code here
        if(A == null || A.length == 0 || m <= 0){
            return 0;
        }
        int[] res = new int[m+1];
        for(int i=0;i<A.length;i++){
            int cur = A[i];
            for(int j=m;j>=cur;j--){
                res[j] = Math.max(res[j],res[j-cur]+V[i]);
            }
        }
        return res[m];
    }
}
