package godaddy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class FindDuplicate {
	  class Point {
		     int x;
		     int y;
		      Point() { x = 0; y = 0; }
		     Point(int a, int b) { x = a; y = b; }
		  }
	 public List<Integer> numIslands2(int n, int m, Point[] operators) {
	      List<Integer> res = new ArrayList<Integer>();
	      if(operators == null || operators.length == 0){
	          return res;
	      }
	      int length = operators.length;
	      HashSet<Integer> set = new HashSet<Integer>(); //store the root
	      int[] bin = new int[m*n];
	      Arrays.fill(bin, -1);//positive means this cell is part of island
	      for(int i=0;i<length;i++){
	          Point cur = operators[i];
	          int pos = cur.x*n+cur.y;
	          if(bin[pos] != -1){
	              set.add(set.size());
	              continue;
	          }
	          set.add(pos);
	          //up
	          if((cur.x-1)*n+cur.y >= 0 && bin[(cur.x-1)*n+cur.y] != -1){
	              int parent = find(bin,(cur.x-1)*n+cur.y);
	              if(parent != pos){
	                  merge(bin,parent,pos);
	                  set.remove(parent);
	              }
	          }
	          //down
	          if((cur.x+1)*n+cur.y < m*n && bin[(cur.x+1)*n+cur.y] != -1){
	              int parent = find(bin,(cur.x+1)*n+cur.y);
	              if(parent != pos){
	                  merge(bin,parent,pos);
	                  set.remove(parent);
	              }
	          }
	          //left
	          if(cur.x*n+cur.y-1 >= 0 && bin[cur.x*n+cur.y-1] != -1){
	              int parent = find(bin,cur.x*n+cur.y-1);
	              if(parent != pos){
	                  merge(bin,parent,pos);
	                  set.remove(parent);
	              }
	          }
	          //right
	          if(cur.x*n+cur.y+1 < m*n && bin[cur.x*n+cur.y+1] != -1){
	              int parent = find(bin,cur.x*n+cur.y+1);
	              if(parent != pos){
	                  merge(bin,parent,pos);
	                  set.remove(parent);
	              }
	          }
	          res.add(set.size());
	      }
	      return res;
	    }
	    public int find(int[] bin,int pos){
	        while(bin[pos] != pos){
	            pos = bin[pos];
	        }
	        return pos;
	    }
	    public void merge(int[] bin,int pre,int cur){
	        bin[pre] = cur;
	    }
	public static void main(String args[]){
		int m = 4;
		int n = 5;
		FindDuplicate test = new FindDuplicate();
		int[] path = {};
	}
}
