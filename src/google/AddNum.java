package google;

public class AddNum {
	public static int NumbersToAdd(int[] elements, int last)
	{
		int size = elements.length;
		int addedNums = 0;
		int cum_sum = 0;
		int i = 0;
		while(i<size || cum_sum < last)
		{
			System.out.println("i="+i+"  cum_sum="+cum_sum);
			if(i>=size || elements[i] > cum_sum + 1)
			{
				addedNums++;
				int number_added = cum_sum + 1;
				cum_sum += number_added ;
			}
			else
			{
				cum_sum += elements[i];
				i++;
			}
		}
		
		return addedNums;
	}
	public static void main(String args[]){
		int[] element = {1,3};
		int last = 6;
		int res = NumbersToAdd(element,last);
		System.out.println("res="+res);
	}
}
