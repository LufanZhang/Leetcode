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
        if(root==null)
        return;
        TreeLinkNode runner = root;
        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        queue.offer(root);
        int currentLevel = 1;
        int nextLevel = 0;
        while(!queue.isEmpty()){
            runner = queue.poll();
            currentLevel--;
            if(runner.left!=null){
                queue.offer(runner.left);
                nextLevel++;
            }
            if(runner.right!=null){
                queue.offer(runner.right);
                nextLevel++;
            }
            if(currentLevel==0){
                runner.next = null;
                currentLevel = nextLevel;
                nextLevel = 0;
            }
            else
            runner.next = queue.peek();
        }
    }
}
