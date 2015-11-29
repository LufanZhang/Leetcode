package binarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class Serialize {
    public String serialize(TreeNode root) {
        // write your code here
        if(root == null){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        sb.append(',');
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if(cur.left == null){
                sb.append('#');
                sb.append(',');
            }
            else{
                queue.offer(cur.left);
                sb.append(cur.left.val);
                sb.append(',');
            }
            if(cur.right == null){
                sb.append('#');
                sb.append(',');
            }
            else{
                queue.offer(cur.right);
                sb.append(cur.right.val);
                sb.append(',');
            }
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}
