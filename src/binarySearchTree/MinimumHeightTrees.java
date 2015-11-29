package binarySearchTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumHeightTrees {
    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<Integer>();
        if(n == 0){
            return res;
        }
        HashMap<Integer,List<Integer>> map = new HashMap<Integer,List<Integer>>();
        int[] degree = new int[n];
        int count = n;
        Queue<Integer> queue = new LinkedList<Integer>();
        int m = edges.length;
        for(int i=0;i<m;i++){
            int node1 = edges[i][0];
            int node2 = edges[i][1];
            degree[node1] = degree[node1]+1;
            degree[node2] = degree[node2]+1;
            if(map.containsKey(node1)){
                map.get(node1).add(node2);
            }
            else{
                List<Integer> list = new ArrayList<Integer>();
                list.add(node2);
                map.put(node1,list);
            }
            if(map.containsKey(node2)){
                map.get(node2).add(node1);
            }
            else{
                 List<Integer> list = new ArrayList<Integer>();
                list.add(node1);
                map.put(node2,list);
            }
        }
        for(int i=0;i<n;i++){
            if(degree[i] <= 1){
                queue.offer(i);
                count--;
            }
        }
        while(count > 0){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int cur = queue.poll();
                List<Integer> list = map.get(cur);
                int length = list.size();
                for(int j=0;j<length;j++){
                    int child = list.get(j);
                    degree[child] = degree[child]-1;
                    if(degree[child] == 1){
                        queue.offer(child);
                        count--;
                    }
                }
            }
        }
        while(!queue.isEmpty()){
            res.add(queue.poll());
        }
        return res;
    }
	   public static void main(String args[]){
		   int n=4;
		   int[][] edges = {{1,0},{1,2},{1,3}};
		   List<Integer> res = findMinHeightTrees(n,edges);
		   System.out.println("res="+res);
	   }
}
