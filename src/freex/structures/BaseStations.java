package freex.structures;

/**
 * BaseStations Class is an extension of Clients Class.
 * As same as Clients have the main similar functions, but
 * when notify.
 * 
 * @author Randy
 *
 */
public class BaseStations extends Clients{
	
	/**
	 * Constructor.
	 * 
	 * @param name
	 */
	public BaseStations(String name) {
		super(name);
	}
	
	/**
	 * Return the name of BaseStation.
	 * 
	 * @return name
	 */
	public String getName(){
		return name;
	}

}
