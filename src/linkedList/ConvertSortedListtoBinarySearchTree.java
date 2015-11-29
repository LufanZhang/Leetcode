package linkedList;

public class ConvertSortedListtoBinarySearchTree {
	public static TreeNode sortedListToBST(ListNode head) {
	       if(head == null){
	           return null;
	       }
	       ListNode dummy = new ListNode(0);
	       ListNode slow = dummy;
	       ListNode fast = dummy;
	       dummy.next = head;
	       while(fast.next != null && fast.next.next != null){
	           slow = slow.next;
	           fast = fast.next.next;
	       }
	       ListNode rootList = slow.next;
	       ListNode rightList = rootList.next;
	       slow.next = null;
	       ListNode leftList = dummy.next;
	       TreeNode root = new TreeNode(rootList.val);
	       root.left = sortedListToBST(leftList);
	       root.right = sortedListToBST(rightList);
	       return root;
	    }
	public static void main(String args[]){
		ListNode head = new ListNode(0);
		TreeNode res = sortedListToBST(head);
		
	}
}
