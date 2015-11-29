package dynamicProgram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;


public class NumberOfIslandsII {
	 public static List<Integer> numIslands2(int n, int m, Point[] operators) {
	      List<Integer> res = new ArrayList<Integer>();
	      if(operators == null || operators.length == 0){
	          return res;
	      }
	      int length = operators.length;
	      int[] bin = new int[m*n];
	      Arrays.fill(bin,-1);
	      HashSet<Integer> set = new HashSet<Integer>();
	      for(int i=0;i<length;i++){
	          int x = operators[i].x;
	          int y = operators[i].y;
	          int pos = x * m + y;
	          set.add(pos);
	          bin[pos] = pos;
	          //up
	          if(x-1 >= 0 && bin[(x-1)*m + y] != -1){
	             int parent = find(bin,(x-1)*m + y);
	             if(parent != pos){
	                 merge(bin,parent,pos);
	                 set.remove(parent);
	             }
	          }
	          //down
	          if(x+1 < n && bin[(x+1)*m + y] != -1){
	              int parent = find(bin,(x+1)*m + y);
	             if(parent != pos){
	                 merge(bin,parent,pos);
	                 set.remove(parent);
	             }
	          }
	          //left
	          if(y-1 >= 0 && bin[x*m + y-1] != -1){
	              int parent = find(bin,x*m + y-1);
	             if(parent != pos){
	                 merge(bin,parent,pos);
	                 set.remove(parent);
	             }
	          }
	          //right
	          if(y+1 < m && bin[x*m + y+1] != -1){
	              int parent = find(bin,x*m + y+1);
	             if(parent != pos){
	                 merge(bin,parent,pos);
	                 set.remove(parent);
	             }
	          }
	          res.add(set.size());
	      }
	      return res;
	    }
	    public static int find(int[] bin,int pos){
	        while(bin[pos] != pos){
	            pos = bin[pos];
	        }
	        return pos;
	    }
	    public static void merge(int[] bin,int pre,int cur){
	        bin[pre] = cur;
	    }
	    public static void main(String args[]){
	    	int n = 4;
	    	int m = 5;
	    	Point p1 = new Point(1,1);
	    	Point p2 = new Point(0,1);
	    	Point p3 = new Point(3,3);
	    	Point p4 = new Point(3,4);
	    	Point[] points = new Point[4];
	    	points[0] = p1;
	    	points[1] = p2;
	    	points[2] = p3;
	    	points[3] = p4;
	    	List<Integer> res = numIslands2(n,m,points);
	    	System.out.println("res="+res);
	    }
}
