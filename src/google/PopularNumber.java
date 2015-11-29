package google;
//在一个sorted array中找到出现次数大于1/4
public class PopularNumber {
	public static int findPopular(int[] array){
		if(array == null || array.length == 0){
			return 0;
		}
		int length = array.length;
		if(length < 4){
			return array[0];
		}
		int step = length / 4 + 1;
		int index = -1 + step;
		while(index < length){
			int cur = array[index];
			int left = binarySearchLeft(array,Math.max(0,index - step),index,cur);
			int right = binarySearchRight(array,index,Math.min(length-1,index + step),cur);
			if(right - left + 1 >= step){
				return cur;
			}
			index += step;
		}
		return 0;
	}
	public static int binarySearchLeft(int[] array,int left,int right,int target){
		if(left == right){
			return left;
		}
		while(left < right - 1){
			int mid = left + (right - left) / 2;
			if(array[mid] == target){
				right = mid;
			}
			else{
				left = mid;
			}
		}
		if(array[left] == target){
			return left;
		}
		return right;
	}
	public static int binarySearchRight(int[] array,int left,int right,int target){
		if(left == right){
			return left;
		}
		while(left < right - 1){
			int mid = left + (right - left) / 2;
			if(array[mid] == target){
				left = mid;
			}
			else{
				right = mid;
			}
		}
		if(array[right] == target){
			return right;
		}
		return left;
	}
	public static void main(String args[]){
		int[] array = {2,2,2,3,3,3,4,4,4};
		int res = findPopular(array);
		System.out.println("res="+res);
	}
}
