//Name:Kevin Do
//Last Update:11/14/2019
//Date Created:8/29/2019
/**
 * Item(prototype)
 * @author Kevin
 * @version 1.1
 */
public class Item implements Cloneable
{
	//Private Data Type
	/**
	 * @param name Name Of Item
	 */
	private String name;
	//Public Function
	/**
	 * Item Constructor
	 * @param n the name of the item
	 */
	public Item(String n)
	{
		name = n;
	}
	
	/**
	 * 
	 * @return item's name
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Clone the item
	 * @return the new item
	 */
	@Override
	public Item clone()
	{
		return new Item(name);
	}
	
}
