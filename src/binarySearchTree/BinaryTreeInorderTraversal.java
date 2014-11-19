package binarySearchTree;

import java.util.ArrayList;

/*
 * Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},

   1
    \
     2
    /
   3

return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreeInorderTraversal {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root==null)
        return result;
        ArrayList<Integer> left = inorderTraversal(root.left);
        ArrayList<Integer> right = inorderTraversal(root.right);
        result.addAll(left);
        result.add(root.val);
        result.addAll(right);
        return result;
        
    }
}
