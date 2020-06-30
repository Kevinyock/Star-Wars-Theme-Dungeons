//Name:Kevin Do
//Last Update:11/26/2019
//Date Created:11/19/2019
/**
 * Decorate the enemy to be unique
 * @author Kevin
 *
 */
public abstract class EnemyDecorator extends Enemy
{
	/**
	 * The enemy itself,we will make him special
	 */
	private Enemy enemy;
	
	/**
	 * @param enemydecorator the enemy decorator
	 */
	public EnemyDecorator(String name, int l, int m)
	{
		super(name, l + 1, m);
	}
	/**
	 * attack the enemy
	 */
	@Override
	public void attack(Entity target)
	{
		enemy.attack(target);
	}
	
}
