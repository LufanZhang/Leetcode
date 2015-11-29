package wayfair;

import java.util.HashSet;


public class RemoveDuplicateList {
	class ListNode{
		int val;
		ListNode next;
		public ListNode(int val){
			this.val = val;
			next = null;
		}
	}
	//一个list,不是sorted的，用hashSet
	public ListNode remove(ListNode head){
		if(head == null){
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode runner = head;
		HashSet<Integer> set = new HashSet<Integer>();
		while(runner.next != null){
			ListNode temp = runner.next;
			if(set.contains(temp.val)){
				runner.next = runner.next.next;
			}
			else{
				set.add(temp.val);
				runner = runner.next;
			}
		}
		return dummy.next;
	}
	
	//2个sorted list要merge起来，并且remove duplicate,先merge后去重
	public ListNode removeAdndDuplicate(ListNode l1,ListNode l2){
		if(l1 == null || l2 == null){
			return l1 == null?l2:l1;
		}
		ListNode runner1 = l1;
		ListNode runner2 = l2;
		ListNode dummy = new ListNode(0);
		ListNode runner = dummy;
		while(runner1 != null && runner2 != null){
			if(runner1.val >= runner2.val){
				runner.next = runner1;
				runner1 = runner1.next;
				runner = runner.next;
				runner.next = null;
			}
			else{
				runner.next = runner2;
				runner2 = runner2.next;
				runner = runner.next;
				runner.next = null;
			}
		}
		if(runner1 != null){
			runner.next = runner1;
		}
		else{
			runner.next = runner2;
		}
		removeDuplicate(dummy.next);
		return dummy.next;
	}
	public void removeDuplicate(ListNode head){
		if(head == null){
			return;
		}
		ListNode runner = head;
		while(runner.next != null){
			if(runner.next.val != runner.val){
				runner = runner.next;
			}
			else{
				runner.next = runner.next.next;
			}
		}
	}
}
