//Name:Kevin Do
//Last Update:11/25/2019
//Date Created:11/17/2019
/**
 * Enemy Twilek
 * @author Kevin
 *
 */
public class Twilek extends Enemy
{

	/**
	 * Create a Twilek
	 */
	public Twilek()
	{
		super("Twi'lek", 1, 5);
	}

	/**
	 * Twi'lek attack the enemy
	 */
	@Override
	public void attack(Entity target) 
	{
		int damage = ((int)(Math.random() * 3));
		System.out.println(this.getName() + " hit " + target.getName() + " for " + damage + " Damage.");
		target.takeDamage(damage); 
	}
}
