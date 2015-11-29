package backTracking;

import java.util.ArrayList;
import java.util.List;

public class AdditiveNumber {
	public static boolean isAdditiveNumber(String num) {
        if(num == null || num.length() == 0){
            return true;
        }
        int length = num.length();
        int first = num.charAt(0) - '0';
        List<Integer> list = new ArrayList<Integer>();
        boolean res = dfsHelper(num,first,list,1);
        return res;
    }
    public static boolean dfsHelper(String num,int pre,List<Integer> list,int start){
        if(start == num.length()){
        	list.add(pre);
            boolean res = isValid(list);
            list.remove(list.size()-1);
            return res;
        }
        int cur = num.charAt(start) - '0';
        list.add(pre);
        if(dfsHelper(num,cur,list,start+1)){
            return true;
        }
        list.remove(list.size()-1);
        
        if(pre != 0){
            if(dfsHelper(num,pre*10+cur,list,start+1)){
                return true;
            }
        }
        return false;
    }
    public static boolean isValid(List<Integer> list){
        if(list == null || list.size() <= 2){
            return false;
        }
        int length = list.size();
        for(int i=0;i<length;i++){
        	System.out.print(list.get(i)+" ");
        }
        for(int i=0;i<length-2;i++){
            if(list.get(i) + list.get(i+1) != list.get(i+2)){
                return false;
            }
        }
        return true;
    }
    public static void main(String args[]){
    	String s = "123";
    	boolean res = isAdditiveNumber(s);
    	System.out.println("res="+res);
    }
}

