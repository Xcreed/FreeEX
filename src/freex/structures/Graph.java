package freex.structures;

/**
 * Interface for the Graph.
 * 
 * @author Randy
 */

public interface Graph{
	
	public int numVertex();
	
	public int numEdges();
	
	public DoubleLinkedList vertex();
	
	public DoubleLinkedList edges();
	
	public Clients insertClient(String name);
	
	public BaseStations insertBaseStation(String name);
	
	public Edge insertEdge(Vertex v, Vertex w, int weight);
	
	public int degree(Vertex V);
	
	public DoubleLinkedList adyacentVertex(Vertex V);
	
	public DoubleLinkedList incidentEdges(Vertex V);
	
//	public String dfs();
}