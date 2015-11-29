package google;

import java.util.Arrays;
//如果想降低时间复杂度可以用PriorityQueue用O(logN）的时间找到下一个可以连接的node，也就是parent
public class PrimMST {
	public int primeValue(int[][] a) { 
		if(a == null || a.length == 0){
			return 0;
		}
		int nodesNum = a.length;
		int[] minCost = new int[nodesNum];
		int[] path = new int[nodesNum];//里面放的是当前的点是从哪一个点连过来的
		boolean[] visited = new boolean[nodesNum];
		Arrays.fill(minCost,Integer.MAX_VALUE);
		minCost[0] = 0;
		path[0] = 0;
		visited[0] = true;
		int parent = 0;
		int res = 0;
		int count = 1;
		while(count < nodesNum){
			for(int i=0;i<nodesNum;i++){
				if(!visited[i] && a[parent][i] < minCost[i]){
					minCost[i] = a[parent][i];
				}
			}
			int min = Integer.MAX_VALUE;
			int preParent = parent;
			for(int i=0;i<nodesNum;i++){
				if(!visited[i] && minCost[i] < min){
					min = minCost[i];
					path[i] = preParent;
					parent = i;
				}
			}
			res += minCost[parent];
			count++;
			visited[parent] = true;
		}
		return res;
	}
}
