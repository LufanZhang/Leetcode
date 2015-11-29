package linkedList;

import java.util.HashMap;

public class LRU {
	//two dummmy DoubleLinkedList
		DoubleLinkedList start = new DoubleLinkedList(0,0);
		DoubleLinkedList end = new DoubleLinkedList(0,0);
		int count;
		int capacity;
		HashMap<Integer,DoubleLinkedList> map = new HashMap<Integer,DoubleLinkedList>();
	    public LRU(int capacity) {
	        	this.capacity = capacity;
	        	this.start.next = this.end;
	        	this.end.pre = this.start;
	    }
	    public int get(int key){
	        if(!map.containsKey(key))
	        return -1;
	        DoubleLinkedList cur = map.get(key);
	        moveToHead(cur);
	        return cur.val;
	    }
	    public void set(int key, int value){
	        if(map.containsKey(key)){
	            DoubleLinkedList cur = map.get(key);
	            cur.val = value;
	            moveToHead(cur);
	        }
	        else{
	            DoubleLinkedList cur = new DoubleLinkedList(key,value);
	            insertToHead(cur);
	            map.put(key,cur);
	            count++;
	            if(count>capacity){
	                map.remove(end.pre.key);
	                end.pre = end.pre.pre;
	                end.pre.next = end.pre.next.next;
	                count--;
	            }
	        }
	    }
	    public void moveToHead(DoubleLinkedList cur){
	        cur.pre.next = cur.next;
	        cur.next.pre = cur.pre;
	        insertToHead(cur);
	    }
	    public void insertToHead(DoubleLinkedList cur){
	        cur.next = start.next;
	        start.next = cur;
	        cur.pre = start;
	        cur.next.pre = cur;
	    }
	    public class DoubleLinkedList {
	        //at start, I didn't understand why we need key field in DoubleLinkedList, this key is used for 
	        //locate the last DoubleLinkedList in LRU, because key value in DoubleLinkedList is same as the 
	        //key in map, so can delete this pair of key and value in map
		int key;
		int val;
		DoubleLinkedList pre;
		DoubleLinkedList next;
		DoubleLinkedList(int key,int val){
			this.key = key;
			this.val = val;
		}
	}
}
