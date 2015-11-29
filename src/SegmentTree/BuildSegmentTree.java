package SegmentTree;

public class BuildSegmentTree {
	public SegmentTreeNode build(int start, int end) {
        // write your code here
        if(start > end){
            return null;
        }
        SegmentTreeNode root = new SegmentTreeNode(start,end);
        if(start == end){
            return root;
        }
        int leftPart = start + (end - start) / 2;
        int rightPart = leftPart + 1;
        SegmentTreeNode left = build(start,leftPart);
        SegmentTreeNode right = build(rightPart,end);
        root.left = left;
        root.right = right;
        return root;
    }
}
