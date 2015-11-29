package google;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class MyIterator<T> {
	private Iterator<Iterator<T>> iter;
	Queue<Iterator<T>> queue;
	public MyIterator(Iterator<Iterator<T>> iter){
		this.iter = iter;
		queue = new LinkedList<Iterator<T>>();
		while(iter.hasNext()){
			Iterator<T> cur = iter.next();
			if(cur.hasNext()){
				queue.offer(iter.next());
			}
		}
	}
	public boolean hasNext(){
		return !queue.isEmpty();
	}
	public T next(){
		if(!iter.hasNext()){
			return null;
		}
		Iterator<T> cur = queue.poll();
		T res = cur.next();
		if(cur.hasNext()){
			queue.offer(cur);
		}
		return res;
	}
}
