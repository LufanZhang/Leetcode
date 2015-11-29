package linkedList;
/*
 * Sort a linked list in O(n log n) time using constant space complexity.
 */
public class SortList {
	   public ListNode sortList(ListNode head) {
	        if(head==null)
	        return head;
	        if(head.next==null)
	        return head;
	        ListNode begin = new ListNode(0);
	        begin.next = head;
	        ListNode fast = begin;
	        ListNode slow = begin;
	        while(fast.next!=null&&fast.next.next!=null){
	            slow = slow.next;
	            fast = fast.next.next;
	        }
	        ListNode back = sortList(slow.next);
	        slow.next = null;
	        ListNode front = sortList(begin.next);
	        return mergeList(front,back);
	    }
	    public static ListNode mergeList(ListNode a,ListNode b){
	        if(a==null)
	        return b;
	        if(b==null)
	        return a;
	        ListNode begin = new ListNode(0);
	        begin.next = a;
	        ListNode runner = begin;
	        while(b!=null&&a!=null){
	            if(b.val<a.val){
	                ListNode temp = b.next;
	                b.next = runner.next;
	                runner.next = b;
	                b = temp;
	            }
	            else
	            a = a.next;
	            runner = runner.next;
	        }
	        if(b!=null)
	        runner.next = b;
	        return begin.next;
	    }
	 
	
}
