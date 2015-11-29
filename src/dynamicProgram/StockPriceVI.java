package dynamicProgram;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class StockPriceVI {
	static Map<Character, Integer> map = new HashMap<Character, Integer>();
    private static String helper(String s) {
        char[] ss = s.toCharArray();
        for (int i = 0; i < ss.length; i++) {
                if (map.containsKey(ss)) {
                        map.put(ss[i], map.get(ss) + 1);
                } else {
                        map.put(ss[i], 1);
                }
        }
        Comparator<Character> comparator = new Comparator<Character>(){
        	public int compare(Character c1,Character c2){
        		return map.get(c2) - map.get(c1);
        	}
        };
        Queue<Character> queue = new PriorityQueue<Character>(1,comparator);
               
        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
                queue.add(entry.getKey());
        }
        StringBuilder rs = new StringBuilder("");
        while (!queue.isEmpty()) {
                Character c1 = queue.poll();
                if (queue.isEmpty()) {
                        rs.append(c1);
                        break;
                }
                Character c2 = queue.poll();
                rs.append(c1);
                rs.append(c2);
                if (map.get(c1) > 1) {
                        map.put(c1, map.get(c1) - 1);
                        queue.offer(c1);
                }
                if (map.get(c2) > 1) {
                        map.put(c2, map.get(c2) - 1);
                        queue.offer(c2);
                        
                }
        }
        return rs.toString();
}
	public static void main(String args[]){
		
	}
}
