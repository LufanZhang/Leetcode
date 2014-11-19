package backTracking;

import java.util.ArrayList;

/*
 *  Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()" 
 */
public class GenerateParentheses {
	public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<String>();
        if(n<=0)
        return result;
        ArrayList<Character> list = new ArrayList<Character>();
        int leftCount = 0;
        int rightCount = 0;
        generateHelper(n,result,list,leftCount,rightCount);
        return result;
        
    }
    public void generateHelper(int n,ArrayList<String> result,ArrayList<Character> list,int leftCount,int rightCount){
        if(leftCount==n){
            String res = "";
            for(int i=0;i<list.size();i++){
                res+=list.get(i);
            }
            for(int i=rightCount;i<n;i++){
                res+=')';
            }
            result.add(res);
            return;
        }
        list.add('(');
        generateHelper(n,result,list,leftCount+1,rightCount);
        list.remove(list.size()-1);
        if(leftCount>rightCount){
            list.add(')');
            generateHelper(n,result,list,leftCount,rightCount+1);
            list.remove(list.size()-1);
        }
    }
}
