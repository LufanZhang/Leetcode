package array;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Test {
	
	public static void main(String[] args) {

        PriorityQueue<Integer> pq =
                new PriorityQueue<Integer>(10,
                new Comparator<Integer>() {

            public int compare(Integer i, Integer j) {
                        return j-i;
                    }
                });

        for (int i = 0; i < 20; i++) {
            pq.offer(20 - i);
        }

        for (int i = 0; i < 12; i++) {
            System.out.println(pq.poll());
        }
    }
}
