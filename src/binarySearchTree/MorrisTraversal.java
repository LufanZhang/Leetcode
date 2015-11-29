package binarySearchTree;

import java.util.ArrayList;

public class MorrisTraversal {
	public static ArrayList<TreeNode> traverse(TreeNode root){
		ArrayList<TreeNode> res = new ArrayList<TreeNode>();
		TreeNode cur = root;
		while(cur != null){
			if(cur.left == null){
				res.add(cur);
				cur = cur.right;
			}
			else{
				//find the pre node
				TreeNode pre = cur.left;  // 把这个cur的左子树的rightMost找到
				while(pre.right != null && pre.right != cur){
					pre = pre.right;
				}
				if(pre.right == cur){  //说明前面已经把他连起来过，也就是这个node的前半部分已经遍历过了
					pre.right = null;  //恢复树
					res.add(cur);
					cur = cur.right;
				}
				else{    //给每一个有next的node但是没有right的，把它的right指向它的next
					pre.right = cur;
					cur = cur.left;
				}
			}
		}
		
		return res;
	}
	public static void main(String args[]){
		TreeNode root = new TreeNode(6);
		TreeNode left1 =  new TreeNode(2);
		TreeNode right1 = new TreeNode(7);
		root.left = left1;
		root.right = right1;
		TreeNode left2 = new TreeNode(1);
		TreeNode right2 = new TreeNode(4);
		left1.left = left2;
		left1.right = right2;
		TreeNode right3 = new TreeNode(9);
		right1.right = right3;
		TreeNode left3 = new TreeNode(3);
		TreeNode right4 = new TreeNode(5);
		right2.left = left3;
		right2.right = right4;
		TreeNode leftLast = new TreeNode(8);
		right3.left = leftLast;
		ArrayList<TreeNode> res = traverse(root);
		for(int i=0;i<res.size();i++){
			System.out.print(res.get(i).val+" ");
		}
	}
}
