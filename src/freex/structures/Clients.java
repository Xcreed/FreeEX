package freex.structures;

/**
 * Client Class implements Vertex Interface. Has the 
 * main methods and logic for the Clients Nodes in 
 * the Graph. 
 * 
 * @author Randy
 *
 */
public class Clients implements Vertex {
	
	private int ei; 		// counter 1
	private int state; 		// counter 2
	static int ce=0; 		// counter 3
	protected String name; 	// name of the client (id)
	int pos; 				// position of the client 
	
	/**
	 * Constructor. 
	 * 
	 * @param name
	 */
	public Clients(String name){
		name = this.name;
		ei=0;
		pos=ce++;
	}
	
	/**
	 * Return the name of the a Client.
	 * 
	 * @return name
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * Set the counter ei (int).
	 */
	public void setEi(int x){
		ei=x;
	}
	
	/**
	 * Return the counter ei (int).
	 * 
	 * @return ei
	 */
	public int getEi(){
		return ei;
	}
	
	/**
	 * Set the counter state (int).
	 */
	public void setState(int x){
		state=x;
	}
	
	/**
	 * Return the counter state (int).
	 * 
	 * @return state
	 */
	public int getState(){
		return state;
	}
}
