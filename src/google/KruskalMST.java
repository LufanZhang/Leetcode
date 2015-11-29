package google;
//与prime不同的是，kruskal是把散点树连成森林，而prime是一个森林的扩张
//这个算法的思路就是把每个edge的weight先排个序，然后从最小的连起来，如果当前最小weight的edge连着的两个属于同一个森林，就舍弃这个
//看下一个，如果属于不同森林，就可以把这两个小森林连起来了，看是不是属于同一个森林可以用union find来做
public class KruskalMST {
	class Edge{
		int weight;
		
	}
}
