package linkedList;
/*
 *  Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space? 
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if(head==null)
        return false;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null&&fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow)
            return true;
        }
        return false;
    }
}
