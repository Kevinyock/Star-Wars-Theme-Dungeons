//Name:Kevin Do
//Last Update:11/26/2019
//Date Created:11/17/2019
/**
 * Dathormiri person
 * @author Kevin
 */
public class Dathormiri extends Enemy
{

	/**
	 * Create the Dathormiri
	 */
	public Dathormiri()
	{
		super("Dathormiri", 1, 5);
	}

	/**
	 * Attack him/her
	 * @param target him/her the enemy is targetting
	 */
	@Override
	public void attack(Entity target)
	{
		int damage = ((int)(Math.random() * 2));
		System.out.println(this.getName() + " hit " + target.getName() + " for " + damage + " Damage.");
		target.takeDamage(damage); 
	}	
	
}
