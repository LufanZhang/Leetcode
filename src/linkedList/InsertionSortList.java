package linkedList;
/*
 * Sort a linked list using insertion sort.
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if(head==null)
        return head;
        ListNode begin = new ListNode(0);
        begin.next = head;
        ListNode runner = begin;
        while(head.next!=null){
            if(head.next.val>=head.val)
            head = head.next;
            else{
                while(runner.next!=null){
                    if(runner.next.val>head.next.val){
                        ListNode temp = runner.next;
                        runner.next = head.next;
                        head.next = head.next.next;
                        runner.next.next = temp;
                        runner = begin;
                        break;
                    }
                    runner = runner.next;
                }
            }
        }
        return begin.next;
    }
}
