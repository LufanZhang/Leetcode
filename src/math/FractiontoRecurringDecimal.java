package math;

import java.util.HashMap;

public class FractiontoRecurringDecimal {
//	public static String fractionToDecimal(int numerator, int denominator) {
//		StringBuilder sb = new StringBuilder();
//        if(denominator == 0){
//            return sb.toString();
//        }
//        if((numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0)){
//            sb.append('-');
//        }
//        long numer = Math.abs((long)numerator);
//        long deno = Math.abs((long)denominator);
//        sb.append(numer / deno);
//        long remainder = numer % deno * 10;
//        if(remainder != 0){
//            sb.append('.');
//        }
//        HashMap<Long,Integer> map = new HashMap<Long,Integer>();
//        while(remainder != 0){
//           if(map.containsKey(remainder)){
//               int pos = map.get(remainder);
//               sb.insert(pos,'(');
//               sb.append(')');
//               break;
//           }
//           else{
//                map.put(remainder,sb.length());
//                sb.append(remainder / deno);
//                remainder = 10 * (remainder % deno);
//           }
//        }
//        return sb.toString();
//    }
	 public static String fractionToDecimal(int numerator, int denominator) {
	        if(denominator == 0){
	            return null;
	        }
	        if(numerator == 0){
	            return "0";
	        }
	        boolean sign = true; // positive
	        if((numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0)){
	            sign = false;
	        }
	        long num = Math.abs((long)numerator);
	        long den = Math.abs((long)denominator);
	        String first = String.valueOf(num / den);
	        if(sign == false){
	            first = '-' + first;
	        }
	        long reminder = num % den;
	        if(reminder == 0){
	            return first;
	        }
	        HashMap<Long,Integer> map = new HashMap<Long,Integer>();
	        int index = 0;
	        StringBuilder sb = new StringBuilder();
	        System.out.println("reminder = "+reminder);
            System.out.println("den = "+den);
	        while(reminder != 0){
	            if(map.containsKey(reminder)){
	                int pos = map.get(reminder);
	                sb.insert(pos,'(');
	                sb.append(')');
	                break;
	            }
	            map.put(reminder,index);
	            index++;
	            reminder *= 10;
//	            System.out.println("reminder = "+reminder);
//	            System.out.println("den = "+den);
	            sb.append((reminder / den));
	            reminder = reminder % den;
	        }
	        return first+'.'+sb.toString();
	    }
	public static void main(String args[]){
		int numer = -1;
		int deno = -2147483648;
		deno = Math.abs(deno);
		//String res = fractionToDecimal(numer,deno);
		System.out.println(deno);
	}
}
