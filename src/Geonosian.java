//Name:Kevin Do
//Last Update:11/21/2019
//Date Created:11/17/2019
/**
 * they built the death star and are now nearly extinct
 * @author Kevin
 *
 */
public class Geonosian extends Enemy
{
	/**
	 * Create a Geonosian
	 */
	public Geonosian() 
	{
		super("Geonosian", 1, 5);
	}

	/**
	 * @param target the person he is attacking
	 */
	@Override
	public void attack(Entity target) 
	{
		int damage = ((int)(Math.random() * 2));
		System.out.println(this.getName() + " hit " + target.getName() + " for " + damage + " Damage.");
		target.takeDamage(damage); 
	}

}
