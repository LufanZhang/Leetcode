package linkedList;
/*
 *  Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed. 
 */
public class SwapNodesinPairs {
	   public ListNode swapPairs(ListNode head) {
	        if(head==null)
	        return head;
	        ListNode begin = new ListNode(0);
	        begin.next = head;
	        ListNode runner = begin;
	        while(head!=null&&head.next!=null){
	            runner.next = reverseFirstTwo(head);
	            runner = runner.next.next;
	            head = runner.next;
	        }
	        return begin.next;
	    }
	    public ListNode reverseFirstTwo(ListNode head){
	        ListNode begin = new ListNode(0);
	        begin.next = head;
	        begin.next = head.next;
	        head.next = head.next.next;
	        begin.next.next = head;
	        return begin.next;
	    }
}
