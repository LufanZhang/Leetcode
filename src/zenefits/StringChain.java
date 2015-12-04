package zenefits;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class StringChain {
//	static int res = 0;
//	public static int findLongestChain(String[] stringArray){
//		if(stringArray == null || stringArray.length == 0){
//			return 0;
//		}
//		int length = stringArray.length;
//		HashMap<Integer,HashSet<String>> stringMap = new HashMap<Integer,HashSet<String>>();
//		for(int i=0;i<length;i++){
//			String cur = stringArray[i];
//			int curLength = cur.length();
//			if(stringMap.containsKey(curLength)){
//				stringMap.get(curLength).add(cur);
//			}
//			else{
//				HashSet<String> curSet = new HashSet<String>();
//				curSet.add(cur);
//				stringMap.put(curLength,curSet);
//			}
//		}
//		HashMap<String,Integer> stringChain = new HashMap<String,Integer>();
//		for(int i=0;i<length;i++){
//			String curString = stringArray[i];
//			int chainLength = fingChainHelper(curString,stringMap,stringChain);
//			if(chainLength > res){
//				res = chainLength;
//			}
//		}
//		System.out.println("stringMap="+stringMap);
//		System.out.println("stringChain="+stringChain);
//		return res;
//	}
//	public static int fingChainHelper(String s,HashMap<Integer,HashSet<String>> stringMap,HashMap<String,Integer> stringChain){
//		if(s == null || s.length() == 0){
//			return 0;
//		}
//		if(stringChain.containsKey(s)){
//			return stringChain.get(s);
//		}
//		int length = s.length();
//		if(!stringMap.containsKey(length) || !stringMap.get(length).contains(s)){
//			return 0;
//		}
//		int max = 1;
//		for(int i=0;i<length;i++){
//			String childString = s.substring(0,i)+s.substring(i+1);
//			int childLength = fingChainHelper(childString,stringMap,stringChain);
//			if(childLength + 1 > max){
//				max = childLength+1;
//			}
//		}
//		stringChain.put(s, max);
//		return max;
//	}
	public static int findChain(String[] stringArray){
		if(stringArray == null || stringArray.length == 0){
			return 0;
		}
		int length = stringArray.length;
		int maxLength = 0;
		int res = 0;
		HashSet<String> set = new HashSet<String>();
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		for(int i=0;i<length;i++){
			String cur = stringArray[i];
			int curLength = cur.length();
			if(curLength > maxLength){
				maxLength = curLength;
			}
			set.add(cur);
		}
		for(int i=0;i<length;i++){
			String cur = stringArray[i];
			int chainLength = findHelper(set,cur,map);
			if(chainLength > res){
				res = chainLength;
			}
			if(res == maxLength){
				break;
			}
		}
		return res;
	}
	public static int findHelper(HashSet<String> set,String s,HashMap<String,Integer> map){
		if(s == null || s.length() == 0 || !set.contains(s)){
			return 0;
		}
		if(map.containsKey(s)){
			return map.get(s);
		}
		int count = 1;
		int length = s.length();
		for(int i=0;i<length;i++){
			String childString = s.substring(0,i)+s.substring(i+1);
			int childChain = findHelper(set,childString,map);
			if(1+childChain > count){
				count = 1+childChain;
			}
		}
		map.put(s, count);
		return count;
	}
	public static void main(String args[]){
//		String[] stringArray = {"a","ba","abcde","bca","bda","bdca"};
//		int res = findLongestChain(stringArray);
//		System.out.println("res="+res);
		Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] dict = new String[n];
        for (int i = 0; i < n; i++) {
            dict[i] = scanner.next();
        }
        int result = findChain(dict);
        System.out.println(result);
        scanner.close();
	}
//	 public static int findChain(String[] w){
//         HashMap<Integer,HashSet<String>> hm = new HashMap<Integer,HashSet<String>>();
//         int maxlen = 0;
//         int minlen = Integer.MAX_VALUE;
//         for(String s:w){
//                 int len=s.length();
//                 maxlen = Math.max(maxlen,len);
//                 minlen = Math.min(minlen, len);
//                 if(hm.containsKey(len)){
//                         hm.get(len).add(s);
//                 } else {
//                         HashSet<String> hs = new HashSet<String>();
//                         hs.add(s);
//                         hm.put(len, hs);
//                 }
//         }
//         int max = 0;
//         int p=maxlen;
//         HashSet<String> visit = new HashSet<String>();
//         while(p>=minlen){
//                 HashSet<String> hs = hm.get(p);
//                 if(!hs.isEmpty()){
//                         for(String s:hs){
//                                 max = Math.max(max, helper(hm,s,visit));
//                         }
//                 }
//                 p--;
//         }
//         return max;
// }
// private static int helper(HashMap<Integer,HashSet<String>> hm, String s, HashSet<String> visit){
//         visit.add(s);
//         int next = s.length()-1;
//         if( next==0 || !hm.containsKey(next) || hm.get(next).isEmpty()) return 1;
//         HashSet<String> hs = hm.get(next);
//         int max=0;
//         for(int i=0;i<s.length();i++){
//               StringBuffer sb = new StringBuffer(s);
//               String nextstr=sb.deleteCharAt(i).toString();
//               if(hs.contains(nextstr) && !visit.contains(nextstr)){
//                        max = Math.max(max,helper(hm,nextstr,visit));
//                }
//         }
//         return max+1;
// }
// public static void main(String args[]){
//	 String[] stringArray = {"ba","abcde","bca","bda","bdca"};
//		int res = findChain(stringArray);
//		System.out.println("res="+res);
// }
}
