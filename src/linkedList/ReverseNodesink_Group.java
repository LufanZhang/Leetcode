package linkedList;
/*
 *  Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5 
 */
public class ReverseNodesink_Group {
	   public ListNode reverseKGroup(ListNode head, int k) {
	        if(head==null||k<=1)
	        return head;
	        ListNode begin = new ListNode(0);
	        begin.next = head;
	        ListNode runner = begin;
	        int length = 0;
	        while(runner.next!=null){
	            runner = runner.next;
	            length++;
	        }
	        if(length<k)
	        return head;
	        ListNode front = begin;
	        ListNode back = begin;
	        ListNode first = begin;
	        ListNode last = begin;
	        int count = length/k;
	        for(int i=1;i<=count;i++){
	            for(int j=0;j<k;j++)
	            last = last.next;
	            first = front.next;
	            back = last.next;
	            last.next = null;
	            reverse(first);
	            front.next = last;
	            first.next = back;
	            front = first;
	            last = front;
	        }
	        return begin.next;
	    }
	    public void reverse(ListNode head){
	        ListNode begin = new ListNode(0);
	        begin.next = head;
	        while(head.next!=null){
	            ListNode temp = begin.next;
	            begin.next = head.next;
	            head.next = head.next.next;
	            begin.next.next = temp;
	        }
	    }
}
