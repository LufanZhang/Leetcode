package SegmentTree;

import java.util.ArrayList;

import array.Interval;

public class IntervalMinimumNumber {
	
public static ArrayList<Integer> intervalMinNumber(int[] A, 
                                            ArrayList<Interval> queries) {
    // write your code here
    ArrayList<Integer> res = new ArrayList<Integer>();
    if(A == null || A.length == 0){
        return res;
    }
    int length = A.length;
    SegmentTreeNodeMin root = build(0,length-1,A);
    for(Interval interval:queries){
        int cur = query(root,interval.start,interval.end);
        res.add(cur);
    }
    return res;
}
public static SegmentTreeNodeMin build(int start,int end,int[] A){
    if(start > end){
        return null;
    }
    if(start == end){
        SegmentTreeNodeMin root = new SegmentTreeNodeMin(start,end);
        root.min = A[start];
        return root;
    }
    SegmentTreeNodeMin root = new SegmentTreeNodeMin(start,end);
    SegmentTreeNodeMin left =  build(start,start+(end-start)/2,A);
    SegmentTreeNodeMin right = build(start+(end-start)/2+1,end,A);
    root.min = Math.min(left.min,right.min);
    root.left = left;
    root.right = right;
    return root;
}
public static int query(SegmentTreeNodeMin root,int start,int end){
    if(start == root.start && end == root.end){
        return root.min;
    }
    if(end <= root.left.end){
        return query(root.left,start,end);
    }
    if(start >= root.right.start){
        return query(root.right,start,end);
    }
    return Math.min(query(root.left,start,root.left.end),query(root.right,root.right.start,end));
}
public static void main(String args[]){
	int[] A = {1,2,7,8,5};
	Interval a = new Interval(1,2); 
	Interval b = new Interval(0,4);
	Interval c = new Interval(2,4);
	ArrayList<Interval> intervals = new ArrayList<Interval>();
	intervals.add(a);
	intervals.add(b);
	intervals.add(c);
	ArrayList<Integer> res = intervalMinNumber(A,intervals);
	System.out.println("res  =  "+res);
}
}
