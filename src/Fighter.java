//Name:Kevin Do
//Last Update:11/26/2019
//Date Created:11/21/2019
/**
 * Enemy Fighter
 * @author Kevin
 */
public class Fighter extends EnemyDecorator 
{
	/**
	 * we turn our regular enemy into a fighter
	 * @param e enemy
	 */
	public Fighter(Enemy e)
	{
		//(expression) ? expressionTrue : expressinFalse;
		super(e.getName().contains("Fighter") ? e.getName() : e.getName() + " Fighter", e.getLevel(), e.getMaxHP() + 1);
	}
	
	/**
	 * attack the enemy
	 * @param target the enemy should try to kill
	 */
	@Override
	public void attack(Entity target)
	{
		int damage = ((int)(Math.random() * 2));
		System.out.println(this.getName() + " hit " + target.getName() + " for " + damage + " Damage.");
		target.takeDamage(damage); 
	}
}
