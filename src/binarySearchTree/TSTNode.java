package binarySearchTree;

public class TSTNode {
	char val;
	TSTNode left,middle,right;
	boolean isEnd;
	public TSTNode(char val){
		this.val = val;
		left = middle = right = null;
		isEnd = false;
	}
}
