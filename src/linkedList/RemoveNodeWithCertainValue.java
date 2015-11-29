package linkedList;

public class RemoveNodeWithCertainValue {
	public ListNode removeNode(ListNode head,int n){
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode runner = dummy;
		while(runner.next != null){
			if(runner.next.val == n){
				runner.next = runner.next.next;
			}
			else{
				runner = runner.next;
			}
		}
		return dummy.next;
	}
}
