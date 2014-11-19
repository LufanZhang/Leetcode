package math;
/*
 * Implement int sqrt(int x).

Compute and return the square root of x.
 */
public class Sqrt_x {
    public int sqrt(int x) {
    if(x<0)
    return 0;
    long low = 0;
    long high = x / 2 + 1;
    while (low + 1 < high){
        long mid = low + (high - low) / 2;
        if (mid * mid == x){
            return (int)mid;
        } else if (mid * mid < x){
            low = mid;
        } else {
            high = mid;
        }
    }
    if(high * high <= x){
        return (int)high;
    } 
    return (int)low;
    }
}
