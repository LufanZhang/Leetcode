package linkedList;
/*
 *  Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list. 
 */
public class ReverseLinkedListII {
	   public ListNode reverseBetween(ListNode head, int m, int n) {
	        if(head==null)
	        return head;
	        if(m>=n)
	        return head;
	        ListNode begin = new ListNode(0);
	        begin.next = head;
	        ListNode runner = begin;
	        for(int i=1;i<m&&runner.next!=null;i++)
	        runner = runner.next;
	        ListNode first = runner;
	        ListNode dummyHead = first.next;
	        runner = begin;
	        for(int i=1;i<=n&&runner.next!=null;i++)
	        runner = runner.next;
	        ListNode dummyTail = runner;
	        ListNode second = dummyTail.next;
	        dummyTail.next = null;
	        reverse(dummyHead);
	        first.next = dummyTail;
	        dummyHead.next = second;
	        return begin.next;
	        
	    }
	    public void reverse(ListNode head){
	        if(head==null)
	        return;
	        ListNode begin = new ListNode(0);
	        begin.next = head;
	        ListNode runner = head;
	        while(runner.next!=null){
	            ListNode temp = begin.next;
	            begin.next = runner.next;
	            runner.next = runner.next.next;
	            begin.next.next = temp;
	        }
	    }
}
