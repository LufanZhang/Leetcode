package array;
/*
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.

Note:
You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.
 */
public class MergeSortedArray {
	   public void merge(int A[], int m, int B[], int n) {
	        int indexA = m-1;
	        int indexB = n-1;
	        int index = m+n-1;
	        while(indexB>=0&&indexA>=0){
	            if(B[indexB]>=A[indexA]){
	                A[index] = B[indexB];
	                indexB--;
	            }
	            else{
	                A[index] = A[indexA];
	                indexA--;
	            }
	            index--;
	        }
	        while(indexB>=0){
	            A[index] = B[indexB];
	            index--;
	            indexB--;
	        }
	    }
}
