package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

//拓扑排序
//表明当遍历到这一点时，能保证 所有指向这一点的也就是它的父节点 都已经被遍历过

public class TopologicalSorting {
	 public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
	        // write your code here
	        ArrayList<DirectedGraphNode> res = new ArrayList<DirectedGraphNode>();
	        //use a hashmap to record each node and its parent node numers as its value
	        //when its parent's number is 0, means this node has no pre condition and 
	        //it can be traverse currently
	        HashMap<DirectedGraphNode,Integer> map = new HashMap<DirectedGraphNode,Integer>();
	        //把有parent的点全都放到map里，value是说这个node有几个parent，那么不在map里却在gragh里的就是可以作为起始点的node
	        for(DirectedGraphNode node:graph){
	            for(DirectedGraphNode neighbor:node.neighbors){
	                if(map.containsKey(neighbor)){
	                    map.put(neighbor,1+map.get(neighbor));
	                }
	                else{
	                    map.put(neighbor,1);
	                }
	            }
	        }
	        //queue里面的点是可以消灭的
	        Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
	        //找出起始点并把它们放到res里
	        for(DirectedGraphNode node:graph){
	            if(!map.containsKey(node)){
	                res.add(node);
	                queue.add(node);
	            }
	        }
	        while(!queue.isEmpty()){
	            DirectedGraphNode cur = queue.poll();
	            for(DirectedGraphNode neighbor:cur.neighbors){
	                map.put(neighbor,map.get(neighbor)-1);
	                if(map.get(neighbor) == 0){
	                    res.add(neighbor);
	                    queue.offer(neighbor);
	                }
	            }
	        }
	        return res;
	    }
}
