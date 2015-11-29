package google;

import java.util.ArrayList;
import java.util.List;

public class SameSubtree {
	public List<TreeNode> findSameSubtree(TreeNode root){
		List<TreeNode> res = new ArrayList<TreeNode>();
		if(root == null){
			return res;
		}
		List<TreeNode> subtree = new ArrayList<TreeNode>();
		dfsHelper(root,subtree);
		int length = subtree.size();
		for(int i=0;i<length;i++){
			for(int j=i+1;j<length;j++){
				if(isSameTree(subtree.get(i),subtree.get(j))){
					res.add(subtree.get(i));
				}
			}
		}
		return res;
	}
	public boolean isSameTree(TreeNode a,TreeNode b){
		if(a == null && b == null){
			return true;
		}
		if(a == null || b == null){
			return false;
		}
		if(a.val != b.val){
			return false;
		}
		return isSameTree(a.left,b.left) && isSameTree(a.right,b.right);
	}
	public void dfsHelper(TreeNode root,List<TreeNode> subtree){
		if(root == null){
			return;
		}
		subtree.add(root);
		dfsHelper(root.left,subtree);
		dfsHelper(root.right,subtree);
	}
}
