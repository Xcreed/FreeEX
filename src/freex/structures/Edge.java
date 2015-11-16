package freex.structures;

/**
 * Edge Class for the edges that manke union
 * between different node inside the Graph.
 * 
 * @author Randy
 *
 */
public class Edge{
	
	int weight;
	Vertex v1;
	Vertex v2;
	int pos;
	static int cv=0;
	/** Creates a new instance of Edge */
	
	/**
	 *Constructor. 
	 */
	public Edge(){
		cv++;
	}
	
	/**
	 * Constructor. 
	 * 
	 * @param v
	 * @param w
	 * @param O
	 */
	public Edge(Vertex v,Vertex w, int weight) {
		cv++;
		v1=v;
		v2=w;
		weight=this.weight;
	}
	
	/**
	 * Return one vertex connected into the Edge.
	 * 
	 * @return v1
	 */
	public Vertex getV1(){
		return v1;
	}
	
	/**
	 * Return one vertex connected into the Edge.
	 * 
	 * @return v2
	 */
	public Vertex getV2(){ 
		return v2;
	}
}