package array;
/*
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container. 
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        if(height==null||height.length<=1)
        return 0;
        int i = 0;
        int j = height.length-1;
        int max = 0;
        while(i<j){
            int high = Math.min(height[i],height[j]);
            int width = j-i;
            if(high*width>max)
            max = high*width;
            if(height[i]==high){
                while(i<j){
                    if(height[i]>high)
                    break;
                    i++;
                }
            }
            if(height[j]==high){
                while(i<j){
                    if(height[j]>high)
                    break;
                    j--;
                }
            }
        }
        return max;
    }
}
