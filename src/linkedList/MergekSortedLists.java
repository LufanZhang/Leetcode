package linkedList;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity. 
 */
public class MergekSortedLists {
//	   private Comparator<ListNode> ListNodeComparator = new Comparator<ListNode>() {
//	        public int compare(ListNode left, ListNode right) {
//	            if (left == null) {
//	                return 1;
//	            } else if (right == null) {
//	                return -1;
//	            }
//	            return left.val - right.val;
//	        }
//	    };
//	    
//	    public ListNode mergeKLists(ArrayList<ListNode> lists) {
//	        if (lists == null || lists.size() == 0) {
//	            return null;
//	        }
//	        
//	        Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), ListNodeComparator);
//	        for (int i = 0; i < lists.size(); i++) {
//	            if (lists.get(i) != null) {
//	                heap.add(lists.get(i));
//	            }
//	        }
//	        
//	        ListNode dummy = new ListNode(0);
//	        ListNode tail = dummy;
//	        while (!heap.isEmpty()) {
//	            ListNode head = heap.poll();
//	            tail.next = head;
//	            tail = head;
//	            if (head.next != null) {
//	                heap.add(head.next);
//	            }
//	        }
//	        return dummy.next;
//	    }
	public ListNode mergeKLists(List<ListNode> lists) {
        if(lists == null || lists.size() == 0){
            return null;
        }
        int k = lists.size();
        ListNode dummy = new ListNode(0);
        ListNode runner = dummy;
        Comparator<ListNode> comparator = new Comparator<ListNode>(){
            public int compare(ListNode a,ListNode b){
                return a.val - b.val;
            }
        };
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(k,comparator);
        for(int i=0;i<k;i++){
        	if(lists.get(i) != null){
        		pq.offer(lists.get(i));
        	}
        }
        while(!pq.isEmpty()){
            ListNode cur = pq.poll();
            if(cur.next != null){
                pq.offer(cur.next);
            }
            runner.next = cur;
            runner = runner.next;
            runner.next = null;
        }
        return dummy.next;
    }
}
