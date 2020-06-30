//Name:Kevin Do
//Last Update:11/21/2019
//Date Created:11/17/2019
/**
 * Rodian
 * @author Kevin
 */
public class Rodian extends Enemy
{

	/**
	 * Create a Rodian
	 */
	public Rodian()
	{
		super("Rodian", 1, 6);
	}
	
	/**
	 * Attack the enemy
	 */
	@Override
	public void attack(Entity target)
	{
		int damage = ((int)(Math.random() * 2));
		System.out.println(this.getName() + " hit " + target.getName() + " for " + damage + " Damage.");
		target.takeDamage(damage); 
	}

}
