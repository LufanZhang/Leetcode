package google;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PeekIterator<T> implements Iterator<T> {
	private final Iterator<T> iterator;
	private T nextVal;
	public PeekIterator(Iterator<T> iterator){
		this.iterator = iterator;
		if(iterator.hasNext()){
			nextVal = iterator.next();
		}
	}
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return nextVal != null;
	}

	public T next() {
		// TODO Auto-generated method stub
		if (!hasNext()) { 
			throw (new NoSuchElementException("Iterator has no elements left.")); 
		} 
		T res = nextVal;
		if(iterator.hasNext()){
			nextVal = iterator.next();
		}
		else{
			nextVal = null;
		}
		return res;
	}
	public T peek(){
		if (!hasNext()) { 
			throw (new NoSuchElementException("Iterator has no elements left.")); 
		}
		return nextVal;
	}
		
		
		
		
		
//	private final Iterator<T> iterator; 
//	private T nextitem; 
//	public PeekIterator(Iterator<T> iterator) { 
//		this.iterator = iterator; 
//		} 
//	public boolean hasNext() { 
//		if (nextitem != null) { 
//			return true; 
//		} 
//		if (iterator.hasNext()) {
//			nextitem = iterator.next(); 
//		} 
//		return nextitem != null; 
//		} 
//	public T next() {
//		if (!hasNext()) { 
//			throw (new NoSuchElementException("Iterator has no elements left.")); 
//		} 
//		T toReturn = nextitem; 
//		nextitem = null; 
//		return toReturn; 
//		} 
//	 public T peek() {
//		 if (!hasNext()) { 
//			 throw (new NoSuchElementException("Iterator has no elements left.")); 
//		 } 
//		 return nextitem; 
//	 } 
}
