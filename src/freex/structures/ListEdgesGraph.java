package freex.structures;
import java.util.*;

/**
 * Class ListEdgeGraph implements the interface Graph
 * and allow to manipulate the Graph. 
 * 
 * @author Randy
 *
 */
	
public class ListEdgesGraph implements Graph{
		
	//public LinkedList lv=new LinkedList();
	//public LinkedList le=new LinkedList();
	
	public DoubleLinkedList listVertex = new DoubleLinkedList(); // a list for the vertex
	public DoubleLinkedList listEdges = new DoubleLinkedList(); // a list of the edges
	
	int cv=0; // contador de lv
	int ce=0; // contador de le
	
	/**
	 * Constructor
	 */
	public ListEdgesGraph(){
	}
	
	/**
	 * Return the amount of Vertex in the Graph.
	 * 
	 * @return int
	 */
	public int numVertex(){
		return listVertex.getLength();
	}
	
	/**
	 * Return the amount of Edges in the Graph.
	 * 
	 *@return int
	 */
	public int numEdges(){
		return listEdges.getLength();
	}
	
	/**
	 * Return the DoubleLinkedList of the Vertex
	 * of the graph.
	 *  
	 * @return listVertex
	 */
	public DoubleLinkedList vertex(){
		return listVertex;
	}
	
	/**
	 * Return the DoubleLinkedList of the Edges 
	 * of the Graph.
	 * 
	 * @return listEdges
	 */
	public DoubleLinkedList edges(){
		return listEdges;
	}
	
	/**
	 * Inserts and returns a new Vertex (client) 
	 * into the Graph.
	 * 
	 * @return v
	 */
	public Clients insertClient(String name){
		Clients c = new Clients (name);
		listVertex.insertEnd(c);
		return c;
	}

	/**
	 * Inserts and returns a new Vertex (BaseStations)
	 * into the Graph.
	 * 
	 * @returns bs
	 */
	public BaseStations insertBaseStation(String name){
		BaseStations bs = new BaseStations(name);
		listVertex.insertEnd(bs);
		return bs;
	}
	
	/**
	 * Insert and return the newest Edge made in the
	 * the Graph.
	 * 
	 * @return Edge
	 */
	public Edge insertEdge(Vertex v, Vertex w, int weight){
		int x,y;
		Edge e = new Edge(v,w,weight);
		listEdges.insertEnd(e);
		x=v.getEi(); // getting out
		x++;
		v.setEi(x);
		y=w.getEi(); //getting in
		y++;
		w.setEi(y);
		return e;
	}
	
	/**
	 * Returns the degree of the given Vertex (V)
	 * in the Graph. Degree is the amount of edges, coming
	 * in and out, that a given Vertex has.
	 * 
	 * @param V
	 * @return int
	 */
	public int degree(Vertex V){
		for (int i=0; i<listVertex.getLength(); i++){
			Vertex V2=(Vertex)listVertex.getItem(i);
			if (V==V2){
				return V.getEi();
			}
		}
		return 0;
	}

	
	//Regresa una lista de los vértices adyacentes a V
	public DoubleLinkedList adyacentVertex(Vertex V){
		DoubleLinkedList L= new DoubleLinkedList();
		for (int i=0; i<listEdges.getLength(); i++){ 
			Edge e=(Edge)listEdges.getItem(i);
			Vertex V1=e.getV1();
			Vertex V2=e.getV2();
			if (V1==V){
				L.insertEnd (V2);
			}else if (V2==V){
				L.insertEnd(V1);
			}
		}
		return L;
	}
	
	//        una lista
	//Regresa un iterador de las aristas que inciden en V
	public DoubleLinkedList incidentEdges(Vertex V){
		DoubleLinkedList L=new DoubleLinkedList();
		for (int i=0; i<listEdges.getLength(); i++){ 
			Edge e=(Edge)listEdges.getItem(i);
			Vertex V1=e.getV1();
			Vertex V2=e.getV2();
			if (V1==V){ 
				L.insertEnd(e);
			}else if (V2==V){ 
				L.insertEnd(e);
			}
		}
		return L;
	}
	
//	//Regresa el recorrido dfs de G
//	public String dfs(){
//		for (int i=0; i<listVertex.getLength(); i++){ 
//			Vertex w=(Vertex)listVertex.getItem(i);
//			w.setState(0);
//		}
//		DoubleLinkedList L=new DoubleLinkedList();
//		DoubleLinkedList L2=new DoubleLinkedList();
//		int c=0;
//		Vertex w=(Vertex)listVertex.getItem(0);
//		L.insertEnd(w);
//		w.setState(1);
//		String r="";
//		while (L.getLength() !=0){
//			w=(Vertex)L.getFirst();
//			//System.out.println(w.getElement());
//			r=r+w.getElement();
//			w.setState(3);
//			c--;
//			L.removeFirst();
//			L2=adjacentVertices(w);
//			for (int i=0;i<L2.size(); i++){ 
//				Vertex y=(Vertex)L2.get(i);
//				if (y.getState()==0){
//					L.add(c++,y);
//					y.setState(2);
//				}
//			}
//		}
//	return r;
//	}
}