package test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {
	int size;
    PriorityQueue<Integer> minHeap, maxHeap;
    public MedianFinder(){
        size = 0;
        Comparator<Integer> minComparator = new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return a - b;
            }
        };
        Comparator<Integer> maxComparator = new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return b - a;
            }
        };
        minHeap = new PriorityQueue<Integer>(1000,minComparator);
        maxHeap = new PriorityQueue<Integer>(1000,maxComparator);
    }

    // Adds a number into the data structure.
    public void addNum(int num) {
        if((size & 1) == 0){ //size is even, so the new element should be added in maxHeap
            if(minHeap.isEmpty() || num <= minHeap.peek()){
                maxHeap.add(num);
            }
            else{
                maxHeap.add(minHeap.poll());
                minHeap.add(num);
            }
        }
        else{
            if(num >= maxHeap.peek()){
                minHeap.add(num);
            }
            else{
                minHeap.add(maxHeap.poll());
                maxHeap.add(num);
            }
        }
        size++;
    }

    // Returns the median of current data stream
    public double findMedian() {
        if(size == 0){
            return 0;
        }
        if((size & 1) == 0){
            return ((double)maxHeap.peek() + (double)minHeap.peek()) / 2.0;
        }
        else{
            return (double)maxHeap.peek();
        }
    }
    public static void main(String args[]){
    	MedianFinder mf = new MedianFinder();
    	mf.addNum(1);
    	double median = mf.findMedian();
    	System.out.println("res = "+median);
    }
}
