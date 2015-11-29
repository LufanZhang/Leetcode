package SegmentTree;

public class SegmentTreeNodeMin {
	public int start, end, min;
    public SegmentTreeNodeMin left;
	public SegmentTreeNodeMin right;
    public SegmentTreeNodeMin(int start, int end, int min) {
       this.start = start;
        this.end = end;
        this.min = min;
        this.left = this.right = null;
    }
    public SegmentTreeNodeMin(int start,int end){
        this.start = start;
        this.end = end;
        this.left = null;
        this.right =null;
    }
}
