package wayfair;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class KRandomNumber {
	static int res = 0;
	public static int pathNum(int n, int startI, int startJ, int endI,int endJ,int k){
		dfsHelper(n,startI,startJ,endI,endJ,k);
		return res;
	}
	public static void dfsHelper(int n, int i, int j, int endI,int endJ,int k){
		if(i == endI &&  j == endJ && k == 0){
			res++;
			return;
		}
		if(k <= 0 || i < 0 || j < 0 || i >= n || j >= n){
			return;
		}
		dfsHelper(n,i+1,j,endI,endJ,k-1);
		dfsHelper(n,i-1,j,endI,endJ,k-1);
		dfsHelper(n,i,j+1,endI,endJ,k-1);
		dfsHelper(n,i,j-1,endI,endJ,k-1);
	}
	public static void main(String args[]){
		int n = 4;
		int startI = 0;
		int startJ = 0;
		int endI = 0;
		int endJ = 2;
		int k = 4;
		pathNum(n,startI,startJ,endI,endJ,k);
		System.out.println("res="+res);
	}
}
