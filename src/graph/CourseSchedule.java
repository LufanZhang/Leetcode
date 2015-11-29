package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {
	public static boolean canFinish(int numCourses, int[][] prerequisites) {
        //topological sort
        //corner case
        if(prerequisites == null || prerequisites.length == 0){
            return true;
        }
        int length = prerequisites.length;
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();
        int[] preNum = new int[numCourses];
        for(int i=0;i<length;i++){
            int pre = prerequisites[i][0];
            int cur = prerequisites[i][1];
            if(map.containsKey(pre)){
                ArrayList<Integer> list = map.get(pre);
                list.add(cur);
            }
            else{
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(cur);
                map.put(pre,list);
            }
            preNum[cur]++;
        }
        int count = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i=0;i<numCourses;i++){
            if(preNum[i] == 0){
                queue.offer(i);
                count++;
            }
        }
        System.out.println(map);
        System.out.println("count = "+count);
        while(!queue.isEmpty()){
            int parent = queue.poll();
            if(map.containsKey(parent)){
                ArrayList<Integer> list = map.get(parent);
                for(int i=0;i<list.size();i++){
                    preNum[list.get(i)]--;
                    if(preNum[list.get(i)] == 0){
                        queue.offer(list.get(i));
                        System.out.println("offer = "+i);
                        count++;
                    }
                }
            }
        }
        //System.out.println("count = "+count);
        if(count == numCourses){
            return true;
        }
        return false;
    }
	public static void main(String args[]){
		int numCourses = 3;
		int[][] prerequisites = {{1,0},{2,1}};
		boolean res = canFinish(numCourses,prerequisites);
		System.out.println(res);
	}
}
