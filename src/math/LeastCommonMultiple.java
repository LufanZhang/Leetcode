package math;

public class LeastCommonMultiple {
	public int lcm(int a,int b){
		return a * b / gcd(a,b);
	}
	public int gcd(int a,int b){
		if(a == 0 || b == 0){
			return a + b;
		}
		return gcd(b,a % b);
	}
}
