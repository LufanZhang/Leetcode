package array;

public class SortColorsII {
	public void sortColors2(int[] colors, int k) {
        // write your code here
        if(colors == null ||colors.length == 0){
            return;
        }
        int length = colors.length;
        int i=0;
        while(i < length){
            if(colors[i] <= 0){
                i++;
            }
            else{
                int cur = colors[i];
                if(colors[cur-1] <= 0){
                    colors[cur - 1]--;
                    colors[i] = 0;
                }
                else{
                    colors[i] = colors[cur - 1];
                    colors[cur - 1] = -1;
                }
            }
        }
        int index = k-1;
        int m = length - 1;
        while(index >= 0){
            int cur = index+1;
            int num = -colors[index];
            for(int j=0;j<num;j++){
                colors[m] = cur;
                m--;
            }
            index--;
        }
    }
}
