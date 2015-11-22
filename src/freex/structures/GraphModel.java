package freex.structures;

/**
 * Interface GraphModel for the Graph Class.
 * 
 * @author Randy
 */

public interface GraphModel{
	
	public int numVertex();
	
	public int numEdges();
	
	public DoubleLinkedList vertex();
	
	public DoubleLinkedList edges();
	
	public Clients insertClient(String name);
	
	public BaseStations insertBaseStation(String name);
	
	public Edge insertEdge(Vertex v, Vertex w, int weight);
	
	public int degree(Vertex V);
	
	public DoubleLinkedList adjacentVertex(Vertex V);
	
	public DoubleLinkedList incidentEdges(Vertex V);
	
	//public String dfs();
}