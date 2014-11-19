package array;
/*
 * Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int length = digits.length;
        if(digits==null||length==0)
        return digits;
        int carry = 1;
        for(int i=length-1;i>=0;i--){
            int cur = digits[i];
            digits[i] = (cur+carry)%10;
            carry = (cur+carry)/10;
        }
        if(carry==0)
        return digits;
        int[] result = new int[length+1];
        result[0] = 1;
        for(int i=1;i<=length;i++){
            result[i] = digits[i-1];
        }
        return result;
    }
}
