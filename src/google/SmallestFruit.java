package google;

public class SmallestFruit {
	public static int findSmallest(int[] array,int money){
		if(money == 0 || array == null || array.length == 0){
			return 0;
		}
		int length = array.length;
		int[] res = new int[money+1];
		res[0] = 0;
		for(int i=1;i<=money;i++){
			int min = Integer.MAX_VALUE;
			for(int j=0;j<length;j++){
				int cur = array[j];
				if(cur > i){
					continue;
				}
				else{
					if(1+res[i-cur] < min){
						min = 1 + res[i-cur];
						res[i] = min;
					}
				}
			}
			
		}
		return res[money];
	}
	public static void main(String args[]){
		int[] array = {2,5,6};
		int money = 10;
		int res = findSmallest(array,money);
		System.out.println("res="+res);
	}
}
