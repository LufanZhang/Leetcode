package linkedList;
/*
 *  Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}. 
 */
public class ReorderList {
	   public void reorderList(ListNode head) {
	        if(head==null)
	        return;
	        if(head.next==null)
	        return;
	        ListNode slow = head;
	        ListNode fast = head;
	        while(fast.next!=null&&fast.next.next!=null){
	            fast = fast.next.next;
	            slow = slow.next;
	        }
	        fast = reverse(slow.next);
	        slow.next = null;
	        slow = head;
	        while(fast!=null){
	            ListNode temp = fast.next;
	            fast.next = slow.next;
	            slow.next = fast;
	            fast = temp;
	            slow = slow.next.next;
	        }
	    }
	    public ListNode reverse(ListNode list){
	        if(list==null)
	        return list;
	        if(list.next==null)
	        return list;
	        ListNode begin = new ListNode(0);
	        begin.next = list;
	        ListNode runner = list;
	        while(runner.next!=null){
	            ListNode temp = begin.next;
	            begin.next = runner.next;
	            runner.next = runner.next.next;
	            begin.next.next = temp;
	        }
	        return begin.next;
	    }
}
