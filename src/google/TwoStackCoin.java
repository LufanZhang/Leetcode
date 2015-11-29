package google;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TwoStackCoin {
//	public static int findMaxSum(Stack<Integer> stack1,Stack<Integer> stack2,int n){
//		if(n == 0 || (stack1.isEmpty() && stack2.isEmpty())){
//			return 0;
//		}
//		int res = 0;
//		if(!stack1.isEmpty()){
//			int temp = stack1.pop();
//			int sum = temp + findMaxSum(stack1,stack2,n-1);
//			if(res < sum){
//				res = sum;
//			}
//			stack1.push(temp);
//		}
//		if(!stack2.isEmpty()){
//			int temp = stack2.pop();
//			int sum = temp + findMaxSum(stack1,stack2,n-1);
//			if(res < sum){
//				res = sum;
//			}
//			stack2.push(temp);
//		}
//		return res;
//	}
//	public static int findMaxSum(Stack<Integer> stack1,Stack<Integer> stack2,int k){
//		if(k == 0 || (stack1.isEmpty() && stack2.isEmpty())){
//			return 0;
//		}
//		int m = stack1.size();
//		int n = stack2.size();
//		int[] nums1 = new int[m+1];
//		int[] nums2 = new int[n+1];
//		for(int i=1;i<=m;i++){
//			nums1[i] = stack1.pop();
//		}
//		for(int i=1;i<=n;i++){
//			nums2[i] = stack2.pop();
//		}
//		int[][] res = new int[m+1][n+1];
//		res[0][0] = 0;
//		for(int i=1;i<=n;i++){
//			res[0][i] = nums2[i] + res[0][i-1];
//		}
//		for(int i=1;i<=m;i++){
//			res[i][0] = nums1[i] + res[i-1][0];
//		}
//		for(int i=1;i<=m;i++){
//			for(int j=1;j<=n;j++){
//				res[i][j] = res[i][j-1] + nums2[j];
//			}
//		}
//		int x = 0;
//		int y = 0;
//		if(k > n){
//			x = k - n;
//			y = n;
//		}
//		else{
//			y = k;
//		}
//		int max = Integer.MIN_VALUE;
//		while(x <= m && y >= 0){
//			if(res[x][y] > max){
//				max = res[x][y];
//			}
//			x++;
//			y--;
//		}
//		return max;
//	}
	public static int findMaxSum(List<Stack<Integer>> stacks,int n){
		if(n == 0){
			return 0;
		}
		int length = stacks.size();
		int res = Integer.MIN_VALUE;
		for(int i=0;i<length;i++){
			Stack<Integer> cur = stacks.get(i);
			if(!cur.isEmpty()){
				int temp = cur.pop();
				int sum = temp + findMaxSum(stacks,n-1);
				if(sum > res){
					res = sum;
				}
				cur.push(temp);
			}
		}
		return res;
	}
	public static void main(String args[]){
		Stack<Integer> stack1 = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();
		Stack<Integer> stack3 = new Stack<Integer>();
		stack1.push(3);
		stack1.push(200);
		stack1.push(4);
		stack1.push(1);
		stack2.push(6);
		stack2.push(10);
		stack2.push(5);
		stack3.push(300);
		List<Stack<Integer>> stacks = new ArrayList<Stack<Integer>>();
		stacks.add(stack1);
		stacks.add(stack2);
		stacks.add(stack3);
		int res = findMaxSum(stacks,4);
		System.out.println("res="+res);
	}
}
