package linkedList;
/*
 *  Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3. 
 */
public class RemoveDuplicatesfromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)
        return head;
        if(head.next==null)
        return head;
        int count = 1;
        int cur = head.val;
        ListNode begin = new ListNode(0);
        ListNode runner = begin;
        while(head.next!=null){
            if(head.next.val==cur){
                count++;
            }
            else{
                cur = head.next.val;
                if(count==1){
                    runner.next = head;
                    runner = runner.next;
                }
                count = 1;
            }
            head = head.next;
        }
        if(count==1)
        runner.next = head;
        else
        runner.next = null;
        return begin.next;
    }
}
