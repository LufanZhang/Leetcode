package hashTable;

public class TempHashMap<K,V> {
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
	public TempHashMap(int size){
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
		int hash = key.hashCode() & 0x7fffffff;
		System.out.println("hash="+hash);
		System.out.println("hash%size="+hash % size);
		return hash % size;
	}
	 public static void main(String[] args) {
		 //TempHashMap<String, String> m = new TempHashMap<String,String>(1000);
		 TempHashMap<Integer, Integer> n = new TempHashMap<Integer,Integer>(1000);
//	        m.put("abc", "eee"); 
//	        m.put("abc", "bbb");
//	        m.put("bc","pass");
//	        n.put(3,3);
	        n.put(-4,1);
	        System.out.println(n.get(-4));
	    }
}
