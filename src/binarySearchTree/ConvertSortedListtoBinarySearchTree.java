package binarySearchTree;



/*
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class ConvertSortedListtoBinarySearchTree {
	   public TreeNode sortedListToBST(ListNode head) {
	        if(head==null)
	        return null;
	        ListNode begin = new ListNode(0);
	        begin.next = head;
	        ListNode slow = begin;
	        ListNode fast = begin;
	        while(fast.next!=null&&fast.next.next!=null){
	            slow = slow.next;
	            fast = fast.next.next;
	        }
	        TreeNode root = new TreeNode(slow.next.val);
	        ListNode right = slow.next.next;
	        slow.next = null;
	        ListNode left = begin.next;
	        TreeNode leftTree = sortedListToBST(left);
	        TreeNode rightTree = sortedListToBST(right);
	        root.left = leftTree;
	        root.right = rightTree;
	        return root;
	    }
}
