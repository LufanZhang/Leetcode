package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleII {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        int[] preNum = new int[numCourses];
        Queue<Integer> freeCourse = new LinkedList<Integer>();
        int index = 0;
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>(); // the key means pre
        for(int i=0;i<prerequisites.length;i++){
            int pre = prerequisites[i][1];
            int cur = prerequisites[i][0];
            if(map.containsKey(pre)){
                map.get(pre).add(cur);
            }
            else{
                ArrayList<Integer> curList = new ArrayList<Integer>();
                curList.add(cur);
                map.put(pre,curList);
            }
            preNum[cur] = preNum[cur] + 1;
        }
        for(int i=0;i<numCourses;i++){
            if(preNum[i] == 0){
                freeCourse.offer(i);
            }
        }
        while(!freeCourse.isEmpty()){
            int canBeTook = freeCourse.poll();
            res[index] = canBeTook;
            index++;
            if(map.containsKey(canBeTook)){
                for(int free:map.get(canBeTook)){
                    preNum[free] = preNum[free] - 1;
                    if(preNum[free] == 0){
                        freeCourse.offer(free);
                    }
                }
            }
        }
        if(index < numCourses){
            return new int[0];
        }
        return res;
    }
//	 public int[] findOrder(int numCourses, int[][] prerequisites) {
//	        if(numCourses < 0){
//	            return null;
//	        }
//	        int[] res = new int[numCourses];
//	        int index = 0;
//	        HashMap<Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();
//	        int[] preNum = new int[numCourses];
//	        HashSet<Integer> set = new HashSet<Integer>();
//	        int length = prerequisites.length;
//	        for(int i=0;i<length;i++){
//	            int pre = prerequisites[i][1];
//	            int post = prerequisites[i][0];
//	            preNum[post]++;
//	            set.add(post);
//	            if(map.containsKey(pre)){
//	                ArrayList<Integer> list = map.get(pre);
//	                list.add(post);
//	            }
//	            else{
//	                ArrayList<Integer> list = new ArrayList<Integer>();
//	                list.add(post);
//	                map.put(pre,list);
//	            }
//	        }
//	        Queue<Integer> queue = new LinkedList<Integer>();
//	        for(int i=0;i<numCourses;i++){
//	            if(!set.contains(i)){
//	                queue.offer(i);
//	            }
//	        }
//	        while(!queue.isEmpty()){
//	            int pre = queue.poll();
//	            res[index] = pre;
//	            index++;
//	            if(map.containsKey(pre)){
//	                ArrayList<Integer> list = map.get(pre);
//	                    for(int j=0;j<list.size();j++){
//	                        preNum[list.get(j)]--;
//	                        if(preNum[list.get(j)] == 0){
//	                            queue.offer(list.get(j));
//	                        }
//	                    }
//	            }
//	        }
//	        if(index < numCourses-1){
//	            return new int[0];
//	        }
//	        return res;
//	    }
}
