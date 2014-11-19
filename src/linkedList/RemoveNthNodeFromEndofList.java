package linkedList;
/*
 * Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.

Note:
Given n will always be valid.
Try to do this in one pass. 
 */
public class RemoveNthNodeFromEndofList {
	   public ListNode removeNthFromEnd(ListNode head, int n) {
	        if(n<=0)
	        return null;
	        ListNode begin = new ListNode(0);
	        begin.next = head;
	        ListNode fast = begin;
	        ListNode slow = begin;
	        for(int i=0;i<n;i++){
	            if(fast==null)
	            return head;
	            fast = fast.next;
	        }
	        while(fast.next!=null){
	            fast = fast.next;
	            slow = slow.next;
	        }
	        slow.next = slow.next.next;
	        return begin.next;
	    }
}
