package string;
/*
 *  Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

Below is one possible representation of s1 = "great":

    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t

To scramble the string, we may choose any non-leaf node and swap its two children.

For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t

We say that "rgeat" is a scrambled string of "great".

Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a

We say that "rgtae" is a scrambled string of "great".

Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1. 
 */
public class ScrambleString {
	//this problem is involved with recursion, because for example great can be devide into gr and eat
	//and rg is scramble of gr, tea is scramble of eat. that is great can be devide two part, this two part //can also be scramble.
	//using DP,DP[i][j][h]represent if the (substring of s1 which start from i and length=h)and(substring of//s2 which start from j and length=h)are scramble with each other(left==left&&right==right)||(left//==right&&right==left)
	//the result we want is DP[0][0][length] which represent whether the whole s1 and whole s2 are scramble
	   public boolean isScramble(String s1, String s2) {
	        int length1 = s1.length();
	        int length2 = s2.length();
	        if(s1==null&&s2==null)
	        	return true;
	        if(length1!=length2)
	        	return false;
	        boolean[][][] DP = new boolean[length1][length1][length1];
	        //initial the first level
	        for(int i=0;i<length1;i++){
	        	for(int j=0;j<length1;j++){
	        		if(s1.charAt(i)==s2.charAt(j))
	        			DP[i][j][0] = true;
	        		else
	        			DP[i][j][0] = false;
	        	}
	        }
	        
	        for(int h=1;h<length1;h++){
	        	for(int i=0;i<=length1-1-h;i++){
	        		for(int j=0;j<=length1-1-h;j++){
	        			for(int m=0;m<h;m++){
	        				if((DP[i][j][m]&&DP[i+1+m][j+1+m][h-m-1])||(DP[i][j+h-m][m]&&DP[i+1+m][j][h-m-1]))
	        					DP[i][j][h] = true;
	        			}
	        		}
	        	}
	        }
	        return DP[0][0][length1-1];
	    }
}
