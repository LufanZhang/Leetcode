package array;
/*
 *  Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem. 
 */
//m和n之间是1，包括m和n
public class SortColors {
    public void sortColors(int[] A) {
        int m = 0;
        int n = A.length-1;
        int runner = 0;
        while(runner<=n){
            if(A[runner]==2){
                swap(A,runner,n);
                n--;
            }
            else if(A[runner]==1){
                runner++;
            }
            else{
                swap(A,runner,m);
                m++;
                runner++;
            }
        }
    }
    public void swap(int[] num, int i,int j){
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}
