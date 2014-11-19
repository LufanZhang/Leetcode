package array;

import java.util.HashSet;

/*
 *  Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity. 
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] num) {
        int length = num.length;
        if(num==null||length==0)
        return 0;
        int max = 0;
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i=0;i<length;i++){
            set.add(num[i]);
        }
        for(int i=0;i<length;i++){
            if(!set.contains(num[i]))
            continue;
            int result = 1;
            int cur = num[i];
            while(true){
                if(set.contains(--cur)){
                result++;
                set.remove(cur);
                }
                else
                break;
            }
            cur = num[i];
            while(true){
                if(set.contains(++cur)){
                result++;
                set.remove(cur);
                }
                else
                break;
            }
            if(max<result)
            max = result;
        }
        return max;
    }
}
