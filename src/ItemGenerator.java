import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
//Name:Kevin Do
//Last Update:11/12/2019
//Date Created:9/2/2019

/**
 * Item Generator Class
 * @author Kevin
 *
 */
public class ItemGenerator
{
	//Private Data Type
	/**
	 * itemList our list of items 
	 */
	private ArrayList<Item> itemList = new ArrayList<Item>();
	
	/**
	 * a item generator Instance by default points to none thing
	 */
	private static ItemGenerator instance = null;
	
	//Public Functions
	/**
	 * Item Generator constructor
	 */
	private ItemGenerator() 
	{
		try 
		{
			Scanner read = new Scanner(new File("ItemList.txt"));
			do
			{
				String itemAdded = read.nextLine();
				Item newItem = new Item(itemAdded);
				itemList.add(newItem);
			}
			while(read.hasNext());
			read.close();
		}
		catch(FileNotFoundException fnf)
		{
			System.out.println("File is not found!");
		}
	}
	
	/**
	 * get this object
	 * @return this object if the it does not exist
	 */
	public static ItemGenerator getInstance()
	{
		if(instance == null)
		{
			instance = new ItemGenerator();
		}
		return instance;
	}
	
	/**
	 * Generates a random item form our list
	 * @return a new item
	 */
	public Item generateItem()
	{
		int randNum = (int)(Math.random() * itemList.size());
		return itemList.get(randNum).clone();
	}
}
