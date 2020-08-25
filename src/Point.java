//Name:Kevin Do
//Last Update:11/12/2019
//Date Created:9/2/2019
/**
 * Points on our coordinate system
 * @author Kevin
 *
 */
public class Point
{
	/**
	 * x position (left or right)
	 */
	private int x;
	
	/**
	 * y position (up or down)
	 */
	private int y;
	
	/**
	 * overloaded constructor
	 * @param x the objects current x position
	 * @param y the objects current y position
	 */
	public Point(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public int decrementPostX()
	{
		return x--;
	}
	
	public int decrementPostY()
	{
		return y--;
	}
	
	public int incrementPostX()
	{
		return x++;
	}
	
	public int incrementPostY()
	{
		return y++;
	}
}
