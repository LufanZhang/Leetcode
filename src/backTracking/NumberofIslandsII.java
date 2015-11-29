package backTracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class NumberofIslandsII {
	 public static List<Integer> numIslands2(int n, int m, Point[] operators) {
	        // Write your code here
	        List<Integer> res = new ArrayList<Integer>();
	        if(m == 0 || n == 0 || operators == null || operators.length == 0){
	            return res;
	        }
	        int length = operators.length;
	        int[][] islands = new int[n][m];
	        res.add(0);
	        for(int l=0;l<length;l++){
	            int i = operators[l].x;
	            int j = operators[l].y;
	            int name = l+1;
	            int up = 0;
	            int down = 0;
	            int left = 0;
	            int right = 0;
	            if(i-1 >= 0){
	                up = islands[i-1][j];
	            }
	            if(i+1 < islands.length){
	                down = islands[i+1][j];
	            }
	            if(j-1 >= 0){
	                left = islands[i][j-1];
	            }
	            if(j+1 < islands[0].length){
	                right = islands[i][j+1];
	            }
	            if(up == 0 && down == 0 && left == 0 && right == 0){
	            	islands[i][j] = l+1;
	                res.add(res.get(res.size()-1)+1);
	            }
	            else{
	                int connectNum = connectIslandsNum(up,down,left,right);
	                res.add(res.get(res.size()-1)-(connectNum-1));
	                islands[i][j] = l+1;
	                expand(islands,i,j,l+1);
	            }
	            for(int a=0;a<islands.length;a++){
	            	for(int b=0;b<islands[0].length;b++){
	            		System.out.print(islands[a][b]+" ");
	            	}
	            	System.out.println("");
	            }
	            System.out.println("");
		        System.out.println("");
	        }
	        res.remove(0);
	        return res;
	    }
	    public static int connectIslandsNum(int up,int down,int left,int right){
	        HashSet<Integer> set = new HashSet<Integer>();
	        int count = 0;
	        if(up != 0){
	            set.add(up);
	        }
	        if(down != 0){
	            set.add(down);
	        }
	        if(left != 0){
	            set.add(left);
	        }
	        if(right != 0){
	            set.add(right);
	        }
	        return set.size();
	    }
	    public static void expand(int[][] islands,int i,int j,int name){
	        if(i >= islands.length || i < 0 || j >= islands[0].length || j < 0 || islands[i][j] == 0 || islands[i][j] == name){
	            return;
	        }
	        islands[i][j] = name;
	        expand(islands,i-1,j,name);
	        expand(islands,i+1,j,name);
	        expand(islands,i,j-1,name);
	        expand(islands,i,j+1,name);
	    }
    public static void main(String args[]){
    	int m = 5;
    	int n = 4;
    	int[][] array = {{1,1},{1,2},{1,3},{1,4}};
    	Point[] points = new Point[4];
    	for(int i=0;i<array.length;i++){
    		int a = array[i][0];
    		int b = array[i][1];
    		Point point = new Point(a,b);
    		points[i] = point;
    	}
    	List<Integer> res = numIslands2(n,m,points);
    	System.out.println("res = "+res);
    }
}
