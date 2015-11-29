package binarySearchTree;

public class TernarySearchTree {
	private TSTNode root;
	public TernarySearchTree(){
		root = null;
	}
	public void insert(String s){
		if(s == null || s.length() == 0){
			return;
		}
		insertHelper(s,root,0);
	}
	public void insertHelper(String s,TSTNode cur,int pos){
		if(pos == s.length()){
			return;
		}
		char curChar = s.charAt(pos);
		if(cur == null){
			cur = new TSTNode(curChar);
			insertHelper(s,cur.middle,pos+1);
		}
		if(cur.val == curChar){
			if(pos == s.length()-1){
				cur.isEnd = true;
			}
			else{
				insertHelper(s,cur.middle,pos+1);
			}
		}
		else if(cur.val < curChar){
			insertHelper(s,cur.right,pos);
		}
		else{
			insertHelper(s,cur.left,pos);
		}
	}
	public boolean search(String s){
		
	}
	public void delete(String s){
		
	}
}
