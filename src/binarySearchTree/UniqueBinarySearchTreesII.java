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
        ArrayList<TreeNode> result = new ArrayList<TreeNode>();
        return generateHelper(1,n);
    }
    public ArrayList<TreeNode> generateHelper(int i,int j){
        ArrayList<TreeNode> result = new ArrayList<TreeNode>();
        if(i>j){
            result.add(null);
            return result;
        }
        for(int m=i;m<=j;m++){
            ArrayList<TreeNode> left = generateHelper(i,m-1);
            ArrayList<TreeNode> right = generateHelper(m+1,j);
            for(TreeNode curLeft:left){
                for(TreeNode curRight:right){
                    TreeNode root = new TreeNode(m);
                    root.left = curLeft;
                    root.right = curRight;
                    result.add(root);
                }
            }
        }
        return result;
    }
}
