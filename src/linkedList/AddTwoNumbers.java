package linkedList;
/*
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
 */
public class AddTwoNumbers {
	   public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        if(l1==null&&l2==null)
	        return null;
	        if(l1==null||l2==null)
	        return l1==null?l2:l1;
	        ListNode start = new ListNode(0);
	        ListNode runner = start;
	        int carry = 0;
	        while(l1!=null||l2!=null){
	            int result = 0;
	            if(l1!=null){
	                result+=carry+l1.val;
	                carry = 0;
	                l1 = l1.next;
	            }
	            if(l2!=null){
	                result+=carry+l2.val;
	                carry = 0;
	                l2 = l2.next;
	            }
	            if(result>=10)
	            carry = 1;
	            runner.next = new ListNode(result%10);
	            runner =runner.next;
	        }
	        if(carry!=0)
	        runner.next = new ListNode(1);
	        return start.next;
	    }
}
