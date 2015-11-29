package google;

public class NumArray {
	class TrieNode{
        int start,end,sum;
        TrieNode left,right;
        public TrieNode(int start,int end){
            this.start = start;
            this.end = end;
            this.sum = 0;
            this.left = this.right = null;
        }
    }
    TrieNode root;
    public NumArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return;
        }
        int end = nums.length-1;
        root = build(nums,0,end);
        //System.out.print("start="+root.start+"  end="+root.end);
    }
    public TrieNode build(int[] nums,int start,int end){
        if(start == end){
            TrieNode cur = new TrieNode(start,end);
            cur.sum = nums[start];
            return cur;
        }
        int mid = start + (end-start) / 2;
        TrieNode left = build(nums,start,mid);
        TrieNode right = build(nums,mid+1,end);
        TrieNode res = new TrieNode(start,end);
        res.left = left;
        res.right = right;
        res.sum = left.sum + right.sum;
        return res;
    }
    void update(int i, int val) {
        updateHelper(i,val,root);
    }
    public void updateHelper(int i,int val,TrieNode cur){
    	//System.out.println("cur.sum="+cur.sum);
    	System.out.println("start="+cur.start+"  end="+cur.end);
        if(cur.start == cur.end && cur.start == i){
            cur.sum = val;
            return;
        }
        int mid = cur.start + (cur.end - cur.start) / 2;
        //System.out.println("here");
        if(i <= mid){
        	System.out.println("here");
        	System.out.println("cur.left="+cur.left.sum);
            updateHelper(i,val,cur.left);
        }
        else{
            updateHelper(i,val,cur.right);
        }
        cur.sum = cur.left.sum + cur.right.sum;
    }
    public int sumRange(int i, int j) {
        return sumHelper(i,j,root);
    }
    public int sumHelper(int i,int j,TrieNode cur){
        if(cur.start == i && cur.end == j){
            return cur.sum;
        }
        int mid = cur.start + (cur.end - cur.start) / 2;
        if(j <= mid){
            return sumHelper(i,j,cur.left);
        }
        else if(i > mid){
            return sumHelper(i,j,cur.right);
        }
        else{
            return sumHelper(i,mid,cur.left) + sumHelper(mid+1,j,cur.right);
        }
    }
    public static void main(String args[]){
    	int[] nums = {1,3,5};
    	NumArray test = new NumArray(nums);
    	int res = test.sumRange(0, 2);
    	test.update(1,2);
    	res = test.sumRange(0,2);
    	System.out.println("res="+res);
    }
}
