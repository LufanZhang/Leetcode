package bitManipulation;

import java.util.ArrayList;
import java.util.List;

public class SingleNumberIII {
	public static  List<Integer> singleNumberIII(int[] A) {
        // write your code here
        List<Integer> res  = new ArrayList<Integer>();
        if(A == null || A.length <= 1){
            return res;
        }
        int length = A.length;
        int total = A[0];
        for(int i=1;i<length;i++){
            total = total ^ A[i];
        }
        int pos = 0;
        while(true){  //这里注意不能是 while(total < 0)因为total可以是小于0的
            if((total & 1) == 1){
                break;
            }
            pos++;
            total = total >> 1;
        }
        int first = 0;
        int second = 0;
        for(int i=0;i<length;i++){
            int cur = A[i] >> pos;
            if((cur & 1) == 1){
                first = first ^ A[i];
            }
            else{
                second = second ^ A[i];
            }
        }
        res.add(first);
        res.add(second);
        return res;
    }
	public static void main(String args[]){
		int[] A = {1,5,-1,1,2,2,3,4,4,5,3,2147483647,8,9,9,8};
		List<Integer> res = singleNumberIII(A);
		System.out.println(res);
	}
}
