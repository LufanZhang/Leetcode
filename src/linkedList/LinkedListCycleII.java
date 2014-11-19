package linkedList;
/*
 *  Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Follow up:
Can you solve it without using extra space
 */
public class LinkedListCycleII {
	   public ListNode detectCycle(ListNode head) {
	        ListNode begin = new ListNode(0);
	        if(head==null)
	        return null;
	        boolean flag = false;
	        begin.next = head;
	        ListNode fast = begin;
	        ListNode slow = begin;
	        while(fast.next!=null&&fast.next.next!=null){
	            fast = fast.next.next;
	            slow = slow.next;
	            if(slow ==fast){
	            flag = true; 
	            break;
	            }
	        }
	        if(flag==false)
	        return null;
	        slow = begin;
	        while(true){
	            slow = slow.next;
	            fast = fast.next;
	            if(slow ==fast)
	            break;
	        }
	        return slow;
	    }
}
