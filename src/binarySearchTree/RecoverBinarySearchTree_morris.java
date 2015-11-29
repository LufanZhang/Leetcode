package binarySearchTree;

public class RecoverBinarySearchTree_morris {
	public void recoverTree(TreeNode root) {
        if(root == null){
            return;
        }
        TreeNode first = null;
        TreeNode last = null;
        TreeNode cur = root;
        TreeNode preNode = new TreeNode(Integer.MIN_VALUE);
        //start traverse with morris
        while(cur != null){
            if(cur.left == null){
                if(cur.val < preNode.val){
                    last = cur;
                    if(first == null){
                        first = preNode;
                    }
                }
                preNode = cur;
                cur = cur.right;
            }
            else{
                //找到当前节点的上一个
                TreeNode pre = cur.left;
                while(pre.right != null && pre.right != cur){
                    pre = pre.right;
                }
                if(pre.right == cur){
                    pre.right = null;
                    if(cur.val < preNode.val){
                        last = cur;
                        if(first == null){
                            first = preNode;
                        }
                    }
                    preNode = cur;
                    cur = cur.right;
                }
                else{
                    pre.right = cur;
                    cur = cur.left;
                }
            }
        }
        int temp = first.val;
        first.val = last.val;
        last.val = temp;
    }
}
