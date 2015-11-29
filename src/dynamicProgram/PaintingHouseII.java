package dynamicProgram;
/*
 * There are a row of n houses, each house can be painted with one of the k colors. The cost of
 *  painting each house with a certain color is different. You have to paint all the houses such 
 *  that no two adjacent houses have the same color. 
 *  The cost of painting each house with a certain color is represented by a n x k cost matrix. 
 *  For example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost 
 *  of painting house 1 with color 2, and so on... Find the minimum cost to paint all houses.
 *  Note: 
All costs are positive integers. 

Follow up: 
Could you solve it in O(nk) runtime? 
 */
public class PaintingHouseII {
	public int minCostII(int[][] costs){
		if(costs == null || costs.length == 0 || costs[0].length <= 1){
			return 0;
		}
		int k = costs.length;
		int n = costs[0].length;
		int firstIndex = -1;
		int first = 0;
		int second = 0;
		for(int i=1;i<n;i++){
			int newFirst = Integer.MAX_VALUE;
			int newSecond = Integer.MAX_VALUE;
			int newFirstIndex = -1;
			for(int j=0;j<k;j++){
				int cur = costs[j][i];
				costs[j][i] = cur + (firstIndex == j? second:first);
				if(costs[j][i] < newFirst){
					newSecond = newFirst;
					newFirst = costs[j][i];
					newFirstIndex = j;
				}
				else if(costs[j][i] < newSecond){
					newSecond = costs[j][i];
				}
			}
			first = newFirst;
			firstIndex = newFirstIndex;
			second = newSecond;
		}
		return first;
	}
	public static void main(String args[]){
		int a = 4;
		int b = 8;
		int res = 7 + (a == b? a:b);
		System.out.println("res="+res);
	}
}
