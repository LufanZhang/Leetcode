package SegmentTree;
/*
 * For an integer array (index from 0 to n-1, where n is the size of this array), in the corresponding 
 * SegmentTree, each node stores an extra attribute max to denote the maximum number in the interval of the 
 * array (index from start to end).

Design a query method with three parameters root, start and end, find the maximum number in the interval 
[start, end] by the given root of segment tree.
Example
For array [1, 4, 2, 3], the corresponding Segment Tree is:

                  [0, 3, max=4]
                 /             \
          [0,1,max=4]        [2,3,max=3]
          /         \        /         \
   [0,0,max=1] [1,1,max=4] [2,2,max=2], [3,3,max=3]
query(root, 1, 1), return 4

query(root, 1, 2), return 4

query(root, 2, 3), return 3

query(root, 0, 2), return 4
 */
public class SegmentTreeQuery {
	public int query(SegmentTreeNodeMax root, int start, int end) {
        // write your code here
        if(start > end){
            return 0;
        }
        if(start == root.start && end == root.end){
            return root.max;
        }
        int leftRight = root.left.end;
        int rightLeft = root.right.start;
        int result = root.max;
        if(end <= leftRight){
            result = query(root.left,start,end);
        }
        else if(start >= rightLeft){
            result = query(root.right,start,end);
        }
        else{
            result = Math.max(query(root.left,start,leftRight),query(root.right,rightLeft,end));
        }
        return result;
    }
}
