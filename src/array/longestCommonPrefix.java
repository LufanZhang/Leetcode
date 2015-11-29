package array;

public class longestCommonPrefix {
	public static String longestCommonPrefix(String[] strs) {
        // write your code here
        if(strs == null || strs.length == 0){
            return null;
        }
        StringBuilder prefix = new StringBuilder();
        prefix.append(strs[0]);
        for(int i=0;i<strs.length;i++){
            if(strs[i] == null){
                return null;
            }
            for(int j=0;j<prefix.length();j++){
                if(j>=strs[i].length() || strs[i].charAt(j) != prefix.charAt(j)){
                    prefix.delete(j,prefix.length());
                    break;
                }
            }
        }
        return prefix.toString();
    }
	public static void main(String[] args){
		String[] strs = {"ABCD","ABEF","ACEF"};
		String res = longestCommonPrefix(strs);
		System.out.println("Result = "+res);
	}
}
