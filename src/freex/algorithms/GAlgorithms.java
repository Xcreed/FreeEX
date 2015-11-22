package freex.algorithms;

import freex.structures.*;
/**
 * GAlgorithms Class allow to apply different algorithms into
 * any graph. GAlgorithms wraps the Graph and work it out through
 * the methods it has. 
 *  
 * @author Randy
 *
 */
public class GAlgorithms {
	
	int [][] AdjancentMatrix; // matrix for paths possible paths
	long [][] weightMatrix;    // matrix for weight for the paths
	
	
//	public int[][] makeAdjacentMatrix(Graph graph){
//		DoubleLinkedList listVertex = graph.vertex();
//		int lenMatrix = listVertex.getLength();
//		boolean bool = false;
//		
//		for(int i = 0; i<lenMatrix; i++){
//			for(int j = 0; j<lenMatrix; i++){
//				Vertex ver = (Vertex) listVertex.getItem(j); // VER IS AN VERTEX
//				DoubleLinkedList listVer = graph.adjacentVertex(ver); // LISTVER IS A LIST THAT CONTAINT THE ADYACENT VERTEX OF VER
//				if(listVer.getItem(j).){
//					
//				}
//				
//					
//			
//				}
//				
//			}
//		return AdjancentMatrix;
//		}
//		
//	
	//----------------------------------------------------------------------------------------------------------------------//

	/**
	 * FLOYD !!!
	 * 
	 * @param mAdy
	 * @return
	 */
	public String floydAl(long [][] mAdy){
		
		int vertex = mAdy.length;
		long matrixAdyacent [][] = mAdy;
		String paths[][] = new String [vertex][vertex];
		String pathsAux[][] = new String[vertex][vertex];
		String pathsUsed = "";
		String msg = "";
		String pathsAlt="";
		int i,j,k;
		float temp1,temp2,temp3,temp4,minimum;
		
		for(i=0; i<vertex; i++){
			for(j=0; j<vertex; j++){
				paths[i][j]="";
				pathsAux[i][j]="";	
			}
		}
		
		for (k=0; k<vertex; k++){
			for(i=0; i<vertex; i++ ){
				for(j=0; j<vertex; j++){
					temp1 = matrixAdyacent[i][j];
					temp2 = matrixAdyacent[i][k];
					temp3 = matrixAdyacent[k][j];
					temp4 = temp2 + temp3;
					minimum=Math.min(temp1, temp4);
					
					if(temp1 != temp4){
						if(minimum == temp4){
							pathsUsed="";
							pathsAux[i][j]= k + "";
							paths[i][j]= pathR(i,k,pathsAux,pathsUsed) + (k+1);
						}
					}
					matrixAdyacent[i][j]=(long) minimum;
				}
			}
		}
		for(i=0; i<vertex; i++){
			for(j=0; j<vertex; j++){
				msg = msg+"["+matrixAdyacent[i][j]+"]";
			}
			msg = msg + "\n";
		}
		/*********/
		for(i=0; i<vertex; i++){
			for(j=0; j<vertex; j++){
				if(matrixAdyacent[i][j] != 1000000000){
					if(i != j){
						if(paths[i][j].equals("")){
							pathsAlt +="De ("+(i+1)+"----->"+(j+1)+") Irse por..("+(i+1)+","+(j+1)+")\n";
						}else{
							pathsAlt += "De ("+(i+1)+"----->"+(j+1)+") Irse por..("+(i+1)+","+ paths[i][j]+","+(j+1)+")\n"; 
							
						}
					}
					
				}
			}
		}
		return "Paths \n" + msg + "shortest paths \n" + pathsAlt;
	}
	/**
	 * floyd !!!!
	 * @param i
	 * @param k
	 * @param pathsAux
	 * @param pathsUsed
	 * @return
	 */
	public String pathR(int i, int k, String[][] pathsAux, String pathsUsed){
		if (pathsAux[i][k].equals("")){
			return "";
		}else{
			pathsUsed += pathR(i,Integer.parseInt(pathsAux[i][k].toString()), pathsAux, pathsUsed) + (Integer.parseInt(pathsAux[i][k].toString())+1)+ ", ";
			return pathsUsed;
		}
	}
}
	//----------------------------------------------------------------------------------------------------------------------//
//	/**
//	 * kruskal !!!!
//	 * @param grafo
//	 * @return
//	 */
	//public ListEdgesGraphs aplicarKruskal(ListEdgesGraphs grafo){
		//Graph treeGraph = new Graph();
		//ArrayList<String> nodos=grafo.getNombres();
//
//		for(int j=0;j<nodos.size();j++){
//			árbol.ingresarNodo(nodos.get(j));
//		}
//
//		ArrayList<Arco> L=(ArrayList<Arco>)grafo.getAristas().clone();
//
//		Arco pro=L.get(0);
//		árbol.adicionarEnlace(pro.getInicial(), pro.getTerminal(), pro.getPeso());
//		L.remove(pro);
//
//		while(L.size()!=0)
//		{
//			pro=L.get(0);
//
//			if(HayCiclo(árbol, pro,árbol.getNodo(pro.getTerminal()) , pro.getTerminal())==false)
//				árbol.adicionarEnlace(pro.getInicial(), pro.getTerminal(), pro.getPeso());
//
//			L.remove(pro);
//		}
//
//		return árbol;
//	}
//
//	/**
//	 * kruskal !!!!!
//	 * 
//	 * @param g
//	 * @param aVerificar
//	 * @param terminal
//	 * @param N
//	 * @return
//	 */
//	public boolean HayCiclo(Grafo g,Arco aVerificar,Nodo terminal,String N){
//		ArrayList<Enlace> aux=terminal.getEnlaces();
//
//		if(aux.size()==0)
//			return false;
//
//		if(terminal.existeEnlace(aVerificar.getInicial())!=-1)
//			return true;
//
//		for(int i=0;i<aux.size();i++)
//		{
//			Enlace nodo=aux.get(i);
//
//			if(nodo.getDestino().equals(N)==false)
//				if( HayCiclo(g,aVerificar,g.getNodo(nodo.getDestino()),terminal.getNombre()))
//									return true;
//		}
//		return false;
//	}
//}
