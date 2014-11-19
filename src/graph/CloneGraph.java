package graph;

import java.util.ArrayList;
import java.util.HashMap;

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
	 public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
	        if(node==null)
	        return null;
	        HashMap<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
	        //this function will put the node in key, and the completed clone graph in value
	        cloneHelper(node,map);
	        return map.get(node);
	    }
	    public void cloneHelper(UndirectedGraphNode node,HashMap<UndirectedGraphNode,UndirectedGraphNode> map){
	        if(map.containsKey(node))
	        return;
	        UndirectedGraphNode  nodeClone = new UndirectedGraphNode(node.label);
	        ArrayList<UndirectedGraphNode> neighborClone = new ArrayList<UndirectedGraphNode>();
	        map.put(node,nodeClone);
	        for(UndirectedGraphNode neighbor:node.neighbors){
	            cloneHelper(neighbor,map);
	            neighborClone.add(map.get(neighbor));
	        }
	        nodeClone.neighbors = neighborClone;
	    }
}
