package freex.structures;
	
public class Tester2{
	
	public Tester2() {
	}
	
	public static void main(String[] args) {
		String r="";
		System.out.println("------------------------------------------------");
		System.out.println("Nuevo Grafo");
		ListEdgesGraph g= new ListEdgesGraph(); 
		System.out.println("------------------------------------------------");
		System.out.println("Insertar Cliente A:");
		Clients v1 = g.insertClient("A"); 
		System.out.println("------------------------------------------------");
		System.out.println("Insertar Cliente B:");
		Clients v2 = g.insertClient("B");
		System.out.println("------------------------------------------------");
		System.out.println("Insertar Arista entre Vertices 1 y 2, peso de 3:");
		g.insertEdge(v1,v2,3); 
		System.out.println("------------------------------------------------");
		System.out.println("Insertar BaseStation I:");
		BaseStations v3=g.insertBaseStation("BaseStation I");
		System.out.println("------------------------------------------------");
		System.out.println("Insertar Arista entre Vertices 2 y 3, peso de 5:");
		g.insertEdge(v2,v3,5);
		System.out.println("------------------------------------------------");
		System.out.println("Insertar Cliente C:");
		Clients v4=g.insertClient("C");
		System.out.println("------------------------------------------------");
		System.out.println("Insertar Arista entre Vertices 3 y 4, peso de 1:");
		g.insertEdge(v3,v4,1);
		System.out.println("------------------------------------------------");
		System.out.println("Insertar Cliente D:");
		Clients v5=g.insertClient("D");
		System.out.println("------------------------------------------------");
		System.out.println("Insertar Arista entre Vertices 1 y 5, peso de 14:");
		g.insertEdge(v1,v5,14);
		System.out.println("------------------------------------------------");
		System.out.println("Insertar Arista entre Vertices 2 y 5, peso de 34:");
		g.insertEdge(v2,v5,34);
		System.out.println("------------------------------------------------");
		System.out.println("Insertar Arista entre Vertices 3 y 5, peso de 7:");
		g.insertEdge(v3,v5,7);
		System.out.println("------------------------------------------------");
		System.out.println("Insertar Cliente E:");
		Clients v6=g.insertClient("E");
		System.out.println("------------------------------------------------");
		System.out.println("Insertar Arista entre Vertices 3 y 6, peso de 90:");
		g.insertEdge(v3,v6,90);
		System.out.println("------------------------------------------------");
		System.out.println("Insertar BaseStation II");
		BaseStations v7=g.insertBaseStation("BaseStation II");
		System.out.println("------------------------------------------------");
		System.out.println("Insertar Arista entre Vertices 5 y 7, peso de 45:");
		g.insertEdge(v5,v7,45);
		System.out.println("------------------------------------------------");
		System.out.println("Insertar BaseStation III:");
		BaseStations v8=g.insertBaseStation("BaseStation III");
		System.out.println("------------------------------------------------");
		System.out.println("Insertar Arista entre Vertices 1 y 8, peso de 1:");
		g.insertEdge(v1,v8,11);
		System.out.println("------------------------------------------------");
		System.out.println("Insertar Arista entre Vertices 5 y 8, peso de 5:");
		g.insertEdge(v5,v8,5);
		System.out.println("------------------------------------------------");
		System.out.println("Insertar BaseStation IV:");
		BaseStations v9=g.insertBaseStation("BaseStation IV");
		System.out.println("------------------------------------------------");
		System.out.println("Insertar Arista entre Vertices 8 y 9, peso de 3:");
		g.insertEdge(v8,v9,3);
		System.out.println("------------------------------------------------");
		System.out.println("Insertar Cliente F:");
		Clients v10=g.insertClient("F");
		System.out.println("------------------------------------------------");
		System.out.println("Insertar Arista entre Vertices 6 y 10, peso de 1:");
		g.insertEdge(v6,v10,1);
		System.out.println("------------------------------------------------");
		System.out.println("Insertar Arista entre Vertices 8 y 10, peso de 10:");
		g.insertEdge(v8,v10,10);
		System.out.println("------------------------------------------------");
		System.out.println("Insertar Arista entre Vertices 7 y 10, peso de 19:");
		g.insertEdge(v7,v10,19);
		System.out.println("------------------------------------------------");
		System.out.println("------------------------------------------------");
		//---------------------------------------------------------------------------//
		System.out.println("Numero de vertices: "+g.numVertex());
		System.out.println("Numero de aristas: "+g.numEdges());
		System.out.println("Grado del vertice A: "+g.degree(v1));
		System.out.println("Grado del vertice BaseStation III: "+g.degree(v8));
	}
}