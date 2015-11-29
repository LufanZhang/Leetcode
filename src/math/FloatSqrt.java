package math;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FloatSqrt {
	public static float sqrtCalculate(float n,int p){
		if(n == 0.0f){
			return n;
		}
		float start = 0.0f;
		float end = n / 2.0f;
		int num = 1;
		for(int i=0;i<p;i++){
			num  *= 10;
		}
		int nMid = (int)(n*num);
		while(start < end){
			float mid = start + (end - start) / 2.0f;
			int midInt = (int) (mid*mid * num);
			//System.out.println
			if(midInt == nMid){
				return mid;
			}
			else if(midInt < nMid){
				start = mid;
			}
			else{
				end = mid;
			}
		}
		return Math.abs(start-n) < Math.abs(end-n)?start:end;
	}
	public static void main(String args[]){
		float n = 15.0f;
		int p = 3;
		
		float res = sqrtCalculate(n,p);
		System.out.println("res = "+res + "n="+res*res);
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		Iterator iter = map.entrySet().iterator();
		while(iter.hasNext()){
			Map.Entry entry = (Map.Entry)iter.next();
			iter.remove();
		}
	}
}
