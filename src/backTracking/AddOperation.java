package backTracking;

public class AddOperation {
	public static String addOperation(String s,int target){
		if(s == null || s.length() == 0){
			return "";
		}
		int length = s.length();
		int[] nums = new int[length];
		for(int i=0;i<length;i++){
			int cur = s.charAt(i) - '0';
			nums[i] = cur;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(nums[0]);
		boolean flag = dfsHelper(nums,0,nums[0],1,target,sb,true);
		if(flag){
			return sb.toString();
		}
		return "";
	}
	public static boolean dfsHelper(int[] nums,long first,long second,int pos,int target,StringBuilder sb,boolean isPlus){
		if((isPlus &&first + second == target && pos == nums.length) || (!isPlus && first - second == target && pos == nums.length)){
			return true;
		}
		if(pos == nums.length){
			return false;
		}
		/*****************************当前插入符号‘+’*****************************/
		sb.append('+');
		sb.append(nums[pos]);
		if(isPlus){
			if(dfsHelper(nums,first+second,nums[pos],pos+1,target,sb,true)){
				return true;
			}
		}
		else{
			if(dfsHelper(nums,first-second,nums[pos],pos+1,target,sb,true)){
				return true;
			}
		}
		sb.deleteCharAt(sb.length()-1);
		sb.deleteCharAt(sb.length()-1);
		/************************************************************************/
		/*****************************当前插入符号‘-’*****************************/
		sb.append('-');
		sb.append(nums[pos]);
		if(isPlus){
			if(dfsHelper(nums,first+second,nums[pos],pos+1,target,sb,false)){
				return true;
			}
		}
		else{
			if(dfsHelper(nums,first-second,nums[pos],pos+1,target,sb,false)){
				return true;
			}
		}
		sb.deleteCharAt(sb.length()-1);
		sb.deleteCharAt(sb.length()-1);
		/************************************************************************/
		/*****************************当前插入符号‘*’*****************************/
		sb.append('*');
		sb.append(nums[pos]);
		if(dfsHelper(nums,first,second*nums[pos],pos+1,target,sb,isPlus)){
			return true;
		}
		sb.deleteCharAt(sb.length()-1);
		sb.deleteCharAt(sb.length()-1);
		/************************************************************************/
		/*****************************当前插入符号‘/’*****************************/
		if(nums[pos] != 0){ 			//如果当前的数是0，则不能当做除数
			sb.append('/');
			sb.append(nums[pos]);
			if(dfsHelper(nums,first,second/nums[pos],pos+1,target,sb,isPlus)){
				return true;
			}
			sb.deleteCharAt(sb.length()-1);
			sb.deleteCharAt(sb.length()-1);
		}
		/*****************************当前插入符号‘+’*****************************/
		return false;
	}
	public static void main(String args[]){
		String s = "2342";
		int target = 4;
		String res = addOperation(s,target);
		System.out.println("res="+res);
	}
}
