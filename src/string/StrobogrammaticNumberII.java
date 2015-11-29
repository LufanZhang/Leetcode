package string;

import java.util.ArrayList;
/*
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Find all strobogrammatic numbers that are of length = n.
 */
public class StrobogrammaticNumberII {
	char[] num1 = {'0','1','6','8','9'};
	char[] num2 = {'0','1','9','8','6'};
	
	public ArrayList<String> findStrobogrammatic(int n){
		boolean flag = true;
		ArrayList<String> res = new ArrayList<String>();
		if((n & 1) == 1){
			flag = false;
		}
		int count = (n+1) / 2;
		StringBuilder pre = new StringBuilder();
		StringBuilder post = new StringBuilder();
		dfsHelper(res,pre,post,count,flag);
		return res;
	}
	public void dfsHelper(ArrayList<String> res,StringBuilder pre,StringBuilder post,int count,boolean flag){
		if(pre.length() + post.length() == count * 2){
			if(!flag){
				post.deleteCharAt(0);
			}
			String temp = pre.toString() + post.toString();
			res.add(temp);
			return;
		}
		for(int i=0;i<num1.length;i++){
			if(pre.length() == count - 1 && !flag && (i == 2 || i == 4)){
				continue;
			}
			pre.append(num1[i]);
			post.insert(0,num2[i]);
			dfsHelper(res,pre,post,count,flag);
			pre.deleteCharAt(pre.length()-1);
			post.deleteCharAt(0);
		}
	}
}
