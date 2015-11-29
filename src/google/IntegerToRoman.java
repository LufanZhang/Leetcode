package google;

public class IntegerToRoman {
	 public String intToRoman(int num) {
	        int[] values = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
	        String[] romans = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
	        StringBuilder sb = new StringBuilder();
	        if(num <= 0){
	            return sb.toString();
	        }
	        int start = values.length-1;
	        while(start >= 0 && num > 0){
	            if(values[start] > num){
	                start--;
	                continue;
	            }
	            else{
	                sb.append(romans[start]);
	                num -= values[start];
	            }
	        }
	        return sb.toString();
	    }
}
