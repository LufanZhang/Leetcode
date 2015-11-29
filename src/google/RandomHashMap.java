package google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/*
 * 1. Implement HashTable with get,set,delete,getRandom functions in O(1).
 * 重点在于2个hashmap+arraylist
 * 一个hashMap存key-value，一个存key-对应在arrayList的index，用来方便删除
 * 每次删除的时候，把最后一个元素放到要删除的位置上，然后删掉最后一个
 */
public class RandomHashMap<K,V> {
	private List<K> list = new ArrayList<K>();
	private HashMap<K,V> map = new HashMap<K,V>();
	private HashMap<K,Integer> pos = new HashMap<K,Integer>();
	private int size = 0;
	public void set(K key,V val){
		map.put(key, val);
		if(!map.containsKey(key)){
			pos.put(key,list.size());
			list.add(key);
			size++;
		}
	}
	public V get(K key){
		return map.get(key);
	}
	public void delete(K key){
		if(!map.containsKey(key)){
			return;
		}
		map.remove(key);
		int position = pos.get(key);
		K last = list.get(size-1);
		pos.put(last,position);
		pos.remove(key);
		list.set(position,last);
		list.remove(size-1);
		size--;
	}
	public V getRandom(){
		Random random = new Random();
		int p = random.nextInt(size);
		return map.get(list.get(p));
	}
}
