package math;

public class FactorialTrailingZeroes {
	//计算包含的2和5组成的pair的个数就可以了，一开始想错了，还算了包含的10的个数。  
    //因为5的个数比2少，所以2和5组成的pair的个数由5的个数决定。  
    //观察15! = 有3个5(来自其中的5, 10, 15)， 所以计算n/5就可以。  
    //但是25! = 有6个5(有5个5来自其中的5, 10, 15, 20, 25， 另外还有1个5来自25=(5*5)的另外一个5），  
    //所以除了计算n/5， 还要计算n/5/5, n/5/5/5, n/5/5/5/5, ..., n/5/5/5,,,/5直到商为0。
	/*
	 * 比如 n = 126
	 *  n / 5 =25,也就是说有25个数包含一个5(5,10,15,20,25,30.........110,115,120,125); 
	 *  此时 res = n / 5;
	 *  这里面其中(25,50,75,100,125)是包含两个因子5的，因为这些数是25的倍数，也就是说有多包含了一个5，所以n/25是这些数的个数
	 *  那么总数res += n/(5*5);
	 *  然后看是否有包含3个5的因子,这里125是 res += n / (5*5*5);
	 *  以下程序就是上面语句的改编
	 */
//	public int trailingZeroes(int n) {
//        int count = 0;
//        while( n > 0){
//            int k = n / 5;
//            count += k;
//            n = k;
//        }
//        return  count;
//    }
	 public static int trailingZeroes(int n) {
	       int factor = 5;
	       int res = 0;
	       while(n >= factor){
	    	   System.out.println("n = "+ n);
	           res += n / factor;
	           System.out.println("res = "+res);
	           n = res;
	       }
	       return res;
	    }
	 public static void main(String args[]){
		 int n = 30;
		 int res = trailingZeroes(n);
		 System.out.println(res);
	 }
    
}
