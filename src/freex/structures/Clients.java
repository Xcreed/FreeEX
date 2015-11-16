package freex.structures;

public class Clients implements Vertex {
	
	private int ei;
	private int state;
	static int ce=0;
	protected String name;
	int pos;
	
	public Clients(String name){
		name = this.name;
		ei=0;
		pos=ce++;
	}
	
	public String getName(){
		return name;
	}
	
	public void setEi(int x){
		ei=x;
	}
	
	public int getEi(){
		return ei;
	}
	
	public void setState(int x){
		state=x;
	}
	
	public int getState(){
		return state;
	}
}
