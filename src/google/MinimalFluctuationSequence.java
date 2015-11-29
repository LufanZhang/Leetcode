package google;

public class MinimalFluctuationSequence {
	
	public ListNode getSequence(String pattern) {
		if (pattern == null || pattern.length() == 0) {
			return null;
		}
		
		ListNode dummy = new ListNode(0);
		ListNode curr = dummy;
		curr.next = new ListNode(1);
		curr = curr.next;
		int num = 2;
		ListNode prev = dummy;
		int j = -1;
		
		for (int i = 0; i < pattern.length(); i++) {
			if (pattern.charAt(i) == 'i') {
				curr.next = new ListNode(num++);
				curr = curr.next;
				for (int k = j + 1; k <= i; k++) {
					prev = prev.next;
				}
				
				j = i;
			} else {
				ListNode temp = prev.next;
				prev.next = new ListNode(num++);
				prev.next.next = temp;
			}
		}
		
		return dummy.next;
	}
	
	class ListNode {
		
		public int val;
		public ListNode next = null;
		
		public ListNode(int val) {
			this.val = val;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimalFluctuationSequence m = new MinimalFluctuationSequence();
		ListNode head = m.getSequence("iididddiiid");
		while (head != null) {
			System.out.print(head.val+" ");
			head = head.next;
		}
	}

}

