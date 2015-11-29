package bitManipulation;
/*
 * Given two 32-bit numbers, N and M, and two bit positions, i and j. Write a method to set all bits between i and j in N equal to M (e g , M becomes a substring of N located at i and starting at j)
 * Given N=(10000000000)2, M=(10101)2, i=2, j=6

	return N=(10001010100)2
 */
/*
 * 要把n的其中一段变成m
 * 思路就是把n的这一段变成0000...,然后在用这一段 + m
 */
public class UpdateBits {
	public int updateBits(int n, int m, int i, int j) {
        // write your code here
        int mask;
        if (j < 31) {
            mask = ~((1 << (j + 1)) - (1 << i));
        } else {
            mask = (1 << i) - 1;
        }
        return (m << i) + (mask & n);
    }
}
