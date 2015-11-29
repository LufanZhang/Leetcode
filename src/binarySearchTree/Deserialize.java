package binarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class Deserialize {
	public static TreeNode deserialize(String data) {
        // write your code here
        if(data == null || data.length() == 0){
            return null;
        }
        String[] array = data.split(",");
        int index = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode root = new TreeNode(Integer.parseInt(array[index]));
        queue.offer(root);
        index++;
        while(index < array.length){
            TreeNode cur = queue.poll();
            if(array[index].equals("#")){
                cur.left = null;
            }
            else{
                int val = Integer.parseInt(array[index]);
                TreeNode left = new TreeNode(val);
                cur.left = left;
                queue.offer(left);
            }
            index++;
            if(array[index].equals("#")){
                cur.right = null;
            }
            else{
                int val = Integer.parseInt(array[index]);
                TreeNode right = new TreeNode(val);
                cur.right = right;
                queue.offer(right);
            }
            index++;
        }
        return root;
    }
	 public static void main(String args[]){
		 String s = "1,2,3,#,#,4,5";
		 TreeNode res = deserialize(s);
		 TreeNode left = res.left;
		 TreeNode right = res.right;
		 System.out.println("root="+res.val+"  left="+left.val+"  right="+right.val);
	 }
}
