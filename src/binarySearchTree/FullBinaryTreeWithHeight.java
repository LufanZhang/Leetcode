package binarySearchTree;

import java.util.HashMap;

public class FullBinaryTreeWithHeight {
	public static int treeNum(int height){
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		map.put(1,1);
		return treeNumHelper(map,height);
	}
	public static int treeNumHelper(HashMap<Integer,Integer> map,int height){
		if(map.containsKey(height)){
			return map.get(height);
		}
		int res = 0;
		int left = treeNumHelper(map,height-1);
		int right = 0;
		for(int i=1;i<height-1;i++){
			right += treeNumHelper(map,i);
		}
		res = left * right * 2 + left * left;
		map.put(height,res);
		return res;
	}
	public static void main(String args[]){
		int height = 4;
		int res = treeNum(height);
		System.out.println("res="+res);
	}
}
