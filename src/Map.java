import java.io.*;
import java.util.Scanner;
//Name:Kevin Do
//Last Update:11/28/2019
//Date Created:9/2/2019
/**
 * Our game's map
 * @author Kevin
 *
 */
public class Map 
{
	//Private Data Type
	/**
	 * the "geometry" of the world
	 */
	private char [][] map = new char[5][5];
	
	/**
	 * Fog of war
	 */
	private boolean [][] revealed = new boolean[5][5];
	
	/**
	 * our singleton map object
	 */
	private static Map instance = null;
	
	//Public Functions
	/**
	 * default constructor
	 */
	private Map()
	{
	}
	
	/**
	 * if it exist then point me to it otherwise create one
	 * @return the object itself
	 */
	public static Map getInstance()
	{
		if(instance == null)
		{
			instance = new Map();
		}
		return instance;
	}
	/**
	 * Load the map when we started a new round
	 * @param mapNum map number
	 */
	public void _loadMap(int mapNum)
	{
		switch(mapNum)
		{
		case 1:
			try
			{
				Scanner map1 = new Scanner(new File("Map1.txt"));
				for(int i = 0; i < 5; i++)
				{
					String maprow1 = map1.nextLine();
					String[] splitmap1 = maprow1.split(" ");
					
					for(int j = 0; j <5; j++)
					{
						map[i][j] = splitmap1[j].charAt(0);
						revealed[i][j] = false;
					}
				}
				map1.close();
			}
			catch(FileNotFoundException fnf)
			{
				System.out.println("File was not found");
			}
			break;
		case 2:
			try
			{
				Scanner map2 = new Scanner(new File("Map2.txt"));
				for(int i = 0; i < 5; i++)
				{
					String maprow2 = map2.nextLine();
					String[] splitmap2 = maprow2.split(" ");
					for(int j = 0; j <5; j++)
					{
						map[i][j] = splitmap2[j].charAt(0);
						revealed[i][j] = false;
					}
					
				}
				map2.close();
			}
			catch(FileNotFoundException fnf)
			{
				System.out.println("File was not found");
			}
			break;
		case 3:
			try
			{
				Scanner map3 = new Scanner(new File("Map3.txt"));
				for(int i = 0; i < 5; i++)
				{
					String maprow3 = map3.nextLine();
					String[] splitmap3 = maprow3.split(" ");
					for(int j = 0; j <5; j++)
					{
						map[i][j] = splitmap3[j].charAt(0);
						revealed[i][j] = false;
					}
					
				}
				map3.close();
			}
			catch(FileNotFoundException fnf)
			{
				System.out.println("File was not found");
			}
			break;
		case 4:
			try
			{
				Scanner map1 = new Scanner(new File("Map1.txt"));
				for(int i = 0; i < 5; i++)
				{
					String maprow1 = map1.nextLine();
					String[] splitmap1 = maprow1.split(" ");
					
					for(int j = 0; j <5; j++)
					{
						map[i][j] = splitmap1[j].charAt(0);
						revealed[i][j] = false;
					}
				}
				map1.close();
			}
			catch(FileNotFoundException fnf)
			{
				System.out.println("File was not found");
			}
			break;
		case 5:
			try
			{
				Scanner map2 = new Scanner(new File("Map2.txt"));
				for(int i = 0; i < 5; i++)
				{
					String maprow2 = map2.nextLine();
					String[] splitmap2 = maprow2.split(" ");
					for(int j = 0; j <5; j++)
					{
						map[i][j] = splitmap2[j].charAt(0);
						revealed[i][j] = false;
					}
					
				}
				map2.close();
			}
			catch(FileNotFoundException fnf)
			{
				System.out.println("File was not found");
			}
			break;
		default:
			System.out.println("Map is not found!");
		}
	}
	
	/**
	 * @param p Point p
	 * @return receiving intelligence of this location
	 */
	
	public char getCharAtLoc(Point p)
	{
			return map[p.getX()][p.getY()];
	}
	
	/**
	 * Display the entire map
	 * @param p the point
	 * @return a display of the entire map
	 */
	
	public void displayMap(Point p)
	{
		for (int i = 0; i < 5 ; i++)
		{
			for(int j = 0; j < 5; j++)
			{
				if(p.getX() == i && p.getY() == j)
				{
					System.out.print("H" + "");
				}
				else if(revealed[i][j] == true)
				{
					System.out.print(map[i][j]);
				}
				else
				{
					System.out.print("@" + "");
				}
				
			}
		}
	}
	
	/**
	 * we load the map and find where is our starting point
	 * @return the starting point
	 */
	
	public Point findStart()
	{
		Point startPoint = null;
		// This function finds the starting point on the map
		for (int i = 0; i < 5; i++)
		{
			for(int j = 0; j < 5; j++)
			{
				if(map[i][j] == 's')
				{
					startPoint = new Point(i,j);
				}
			}
		}
		return startPoint;
	}
	
	/**
	 * 
	 * @param p the hero current position
	 * @return the map location is now charted as true
	 */
	
	public void reveal(Point p)
	{
		//System.out.print(p.getX() + " " + p.getY() + "\n");
		revealed[p.getX()][p.getY()] = true;
		//System.out.print("Sup\n");
	}
	
	/**
	 * We cleared the area and there is none thing there
	 * @param p The point the hero is at
	 * @return The location is marked n for none thing
	 */
	
	public void removeCharAtLoc(Point p)
	{
		
		try
		{
			switch(map[p.getX()][p.getY()])
			{
			case 'f':
				map[p.getX()][p.getY()] = 'f';
				break;
			case 'e':
				map[p.getX()][p.getY()] = 'n';
				break;
				default:
					map[p.getX()][p.getY()]= 'n'; 
					break;
			}
			
			/*if(map[p.getX()][p.getX()] != 'f')
			{
				map[p.getX()][p.getY()] = 'n'; 
			}*/
		}
		catch(ArrayIndexOutOfBoundsException ab)
		{
			System.out.println("Position is out of the map");
		}
	}
}
