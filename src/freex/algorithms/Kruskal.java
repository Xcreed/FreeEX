package freex.algorithms;

import freex.structures.*;
import java.util.ArrayList;

public class Kruskal{

	public ListEdgesGraphs aplicarKruskal(ListEdgesGraphs grafo){
		Grafo �rbol=new Grafo();
		ArrayList<String> nodos=grafo.getNombres();

		for(int j=0;j<nodos.size();j++){
			�rbol.ingresarNodo(nodos.get(j));
		}

		ArrayList<Arco> L=(ArrayList<Arco>)grafo.getAristas().clone();

		Arco pro=L.get(0);
		�rbol.adicionarEnlace(pro.getInicial(), pro.getTerminal(), pro.getPeso());
		L.remove(pro);

		while(L.size()!=0)
		{
			pro=L.get(0);

			if(HayCiclo(�rbol, pro,�rbol.getNodo(pro.getTerminal()) , pro.getTerminal())==false)
				�rbol.adicionarEnlace(pro.getInicial(), pro.getTerminal(), pro.getPeso());

			L.remove(pro);
		}

		return �rbol;
	}

	public boolean HayCiclo(Grafo g,Arco aVerificar,Nodo terminal,String N)
	{
		ArrayList<Enlace> aux=terminal.getEnlaces();

		if(aux.size()==0)
			return false;

		if(terminal.existeEnlace(aVerificar.getInicial())!=-1)
			return true;

		for(int i=0;i<aux.size();i++)
		{
			Enlace nodo=aux.get(i);

			if(nodo.getDestino().equals(N)==false)
				if( HayCiclo(g,aVerificar,g.getNodo(nodo.getDestino()),terminal.getNombre()))
									return true;
		}

		return false;
	}
}
