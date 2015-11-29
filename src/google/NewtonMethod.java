package google;

public class NewtonMethod {
	
//	public static double sqrt(double x, double epsilon) {
//		double t = x;
//		while (t > (x + epsilon) / t) {
//			t = 0.5 * (t + x / t);
//		}
//		
//		return t;
//	}
	public static double sqrt(double x, double epsilon) {
		double start = 0.0;
		double end = x;
		double mid = 0.0;
		double res = Math.sqrt(x);
		System.out.println(res);
		while(start < end){
			 mid = start + (end-start) / 2;
			if((end - start) / 2 < epsilon){
				break;
			}
			if(mid == x / mid){
				return mid;
			}
			else if(mid < x / mid){
				start = mid;
			}
			else{
				end = mid;
			}
		}
		return mid;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1.4142135623746899
		System.out.println(sqrt(2, 0.00000000001));
	}

}