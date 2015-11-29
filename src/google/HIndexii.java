package google;

public class HIndexii {
	 public static int hIndex(int[] citations) {
	        if(citations == null || citations.length == 0){
	            return 0;
	        }
	        int start = 0;
	        int length = citations.length;
	        int end = length - 1;
	        while(start < end - 1){
	        	//System.out.println("start="+start+" end="+end);
	            int mid = start + (end - start) / 2;
	            int cur = citations[mid];
	            int number = length - mid;
	            System.out.println("cur="+cur+" number="+number);
	            if(cur <= number){
	                start = mid;
	            }
	            else{
	                end = mid;
	            }
	            System.out.println("start="+start+" end="+end);
	        }
	        return Math.max(Math.min(length - end,citations[end]),Math.min(length-start,citations[start]));
	    }
	 public static void main(String args[]){
		 int[] citations = {1,1,1,1,3,3,4,4,5,6,7,7,8,9,10};
		 int res = hIndex(citations);
		 System.out.println("res="+res);
	 }
}
