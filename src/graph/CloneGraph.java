package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 *  Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.

OJ's undirected graph serialization:

Nodes are labeled uniquely.
We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.

As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

    First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
    Second node is labeled as 1. Connect node 1 to node 2.
    Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.

Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/

 */
public class CloneGraph {
	//DFS
//	  public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
//	        if(node == null){
//	            return null;
//	        }
//	        HashMap<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
//	        return helper(node,map);
//	    }
//	    public UndirectedGraphNode helper(UndirectedGraphNode node,HashMap<UndirectedGraphNode,UndirectedGraphNode> map){
//	        UndirectedGraphNode cur = new UndirectedGraphNode(node.label);
//	         map.put(node,cur);
//	        for(UndirectedGraphNode neighbor:node.neighbors){
//	            if(!map.containsKey(neighbor)){
//	                cur.neighbors.add(helper(neighbor,map));
//	            }
//	            else{
//	                cur.neighbors.add(map.get(neighbor));
//	            }
//	        }
//	        return cur;
//	    }
//	    
	    
	    

	//BFS
	 public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
	       if(node == null){
	           return null;
	       }
	      Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
	      queue.offer(node);
	      HashMap<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
	      UndirectedGraphNode nodeClone = new UndirectedGraphNode(node.label);
	      map.put(node,nodeClone);
	      while(!queue.isEmpty()){
	          UndirectedGraphNode cur = queue.poll();
	          List<UndirectedGraphNode> list = new ArrayList<UndirectedGraphNode>();
	          for(UndirectedGraphNode neighbor:cur.neighbors){
	              if(map.containsKey(neighbor)){
	                  UndirectedGraphNode neighborClone = map.get(neighbor);
	                  list.add(neighborClone);
	              }
	              else{
	                  UndirectedGraphNode neighborClone = new UndirectedGraphNode(neighbor.label);
	                  list.add(neighborClone);
	                  map.put(neighbor,neighborClone);
	                  queue.offer(neighbor);
	              }
	          }
	          map.get(cur).neighbors = list;
	      }
	      return nodeClone;
	    }
	 public static void main(String args[]){
		 UndirectedGraphNode first = new UndirectedGraphNode(0);
		 UndirectedGraphNode second = new UndirectedGraphNode(0);
		 UndirectedGraphNode third = new UndirectedGraphNode(0);
		 first.neighbors.add(second);
		 first.neighbors.add(third);
		 UndirectedGraphNode res = cloneGraph(first);
		 System.out.println(res.neighbors.size());
	 }
}
