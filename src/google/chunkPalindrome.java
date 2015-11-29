package google;

import java.util.Arrays;

public class chunkPalindrome {
	public static  int chunkNum(String s){
		if(s == null || s.length() == 0){
			return 0;
		}
		int length = s.length();
		int[][] DP = new int[length][length];
		for(int i=0;i<length;i++){
			for(int j=0;j<length;j++){
				DP[i][j] = 1;
			}
		}
		for(int i=length-1;i>=0;i--){
			for(int j=i;j<length;j++){
				if(i == j){
					DP[i][j] = 1;
				}
				else{
					int sum = 1;
					int mid = i + (j-i) / 2;
					for(int count=i;count<=mid;count++){
						String pre = s.substring(i,count+1);
						String post = s.substring(j-count+i,j+1);
						if(pre.equals(post)){
							sum += DP[count+1][j-count+i-1];
						}
					}
					DP[i][j] = sum;
				}
			}
		}
		return DP[0][length-1];
	}
	public static void main(String args[]){
//		String s = "volvolvo";
//		int res = chunkNum(s);
//		System.out.println("res="+res);
//		String test = "/abc/def/h";
//		String[] array = test.split("/");
//		for(int i=0;i<array.length;i++){
//			System.out.print(array[i]+" ");
//		}
		String by = "01001001";
		Byte b = Byte.parseByte(by);
		System.out.println("b="+b);
	}
}
