package string;
/*
 *  Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the". 
 */
public class ReverseWordsinaString {
	 public String reverseWords(String s) {
	        if(s==null||s.length()==0)
	        return "";
	        String[] array = s.split(" ");
	        String res = "";
	        for(int i=array.length-1;i>=0;i--){
	            if(!array[i].equals(""))
	            res+=array[i]+" ";
	        }
	        if(res.length()<=0)
	        return "";
	        return res.substring(0,res.length()-1);
	    }
	 public static void main(String args[]){
		 String s = "a    e  r";
		 String[] array = s.split(" ");
		// System.out.println(array.length);
		 for(int i=0;i<array.length;i++){
			 System.out.println("cur = "+array[i]);
		 }
	 }
}
