package binarySearchTree;

import java.util.ArrayList;

/*
 *  Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
For example:
Given the below binary tree and sum = 22,

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1

return

[
   [5,4,11,2],
   [5,8,4,5]
]

 */
public class PathSumII {
	  public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
	        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	        if(root==null)
	        return result;
	        ArrayList<Integer> list = new ArrayList<Integer>();
	        pathHelper(root,result,list,sum);
	        return result;
	    }
	    public void pathHelper(TreeNode root,ArrayList<ArrayList<Integer>> result,ArrayList<Integer> list,int target){
	        if(root==null)
	        return;
	        if(root.left==null&&root.right==null&&root.val==target){
	            list.add(target);
	            result.add(new ArrayList<Integer>(list));
	            list.remove(list.size()-1);
	            return;
	        }
	        list.add(root.val);
	        pathHelper(root.left,result,list,target-root.val);
	        pathHelper(root.right,result,list,target-root.val);
	        list.remove(list.size()-1);
	    }
}
