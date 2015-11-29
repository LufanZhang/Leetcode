package graph;

import java.util.ArrayList;
//neighbors是指从这一点指向的node，也就是说这些neighbors都是它的孩子
public class DirectedGraphNode {
	int label;
	ArrayList<DirectedGraphNode> neighbors;
	DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
	 
}
