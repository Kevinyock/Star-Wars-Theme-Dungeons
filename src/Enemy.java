//Name:Kevin Do
//Last Update:11/21/2019
//Date Created:9/2/2019
/**
 * Abstract Enemy
 * basically what all enemies have in common
 * @author Kevin
 *
 */
public abstract class Enemy extends Entity
{
	//Component,Need to make a EnemyDecorator
	/**
	 * The item the enemy will hold
	 */
	private Item item;
	/**
	 * @param name name of the Enemy
	 * @param l level of the enemy
	 * @param m max health of enemy
	 */
	public Enemy (String name,int l, int m)
	{
		super(name,l,m); 
		item = ItemGenerator.getInstance().generateItem();
	}
	
	/**
	 * The enemy deal damage to the target depending on its level
	 * @param target the target itself
	 * 
	 */
	@Override
	public abstract void attack(Entity target); //The enemy deals damage from 0 to 5 * player level

	
	/**
	 * all enemies drop some good loot
	 * @return the item
	 */
	public Item getItem()//If Enemy dies you loot his body for items
	{
		return item;
	}
	
}
