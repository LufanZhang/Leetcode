package hashTable;

import java.util.Scanner;

public class MyHashtable<K,V> {
	class Entry<K,V>{
        Entry<K,V> next;
        K key;
        V value;
        public Entry(K k,V v){
            this.key = k;
            this.value = v;
            this.next = null;
        }
    }
    private int size;
    private Entry<K,V>[] table;
    public MyHashtable(){
        this.size = 1000;
        table = new Entry[size];
    }
    public MyHashtable(int size){
        this.size = size;
        table = new Entry[size];
    }
    
    public static void main(String args[]) throws Exception {
        new TestHarness(new MyHashtable<String, String>(1000)).run();
//    	MyHashtable<String, String> m = new MyHashtable<String,String>(1000);
//        m.put("abc", "eee"); 
//        m.put("abc", "bbb");
//        m.put("bc","pass");
//        System.out.println(m.get("abc"));
       
    }
    
    public void put(K key, V value) {
        // TODO implement
        int index = getIndex(key);
        if(table[index] == null){
            table[index] = new Entry<K,V>(key,value);
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
            if(isExist){
                Entry<K,V> newEntry = new Entry<K,V>(key,value);
                newEntry.next = table[index];
                table[index] = newEntry;
            }
        }
    }

    public V get(K key) {
        // TODO implement
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
    /**
     * A helper class that tests MyHashtable by feeding it puts and gets from STDIN.
     */
    public static class TestHarness implements Runnable {
        final MyHashtable<String, String> hashtable;

        public TestHarness(MyHashtable<String, String> hashtable) {
            this.hashtable = hashtable;
        }

        public void run() {
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                String k = scanner.next();
                String v = null;
                if (k.contains("=")) {
                    String[] split = k.split("\\=");
                    k = split[0];
                    v = split[1];
                }
                if (v == null) {
                    System.out.println(hashtable.get(k));
                } else {
                    hashtable.put(k, v);
                }
            }
        }
    }
   
}
