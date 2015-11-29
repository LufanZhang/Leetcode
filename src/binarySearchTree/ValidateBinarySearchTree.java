package binarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class ValidateBinarySearchTree {
	 public boolean isValidBST(TreeNode root) {
	        if(root == null){
	            return true;
	        }
	        long max = Long.MAX_VALUE;
	        long min = Long.MIN_VALUE;
	        long val = root.val;
	        return helper(root,min,max);
	    }
	    public boolean helper(TreeNode root,long min, long max){
	        if(root == null){
	            return true;
	        }
	        if(root.val >= max || root.val <= min){
	            return false;
	        }
	        return helper(root.left,min,(long)root.val) && helper(root.right,(long)root.val,max);
	    }	    
    //another way to solve this problem
    /*
     * private int lastVal = Integer.MIN_VALUE;
    	public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (lastVal >= root.val) {
            return false;
        }
        lastVal = root.val;
        if (!isValidBST(root.right)) {
            return false;
        }
        return true;
    }
     */
	    
	    
	    
	    public String serialize(TreeNode root) {
	        StringBuilder sb = new StringBuilder();
	        if(root == null){
	            return null;
	        }
	        Queue<TreeNode> queue = new LinkedList<TreeNode>();
	        queue.offer(root);
	        sb.append(root.val);
	        sb.append(',');
	        while(!queue.isEmpty()){
	                TreeNode cur = queue.poll();
	                if(cur.left ==null){
	                    sb.append('#');
	                }
	                else{
	                    queue.offer(cur.left);
	                    sb.append(cur.left.val);
	                }
	                sb.append(',');
	                if(cur.right == null){
	                    sb.append('#');
	                }
	                else{
	                    queue.offer(cur.right);
	                    sb.append(cur.right.val);
	                }
	                sb.append(',');
	        }
	        sb.deleteCharAt(sb.length()-1);
	        return sb.toString();
	    }

	    // Decodes your encoded data to tree.
	   
}
