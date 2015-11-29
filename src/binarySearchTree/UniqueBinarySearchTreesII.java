package binarySearchTree;

import java.util.ArrayList;

/*
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

 */
public class UniqueBinarySearchTreesII {
	 public ArrayList<TreeNode> generateTrees(int n) {
	        return generateHelper(1,n);
	    }
	   public ArrayList<TreeNode> generateHelper(int start,int end){
	       ArrayList<TreeNode> res = new ArrayList<TreeNode>();
	       if(start > end){
	           res.add(null);
	           return res;
	       }
	       for(int i=start;i<=end;i++){
	           ArrayList<TreeNode> left = generateHelper(start,i-1);
	           ArrayList<TreeNode> right = generateHelper(i+1,end);
	           for(TreeNode curLeft:left){
	               for(TreeNode curRight:right){
	                   TreeNode root = new TreeNode(i);
	                   root.left = curLeft;
	                   root.right = curRight;
	                   res.add(root);
	               }
	           }
	       }
	       return res;
	   }
}
