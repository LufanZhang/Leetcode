package binarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class PrintLeaf {
	public static List<Integer> print(TreeNode root){
		List<Integer> res = new ArrayList<Integer>();
		dfsHelper(root,res);
		return res;
	}
	public static void dfsHelper(TreeNode root,List<Integer> res){
		if(root == null){
			return;
		}
		if(root.left == null && root.right ==null){
			res.add(root.val);
		}
		dfsHelper(root.left,res);
		dfsHelper(root.right,res);
	}
	public static void main(String args[]){
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		TreeNode left2 = new TreeNode(4);
		TreeNode left3 = new TreeNode(5);
		TreeNode right2 = new TreeNode(6);
		root.left = left;
		root.right = right;
		left.left = left2;
		right.left = left3;
		right.right = right2;
		List<Integer> res = print(root);
		System.out.println(res);
		
	}
}
