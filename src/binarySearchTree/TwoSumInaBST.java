package binarySearchTree;

import java.util.Stack;

public class TwoSumInaBST {
	TreeNode leftCur,rightCur;
	Stack<TreeNode> stackLeft;
	Stack<TreeNode> stackRight;
	public boolean twoSum(TreeNode root,int target){
		if(root == null){
			return false;
		}
		leftCur = root;
		rightCur = root;
		stackLeft = new Stack<TreeNode>();
		stackRight = new Stack<TreeNode>();
		TreeNode left = getNext();
		TreeNode right = getPre();
		while((leftCur != null || !stackLeft.isEmpty()) && (rightCur != null || !stackRight.isEmpty())){
			if(left == right){
				break;
			}
			if(left.val + right.val == target){
				return true;
			}
			else if(left.val + right.val < target){
				left = getNext();
			}
			else{
				right = getPre();
			}
		}
		return false;
	}
	public TreeNode getNext(){
		while(leftCur != null){
			stackLeft.push(leftCur);
			leftCur = leftCur.left;
		}
		TreeNode temp = stackLeft.pop();
		leftCur = temp.right;
		return temp;
	}
	public TreeNode getPre(){
		while(rightCur != null){
			stackRight.push(rightCur);
			rightCur = rightCur.right;
		}
		TreeNode temp = stackRight.pop();
		rightCur = temp.left;
		return temp;
	}
}
