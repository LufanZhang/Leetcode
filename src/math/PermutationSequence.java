package math;

import java.util.ArrayList;

/*
 * The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

    "123"
    "132"
    "213"
    "231"
    "312"
    "321"

Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.
 */
public class PermutationSequence {
    public String getPermutation(int n, int k) {
        int total = 1;
        for(int i=1;i<=n;i++){
            total*=i;
        }
        String res = "";
        if(k>total||n<1)
        return res;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=1;i<=n;i++){
            list.add(i);
        }
        while(n>=1){
            int section = total/n;
            total = section;
            int i = (k-1)/section;
            k = k-i*section;
            res+=String.valueOf(list.get(i));
            list.remove(i);
            n--;
        }
        return res;
    }
}
