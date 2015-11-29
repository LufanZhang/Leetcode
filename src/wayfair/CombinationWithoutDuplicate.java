package wayfair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
// i choose to use DFS to generate all possible combination,and i take the duplication and null value into consideration
public class CombinationWithoutDuplicate {
	public static List<String> combination(List<List<String>> list){
		//first initialize the result as list string 
		List<String> res = new ArrayList<String>();
		if(list == null || list.size() == 0){
			return res;
		}
		int length = list.size();
		//int this for loop, we sort every string list in list in order to make it easy to check the duplication int the next steps.
		for(int i=0;i<length;i++){
			List<String> levelList = list.get(i);
			if(levelList != null && levelList.size() != 0){
				Collections.sort(levelList);
			}
		}
		//we create the string list l to add new string and backtrack in DFS
		List<String> l = new ArrayList<String>();
		dfsHelper(res,l,list,0);
		return res;
	}
	public static void dfsHelper(List<String> res,List<String> l,List<List<String>> list,int level){ 
		//level means this will add string in levelth list
		if(level == list.size()){ // means l has contains all the string and complete one combinations,so we put thiscombination to result
			StringBuilder sb = new StringBuilder();
		      for(String s:l){
		        sb.append(s);
		        sb.append(' ');
		      }
		      sb.deleteCharAt(sb.length()-1);
		      res.add(sb.toString());
		      return;
		}
		
		List<String> levelList = list.get(level);
		//if this level contains nothing, we just ignore this level and continue to next level
		if(levelList == null || levelList.size() == 0){
	    	dfsHelper(res,l,list,level+1);
	    }
		else{
			int length = levelList.size();
			for(int i=0;i<length;i++){
				//this if condition to avoid duplicated result
				if(i > 0 && levelList.get(i).equals(levelList.get(i-1))){
					continue;
				}
				l.add(levelList.get(i));
				dfsHelper(res,l,list,level+1);
				l.remove(l.size()-1);
			}
		}
	}
	public static void main(String[] args) {
	    List<List<String>> array= new ArrayList<List<String>>();
	    List<String> list = new ArrayList<String>();
	    list.add("a");
	    list.add("b");
	    list.add("a");
	    array.add(new ArrayList<String>(list));
	    list.clear();
	    //list.add("12");
	    //list.add("35");
	    array.add(new ArrayList<String>(list));
	    list.clear();
	    list.add("woqu");
	    list.add("biequ");
	    array.add(new ArrayList<String>(list));
	    List<String> res = combination(array);
	    System.out.println("res="+res);
	  }
}
