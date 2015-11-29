package string;

public class CompareVersionNumbers {
	
	 public static int compareVersion(String version1, String version2) {
		 String[] v1 = version1.split("\\.");
		    String[] v2 = version2.split("\\.");
		    System.out.println("length = "+v1.length);
		    for ( int i = 0; i < Math.max(v1.length, v2.length); i++ ) {
		        int num1 = i < v1.length ? Integer.parseInt( v1[i] ) : 0;
		        int num2 = i < v2.length ? Integer.parseInt( v2[i] ) : 0;
		        if ( num1 < num2 ) {
		            return -1;
		        } else if ( num1 > num2 ) {
		            return +1;
		        }
		    } 
		    
		    return 0;
	    }
	 public static void main(String args[]){
		 String s1 = "1";
		 String s2 = "2";
		 int res = compareVersion(s1,s2);
		 System.out.println("res = "+res);
	 }
}
