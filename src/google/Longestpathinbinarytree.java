package google;

public class Longestpathinbinarytree {
	public static int res;
    public int maxPathSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        res = Integer.MIN_VALUE;
        maxSinglePath(root);
        return res;
    }
    public int maxSinglePath(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = Math.max(maxSinglePath(root.left),0);
        int right = Math.max(maxSinglePath(root.right),0);
        int singlePath = root.val + Math.max(left,right);
        int doublePath = left + root.val + right;
        if(res < doublePath){
            res = doublePath;
        }
        return singlePath;
    }
}
