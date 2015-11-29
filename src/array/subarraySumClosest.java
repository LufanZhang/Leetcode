package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class SumNum{
    private int index;
    private int num;
    public SumNum(int index,int num){
        this.index = index;
        this.num = num;
    }
    public int getIndex(){
        return index;
    }
    public int getNum(){
        return num;
    }
}

public class subarraySumClosest {
	public ArrayList<Integer> subarraySumClosest(int[] nums) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        //corner case
        if(nums == null || nums.length == 0){
            return res;
        }
        int sum = 0;
        int length = nums.length;
        SumNum[] sumArray = new SumNum[length];
        for(int i=0;i<length;i++){
            sum += nums[i];
            SumNum cur = new SumNum(i,sum);
            sumArray[i] = cur;
        }
        Comparator<SumNum> comparator = new Comparator<SumNum>(){
            public int compare(SumNum s1,SumNum s2){
                return s1.getNum()-s2.getNum();
            }
        };
        Arrays.sort(sumArray,comparator);
        int min = Math.abs(sumArray[0].getNum());
        int first = 0;
        int last = 0;
        for(int i=1;i<length;i++){
            if(Math.abs(sumArray[i].getNum()) < min){
                min = Math.abs(sumArray[i].getNum());
                first = 0;
                last = sumArray[i].getIndex();
            }
            if(Math.abs(sumArray[i].getNum()-sumArray[i-1].getNum()) < min){
                min = Math.abs(sumArray[i].getNum()-sumArray[i-1].getNum());
                first = Math.min(sumArray[i-1].getIndex(),sumArray[i].getIndex())+1;
                last = Math.max(sumArray[i-1].getIndex(),sumArray[i].getIndex());
            }
        }
        res.add(first);
        res.add(last);
        return res;
	}
}
