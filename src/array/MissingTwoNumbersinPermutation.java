package array;

public class MissingTwoNumbersinPermutation {
	public int[] missing2Numbers(int [] a) {
		int[] res = new int[2];
		if(a == null || a.length == 0){
			return res;
		}
		int length = a.length;
		int first = length+1;
		int second = length+2;
		int index = 0;
		while(index < length){
			int cur = a[index];
			if(index == cur-1 || cur >= length){
				index++;
			}
			else{
				int pos = cur - 1;
				swap(a,index,pos);
				
			}
		}
		for(int i=0;i<length;i++){
			int cur = a[i];
			if(cur != i+1){
				if(first == length+1){
					first = i + 1;
				}
				else{
					second = i + 1;
					break;
				}
			}
		}
		res[0] = first;
		res[1] = second;
		return res;
        }
	 public void swap(int[] num,int i,int j){
     	int temp = num[i];
     	num[i] = num[j];
     	num[j] = temp;
     }
}
