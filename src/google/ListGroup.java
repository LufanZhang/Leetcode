package google;

import java.util.HashSet;

public class ListGroup {
	class DoubleLinkedList<T>{
		DoubleLinkedList<T> pre,next;
		T val;
		public DoubleLinkedList(T val){
			this.val = val;
		}
	}
	public <T> int groupNum(DoubleLinkedList<T> head,DoubleLinkedList<T>[] array){
		if(head == null || array == null || array.length == 0){
			return 0;
		}
		HashSet<DoubleLinkedList<T>> set = new HashSet<DoubleLinkedList<T>>();
		int res = 0;
		int length = array.length;
		for(int i=0;i<length;i++){
			DoubleLinkedList<T> cur = array[i];
			set.add(cur);
			DoubleLinkedList<T> pre = cur.pre;
			DoubleLinkedList<T> next = cur.next;
			if(!set.contains(pre) && !set.contains(next)){
				res++;
			}
			else if(set.contains(pre) && set.contains(next)){
				res--;
			}
		}
		return res;
	}
}
