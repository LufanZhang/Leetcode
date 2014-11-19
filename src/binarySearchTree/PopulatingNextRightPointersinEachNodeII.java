package binarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

    You may only use constant extra space.

For example,
Given the following binary tree,

         1
       /  \
      2    3
     / \    \
    4   5    7

After calling your function, the tree should look like:

         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL

 */
public class PopulatingNextRightPointersinEachNodeII {
	public void connect(TreeLinkNode root) {
        TreeLinkNode dummy = new TreeLinkNode(0);
        TreeLinkNode parent = root;
        if (root == null){
            return;
        }
        root.next = null;
        while (parent != null){
            TreeLinkNode runner = dummy;
            while (parent != null){
                if (parent.left != null){
                    runner.next = parent.left;
                    runner = runner.next;
                }
                if (parent.right != null){
                    runner.next = parent.right;
                    runner = runner.next;
                }
                parent = parent.next;
                runner.next = null;
            }
            parent = dummy.next;
            dummy.next = null;
        }
        
    }
}
