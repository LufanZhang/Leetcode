package dynamicProgram;

import java.util.Arrays;
import java.util.Comparator;

class Ads{
	int startTime,endTime,profit;
	public Ads(int start,int end,int p){
		startTime = start;
		endTime = end;
		profit = p;
	}
}
public class AdsProfit {
public static int maxProfit(Ads[] adsSequence,int T){
	if(adsSequence == null || adsSequence.length == 0){
		return 0;
	}
	Comparator<Ads> comparator = new Comparator<Ads>(){
		public int compare(Ads a,Ads b){
			return a.endTime - b.endTime;
		}
	};
	Arrays.sort(adsSequence,comparator);
	int[] res = new int[T+1];
	int index = 0;
	int length = adsSequence.length;
	for(int i=1;i<=T;i++){
		if(index < length &&i == adsSequence[index].endTime){
			int start = adsSequence[index].startTime;
			res[i] = Math.max(res[i-1], res[start-1]+adsSequence[index].profit);
			index++;
		}
		else{
			res[i] = res[i-1];
		}
	}
	return res[T];
}
public static void main(String args[]){
	int[] start = {1,2,3,7,10,13,15};
	int[] end = {5,4,8,9,15,17,16};
	int[] profit = {6,4,2,5,1,3,7};
	int length = start.length;
	Ads[] adsSequence = new Ads[length];
	for(int i=0;i<length;i++){
		Ads cur = new Ads(start[i],end[i],profit[i]);
		adsSequence[i] = cur;
	}
	int res = maxProfit(adsSequence,17);
	System.out.println("res="+res);
}
}
