//Name:Kevin Do
//Last Update:11/26/2019
//Date Created:9/2/2019
/**
 * Enemy is force sensititive the whole time
 * @author Kevin
 *
 */
public class ForceEnemy extends EnemyDecorator implements Force
{
	/**
	 * @param e The enemy was force sensitive the whole time
	 */
	//public functions
	public ForceEnemy(Enemy e)
	{
		super(e.getName().contains("Force User") ? e.getName() :e.getName() + " Force User",e.getLevel(),e.getMaxHP() + 2); 
	}
	
	/**
	 * The force enemy deal a random amount of damage
	 * @param target The player
	 * @return A damaged player
	 */
	@Override
	public void attack(Entity target)
	{
		switch((int)(Math.random() * 3))
		{
		case 1:
			System.out.println(this.getName() + " use force Push on " + target.getName() + " and deal " + forcePush() + " Damage.");
			target.takeDamage(forcePush());
			break;
		case 2:
			System.out.println(this.getName() + " use force Choke on " + target.getName() + " and deal " + forceChoke() + " Damage.");
			target.takeDamage(forceChoke());
			break;
		case 3:
			System.out.println(this.getName() + " use force Slam on " + target.getName() + " and deal " + forceSlam() + " Damage.");
			target.takeDamage(forceSlam());
			break;
			default:
				target.takeDamage(0);
				break;
		}
	}
	
	/**
	 * Weak - Force Push
	 * @return 0 to 1 damage
	 */
	@Override
	public int forcePush()
	{
		return 1;
	}
	
	/**
	 * Moderate - Force Choke
	 * @return 0 to 2 damage
	 */
	@Override
	public int forceChoke()
	{
		return (int)(Math.random() * 2);
	}
	
	/**
	 * Hard - Force Slam him to the ground
	 * @return 0 to 3 damage
	 */
	@Override
	public int forceSlam() 
	{
		return (int)(Math.random() * 3);
	}
	
}
