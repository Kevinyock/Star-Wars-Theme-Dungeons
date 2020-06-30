//Name:Kevin Do
//Last Update:11/26/2019
//Date Created:9/2/2019
/**
 * The Force
 * @author Kevin
 */
public interface Force
{
	//Public Data Type
	/**
	 * Give the player the option to Display what force ability to use
	 */
	public static final String FORCE_MENU  = "1. Force Push\n2. Force Choke\n3. Force Slam";
	public int forcePush();
	public int forceChoke();
	public int forceSlam();
}
