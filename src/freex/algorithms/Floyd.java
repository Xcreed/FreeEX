package freex.algorithms;

public class Floyd {
	
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
	
	public String pathR(int i, int k, String[][] pathsAux, String pathsUsed){
		if (pathsAux[i][k].equals("")){
			return "";
		}else{
			pathsUsed += pathR(i,Integer.parseInt(pathsAux[i][k].toString()), pathsAux, pathsUsed) + (Integer.parseInt(pathsAux[i][k].toString())+1)+ ", ";
			return pathsUsed;
		}
	}
}
