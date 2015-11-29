package backTracking;

import java.util.ArrayList;
import java.util.List;

public class SumGame {
	public boolean firstWillWin(int n,int target){
		List<Integer> list = new ArrayList<Integer>();
		int sum = 0;
		for(int i=1;i<=n;i++){
			list.add(i);
			sum += i;
		}
		if(sum < target){
			return false;
		}
		return firstWillWinHelper(list,target);
	}
	public boolean firstWillWinHelper(List<Integer> list,int target){
		if(list.get(list.size()-1) < target && list.get(0) + list.get(1) >= target){
			return false;
		}
		int length = list.size();
		for(int i=0;i<length;i++){
			int cur = list.get(i);
			list.remove(i);
			if(!firstWillWinHelper(list,target-cur)){
				return true;
			}
			list.add(i,cur);
		}
		return false;
	}
}
