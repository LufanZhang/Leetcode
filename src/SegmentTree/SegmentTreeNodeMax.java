package SegmentTree;

public class SegmentTreeNodeMax {
	     public int start, end, max;
	      public SegmentTreeNodeMax left, right;
	      public SegmentTreeNodeMax(int start, int end, int max) {
	          this.start = start;
	          this.end = end;
	          this.max = max;
	          this.left = this.right = null;
	      }
}
