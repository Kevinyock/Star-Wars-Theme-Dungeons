//Name:Kevin Do
//Last Update:12/5/2019
//Date Created:9/2/2019
/**
 * Enemy Generator class
 * It generates an enemy with a random item
 * @author Kevin
 * @version 1.1
 */
public class EnemyGenerator
{
	//Private Objects
	/**
	 * an instance of Enemy Generator Object
	 * by default its null
	 */
	private static EnemyGenerator instance = null;
	
	//Public Data Types
	
	/**
	 * Default Constructor
	 */
	private EnemyGenerator() 
	{
	}
	
	/**
	 * if the singleton doesnt exist then we create one
	 * @return the instance of the object(ONLY 1!)
	 */
	public static EnemyGenerator getInstance()
	{
		if(instance == null)
		{
			instance = new EnemyGenerator();
		}
		return instance;
	}
	
	/**
	 * Generate a random enemy
	 * @param level Player Level
	 * @return new force-sensitive enemy / enemy fighter / enemy
	 */
	public Enemy generateEnemy(int level)
	{
		/**
		 * The enemy itself
		 */
		Enemy enemy = null;
		//Default type
		
		int typeofenemy = 0;
		//Type of Species? 0: Dathormiri 1:Geonosian 2:Rodian 3:Twi'lek 
		int specieDesignation = (int)(Math.random() * 3);
		if(level > 1)
		{
			// Fighter or Force User 0:Fighter 1:Force User
			typeofenemy = (int)(Math.random() * 1);
		}
		
		switch(level)
		{
		case 1: //Level 1 - generate just one of the 4 species
			switch(specieDesignation)
			{
			case 1:
				//new ForceEnemy(new Geonosian());
				enemy = new Geonosian();
				break;
			case 2:
				enemy = new Rodian();
				break;
			case 3:
				enemy = new Twilek();
				break;
				default:
					enemy = new Dathormiri();
					break;
			}
			break;
		case 2: //Level 2
			if(typeofenemy == 0) //generate fighter equivalent
			{
				switch(specieDesignation)
				{
				case 1:
					//new ForceEnemy(new Geonosian());
					enemy = new Fighter(new Geonosian());
					break;
				case 2:
					enemy = new Fighter(new Rodian());
					break;
				case 3:
					enemy = new Fighter(new Twilek());
					break;
					default:
						enemy = new Fighter(new Dathormiri());
						break;
				}
			}
			else
			{
				switch(specieDesignation)
				{
				case 1:
					//new ForceEnemy(new Geonosian());
					enemy = new ForceEnemy(new Geonosian());
					break;
				case 2:
					enemy = new ForceEnemy(new Rodian());
					break;
				case 3:
					enemy = new ForceEnemy(new Twilek());
					break;
					default:
						enemy = new ForceEnemy(new Dathormiri());
						break;
				}
			}
			break;
		case 3: //Level 3
			if(typeofenemy == 0)
			{
				switch(specieDesignation)
				{
				case 1:
					enemy = new Fighter(new Fighter(new Geonosian()));
					break;
				case 2:
					enemy = new Fighter(new Fighter(new Rodian()));
					break;
				case 3:
					enemy = new Fighter(new Fighter(new Twilek()));
					break;
					default:
						enemy = new Fighter(new Fighter(new Dathormiri()));
						break;
				}
			}
			else
			{
				switch(specieDesignation)
				{
				case 1:
					enemy = new ForceEnemy(new ForceEnemy(new Geonosian()));
					break;
				case 2:
					enemy = new ForceEnemy(new ForceEnemy(new Rodian()));
					break;
				case 3:
					enemy = new ForceEnemy(new ForceEnemy(new Twilek()));
					break;
					default:
						enemy = new ForceEnemy(new ForceEnemy(new Dathormiri()));
						break;
				}
			}
			break;
		case 4: //Level 4
			if(typeofenemy == 0)
			{
				switch(specieDesignation)
				{
				case 1:
					enemy = new Fighter(new Fighter(new Fighter(new Geonosian())));
					break;
				case 2:
					enemy = new Fighter(new Fighter(new Fighter(new Rodian())));
					break;
				case 3:
					enemy = new Fighter(new Fighter(new Fighter(new Twilek())));
					break;
					default:
						enemy = new Fighter(new Fighter(new Fighter(new Dathormiri())));
						break;
				}
			}
			else
			{
				switch(specieDesignation)
				{
				case 1:
					enemy = new ForceEnemy(new ForceEnemy(new ForceEnemy(new Geonosian())));
					break;
				case 2:
					enemy = new ForceEnemy(new ForceEnemy(new ForceEnemy(new Rodian())));
					break;
				case 3:
					enemy = new ForceEnemy(new ForceEnemy(new ForceEnemy(new Twilek())));
					break;
					default:
						enemy = new ForceEnemy(new ForceEnemy(new ForceEnemy(new Dathormiri())));
						break;
				}
			}
			break;
		case 5:// Level 5
			if(typeofenemy == 0)
			{
				switch(specieDesignation)
				{
				case 1:
					enemy = new Fighter(new Fighter(new Fighter(new Fighter(new Geonosian()))));
					break;
				case 2:
					enemy = new Fighter(new Fighter(new Fighter(new Fighter(new Rodian()))));
					break;
				case 3:
					enemy = new Fighter(new Fighter(new Fighter(new Fighter(new Twilek()))));
					break;
					default:
						enemy = new Fighter(new Fighter(new Fighter(new Fighter(new Dathormiri()))));
						break;
				}
			}
			else
			{
				switch(specieDesignation)
				{
				case 1:
					enemy = new ForceEnemy(new ForceEnemy(new ForceEnemy(new ForceEnemy(new Geonosian()))));
					break;
				case 2:
					enemy = new ForceEnemy(new ForceEnemy(new ForceEnemy(new ForceEnemy(new Rodian()))));
					break;
				case 3:
					enemy = new ForceEnemy(new ForceEnemy(new ForceEnemy(new ForceEnemy(new Twilek()))));
					break;
					default:
						enemy = new ForceEnemy(new ForceEnemy(new ForceEnemy(new ForceEnemy(new Dathormiri()))));
						break;
				}
			}
			break;
		case 6: //Level 6
			if(typeofenemy == 0)
			{
				switch(specieDesignation)
				{
				case 1:
					enemy = new Fighter(new Fighter(new Fighter(new Fighter(new Fighter(new Geonosian())))));
					break;
				case 2:
					enemy = new Fighter(new Fighter(new Fighter(new Fighter(new Fighter(new Rodian())))));
					break;
				case 3:
					enemy = new Fighter(new Fighter(new Fighter(new Fighter(new Fighter(new Twilek())))));
					break;
					default:
						enemy = new Fighter(new Fighter(new Fighter(new Fighter(new Fighter(new Dathormiri())))));
						break;
				}
			}
			else
			{
				switch(specieDesignation)
				{
				case 1:
					enemy = new ForceEnemy(new ForceEnemy(new ForceEnemy(new ForceEnemy(new ForceEnemy(new Geonosian())))));
					break;
				case 2:
					enemy = new ForceEnemy(new ForceEnemy(new ForceEnemy(new ForceEnemy(new ForceEnemy(new Rodian())))));
					break;
				case 3:
					enemy = new ForceEnemy(new ForceEnemy(new ForceEnemy(new ForceEnemy(new ForceEnemy(new Twilek())))));
					break;
					default:
						enemy = new ForceEnemy(new ForceEnemy(new ForceEnemy(new ForceEnemy(new ForceEnemy(new Dathormiri())))));
						break;
				}
			}
			break;
			default:
			switch(specieDesignation)
			{
			case 1:
				//new ForceEnemy(new Geonosian());
				enemy = new Geonosian();
				break;
			case 2:
				enemy = new Rodian();
				break;
			case 3:
				enemy = new Twilek();
				break;
				default:
					enemy = new Dathormiri();
					break;
			}
			break;
				
		}
		return enemy;
	}
}
