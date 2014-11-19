package linkedList;
/*
 *  Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3. 
 */
public class RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)
        return null;
        ListNode begin = new ListNode(0);
        begin.next = head;
        ListNode runner = head;
        while(runner!=null){
            if(runner.val!=head.val){
                head.next = runner;
                head = head.next;
            }
            runner = runner.next;
        }
        head.next = null;
        return begin.next;
    }
}
