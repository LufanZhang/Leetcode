package math;

public class GreatestDivisor {
	static int gcd(int a, int b)
	{
	  if(a == 0 || b == 0) return a+b; // base case
	  return gcd(b,a%b);
	}
}
