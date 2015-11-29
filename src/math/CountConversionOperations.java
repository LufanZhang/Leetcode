package math;

public class CountConversionOperations {
	public static int countOperations(int n) {
		if(n == 0 || n == 1){
			return n;
		}
		int half = n / 2;
		int count = 1;
		if((count & 1) == 1){
			count = 2;
		}
		return count + countOperations(half);
	    }
	public static int count(int n) {
		if(n == 0 || n == 1){
			return n;
		}
		int half = n / 2;
		int count = 1;
		if((count & 1) == 1){
			count = 2;
		}
		return count + countOperations(half);
	    }
	public static void main(String args[]){
		for(int i=0;i<=Integer.MAX_VALUE;i++){
			int res = countOperations(i);
			int r = count(i);
			if(res != r){
				System.out.println(i);
			}
			else{
				System.out.println("true----->"+i);
			}
		}
	}
}
