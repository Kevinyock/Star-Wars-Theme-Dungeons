//Name:Kevin Do
//Last Update:11/26/2019
//Date Created:9/2/2019
/**
 * Entity
 * @author Kevin
 */
public abstract class Entity
{
	/**
	 * Private Data Types
	 */
	private String name;
	private int level;
	private int maxHitpoints;
	private int hitpoints;
	//Public Data Type
	/**
	 * 
	 * @param n name of the entity
	 * @param l entity level
	 * @param m entity maxhp
	 */
	public Entity (String n,int l,int m)
	{
		name = n;
		level = l;
		maxHitpoints = m;
		hitpoints = m;
	}
	
	/**
	 * Superclass attack
	 * @param e entity
	 */
	public abstract void attack(Entity e);
	
	/**
	 * 
	 * @return entity name
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * @return entity level
	 */
	public int getLevel()
	{
		return level;
	}
	
	/**
	 * 
	 * @return the entity hp
	 */
	public int getHP()
	{
		return hitpoints;
	}
	
	/**
	 * 
	 * @return entity's max hp 
	 */
	public int getMaxHP()
	{
		return maxHitpoints;
	}
	
	/**
	 * raise the level of our entity and
	 * effect the amount of damage the entity deal
	 */
	public void IncreaseLevel()
	{
		level++;
	}
	
	/**
	 * heal our entity but if its hp is greater than max hp then set hp to max hp
	 * @param h how much health it healed
	 */
	public void heal(int h)
	{
		hitpoints += h;
		if(hitpoints > maxHitpoints)
		{
			hitpoints = maxHitpoints;
		}
	}
	
	/**
	 * @param h how much damage is he taking
	 */
	public void takeDamage(int h)
	{
		hitpoints -= h;
	}
	
	/**
	 * @param h how much are you adding to its max hp
	 * @return an more tanky player
	 */
	public void increaseMaxHP(int h)
	{
		maxHitpoints += h;
	}
	
	/**
	 * @param h how much hp are you removing from its max hp
	 * @return a less tanky player
	 */
	public void decreaseMaxHP(int h)
	{
		maxHitpoints -= h;
	}
	
	/**
	 * Display everything about our entity
	 */
	public void display()
	{
		System.out.println("Name:" + name);
		System.out.println("Level:" + level);
		System.out.println("HP:" + hitpoints + "/" + maxHitpoints);
	}
}
