package string;
/*
 *  Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Update (2014-11-02):
The signature of the function had been updated to return the index instead of the pointer. If you still see your function signature returns a char * or String, please click the reload button to reset your code definition. 
 */
public class ImplementstrStr {
	 public String strStr(String haystack, String needle) {
	        if(haystack==null||needle==null)
	        return null;
	        int m = haystack.length();
	        int n = needle.length();
	        int i;
	        int j;
	        if(m<n){
	        return null;
	        }
	        for(i=0;i<m-needle.length() + 1;i++){
	            for(j=0;j<n;j++){
	                if(needle.charAt(j)!=haystack.charAt(i+j))
	                break;
	            }
	            if(j==n)
	            return haystack.substring(i);
	        }
	        return null;
	    }
}
