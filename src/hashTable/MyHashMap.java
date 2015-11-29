package hashTable;

import java.util.Map.Entry;



public class MyHashMap {
	class Entry<K,V>{
		Entry<K,V> next;
		K key;
		V value;
		Entry(K k, V v) {   
			this.key = k;   
			this.value = v;   
			next = null;
		}  
	}
	private int size;
	private Entry<K,V>[] table;
	@SuppressWarnings("unchecked")
	public MyHashMap(int size){
		this.size = size;
		table  = new Entry[size];
	}
	public void put(K key,V value){
		int index = getIndex(key);
		if(table[index] == null){
			table[index] = new Entry<K, V>(key,value);
		}
		else{
			Entry<K,V> runner = table[index];
			boolean isExist = false;
			while(runner != null){
				if(runner.key == key || runner.key.equals(key)){
					runner.value = value;
					isExist = true;
					break;
				}
				runner = runner.next;
			}
			if(!isExist){
				Entry<K,V> newEntry = new Entry<K, V>(key,value);
				newEntry.next = table[index];
				table[index] = newEntry;
			}
		}
	}
	public V get(K key){
		int index = getIndex(key);
		if(table[index] == null){
			return null;
		}
		Entry<K,V> runner = table[index];
		while(runner != null){
			if(runner.key == key || runner.key.equals(key)){
				return runner.value;
			}
			runner = runner.next;
		}
	     return null; 
	}
	public int getIndex(K key){
		int hash = key.hashCode();
		return hash % size;
	}
}
