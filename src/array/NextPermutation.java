package array;
/*
 *  Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
 */
public class NextPermutation {
    public void nextPermutation(int[] num) {
        int length = num.length;
        if(num==null||length<=1)
        return;
        int index = -1;
        for(int i=length-2;i>=0;i--){
            if(num[i]<num[i+1]){
                index = i;
                break;
            }
        }
        if(index>=0){
            for(int i=length-1;i>=index+1;i--){
                if(num[i]>num[index]){
                    swap(num,i,index);
                    break;
                }
            }
        }
        reverse(num,index+1,length-1);
      }
      public void swap(int[] num,int i,int j){
          int temp = num[i];
          num[i] = num[j];
          num[j] = temp;
      }
      public void reverse(int[] num,int i,int j){
          while(i<j){
              swap(num,i,j);
              i++;
              j--;
          }
      }
}
