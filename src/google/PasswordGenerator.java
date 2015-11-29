package google;

import java.util.HashSet;

//generate一个字符串，这个string包含n位密码的全部形式
public class PasswordGenerator {
	public static String generator(int n){
		if(n <= 0){
			return "";
		}
		String res = "";
		int index = 0;
		for(int i=1;i<n;i++){
			res = res + "9";
			index++;
		}
		int sum = 1;
		for(int i=0;i<n;i++){
			sum *= 10;
		}
		System.out.println("sum="+sum);
		HashSet<String> set = new HashSet<String>();
		int count = 0;
		while(set.size() < sum){
			StringBuilder temp = new StringBuilder();
			if(index-n+1 <= 18){
				System.out.println("index-n+1="+(index-n+1));
				System.out.println("set.size()="+set.size());
				System.out.println("res="+res);
				//System.out.println("temp="+res.substring(index-n+1));
			}
			temp.append(res.substring(index-n+1));
			for(int i=0;i<=9;i++){
				temp.append(i);
				//System.out.println("temp="+temp.toString());
				if(!set.contains(temp.toString())){
					System.out.println("temp="+temp.toString());
					res = res + String.valueOf(i);
					set.add(temp.toString());
					count++;
					index++;
					break;
				}
				temp.deleteCharAt(temp.length()-1);
			}
		}
		return res;
	}
	public static void main(String args[]){
		int n = 4;
		String res = generator(n);
		System.out.println("res="+res);
		HashSet<Integer> set = new HashSet<Integer>();
		System.out.println("length="+res.length());
		for (int i = 0; i <= 999; i++) {
			if (!res.contains(String.valueOf(i))) {
				System.out.println("Oops!");
			}
		}
	}
}
