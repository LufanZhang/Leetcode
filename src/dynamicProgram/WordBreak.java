package dynamicProgram;

import java.util.Set;

/*
 *  Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

 For example, given
 s = "leetcode",
 dict = ["leet", "code"].

 Return true because "leetcode" can be segmented as "leet code". 
 */
public class WordBreak {
	public boolean wordBreak(String s, Set<String> dict) {
		int length = s.length();
		if (s == null || length == 0)
			return true;
		boolean[] res = new boolean[length];
		for (int i = length - 1; i >= 0; i--) {
			if (dict.contains(s.substring(i))) {
				res[i] = true;
				continue;
			}
			for (int j = i + 1; j < length; j++) {
				if (res[j] == true && dict.contains(s.substring(i, j))) {
					res[i] = true;
					break;
				}
			}
		}
		return res[0];
	}
}
