package wepay;

import java.util.ArrayList;
import java.util.LinkedList;

public class MyHashtable<K,V> {
	class Entry<K, V> {
        K key;
        V value;  
        
        public Entry(){}
        
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
	private int size = 100; //the default size is 0
    private ArrayList<LinkedList<Entry<K, V>>> hashtable = new ArrayList<LinkedList<Entry<K, V>>>(size);

   //myHashTable constructor
   public MyHashtable(){
    for (int i = 0; i < this.size; i++) {
       hashtable.add(i, null);
   }
   }
   
   public MyHashtable(int size) {
       this.size = size;
       for (int i = 0; i < this.size; i++) {
        hashtable.add(i, null);
       }
   }
   public int getIndex(K key){
	   return key.hashCode() % size;
   }
   public V get(K key) {
       if (key == null) throw new NullPointerException(); //key cannot be null
       int index = getIndex(key);
       if (hashtable.get(index) == null) return null; // if key is not in hash table
        
       //get value from linked list
       LinkedList<Entry<K, V>> list = hashtable.get(index);
       for(Entry<K, V> entry: list){
           if (entry.key.equals(key)) return entry.value;  
       }
       return null;
   }
   public void put(K key, V value) {
       if (key == null) throw new NullPointerException(); //key cannot be null
       int index = getIndex(key);
       if (hashtable.get(index) == null){// if this key not exists, create a new linked list
        LinkedList<Entry<K, V>> list = new LinkedList<Entry<K, V>>();
        list.add(new Entry<K, V>(key, value));
        hashtable.set(index, list);
       }else{
        // if the key exists, update the value of entry
           LinkedList<Entry<K, V>> list = hashtable.get(index);
           for(Entry<K, V> entry: list){
            if (entry.key.equals(key)) {
            entry.value = value;
                return;
            } 
           }
           list.add(new Entry<K, V>(key, value));
       }
   }

public static void main(String[] args) {
	MyHashtable<String, String> m = new MyHashtable<String, String>();
        m.put("abc", "eee");
        m.put("abc", "bbb");
        m.put("ddd", "fff");
        System.out.println(m.get("ddd"));
        System.out.println(m.get("abc"));
        System.out.println(m.get("ds"));
        System.out.println(m.get("null"));
        
}


}
