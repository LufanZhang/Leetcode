package binarySearchTree;

public class QuadTree {
	class QuadNode{
		int up,down,left,right,sum;
		QuadNode upLeft,upRight,downLeft,downRight;
		public QuadNode(int up,int down,int left,int right,int sum){
			this.up = up;
			this.down = down;
			this.left = left;
			this.right = right;
			this.sum = sum;
			upLeft = upRight = downLeft = downRight = null;
		}
	}
	QuadNode root;
	public QuadTree(int[][] nums){
		if(nums == null || nums.length == 0){
			root = null;
		}
		int m = nums.length;
		int n = nums[0].length;
		root = buildTree(nums,0,m-1,0,n-1);
	}
	public QuadNode buildTree(int[][] nums,int up,int down,int left,int right){
		if(up == down && left == right){
			return new QuadNode(up,down,left,right,nums[up][left]);
		}
		int midRow = up + (down - up) / 2;
		int midColumn = left + (right - left) / 2;
		QuadNode upLeft = buildTree(nums,up,midRow,left,midColumn);
		QuadNode upRight = buildTree(nums,up,midRow,midColumn+1,right);
		QuadNode downLeft = buildTree(nums,midRow+1,down,left,midColumn);
		QuadNode downRight = buildTree(nums,midRow+1,down,midColumn+1,right);
		int sum = upLeft.sum + upRight.sum + downLeft.sum + downRight.sum;
		QuadNode res = new QuadNode(up,down,left,right,sum);
		res.upLeft = upLeft;
		res.upRight = upRight;
		res.downLeft = downLeft;
		res.downRight = downRight;
		return res;
	}
}
