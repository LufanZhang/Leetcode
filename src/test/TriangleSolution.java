package test;
/*
 * the time complexity is O(n2)-n is the row of the triangle, because I need to read all of the data in triangle.txt
 * the space complexity is O(n)-n is the row of the triangle, I use array to store the data in one level,
 * and the array will be refreshed every level
 */

public class TriangleSolution {
	public static void main(String args[]){
		ReadFile r = new ReadFile();
		r.openFile();
		int count = 1;
		int[] result = new int[100];
		int temp = 0;
		while(r.scan.hasNext()){
			for(int i=0;i<count;i++){
				String s = r.scan.next();
				int cur = Integer.parseInt(s);
				
				if(count == 1){
					result[0] = cur;
				}
				else{
					if(i == 0){
						temp = result[i];
						result[i] += cur;
					}
					else if(i == count - 1){
						result[i] = cur + temp;
					}
					else{
						int t = result[i];
						result[i] = cur + Math.max(temp,result[i]);
						temp = t;
					}
				}
			}
			count++;
		}
		int max = Integer.MIN_VALUE;
		for(int i=0;i<100;i++){
			if(result[i] > max){
				max = result[i];
			}
		}
		r.closeFile();
		System.out.println("maximum total from top to bottom is "+max);
	}
}
