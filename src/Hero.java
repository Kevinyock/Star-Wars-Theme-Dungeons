import java.util.ArrayList;

//Name:Kevin Do
//Last Update:12/1/2019
//Date Created:9/2/2019
/**
 * The hero itself
 * 
 * @author Kevin
 */
public class Hero extends Entity implements Force {

	// Private Data Type
	/**
	 * hero's inventory
	 */
	private ArrayList<Item> inventory = new ArrayList<Item>();

	/**
	 * the map itself
	 */
	private Map map = Map.getInstance();

	/**
	 * player location
	 */
	private Point location;
	// Public Function

	/**
	 * Hero Constructor
	 * 
	 * @param n heros name
	 * @param m the map
	 */
	public Hero(String n, Map m) {
		super(n, 1, 10);
		map = m;
		location = map.findStart();
		map.reveal(location);
	}

	/**
	 * @param e Our Hero attacks and deal a random amount of damage
	 */
	public void attack(Entity e) {
	
			int damage = ((int) (Math.random() * 4)) * super.getLevel();
			e.takeDamage(damage);
			System.out.println(this.getName() + " use blaster and deal " + (damage) + " to " + e.getName());
	}

	/**
	 * This displays our hero information
	 */
	public void display() {
		super.display();
		if (!inventory.isEmpty()) {
			System.out.println("Inventory:");
		}
		map.displayMap(location);
	}

	public void displayinventory() {
		for (int i = 0; i < inventory.size(); i++) {
			System.out.println((i + 1) + "." + inventory.get(i).getName());
		}
	}

	/**
	 * The size of our Inventory
	 * 
	 * @return the size of our inventory
	 */
	public int getNuminventory() {
		return inventory.size();
	}

	/**
	 * Remove the item based on the name the user want to remove
	 * 
	 * @param n name of our item
	 */
	public void removeItem(String n) {
		for (int i = 0; i < inventory.size(); i++) {
			Item removedItem = inventory.get(i);
			if (removedItem.getName().equals(n)) {
				inventory.remove(removedItem);
			}
		}
	}

	/**
	 * remove the item in the inventory slot
	 * 
	 * @param index the inventory number
	 */
	public void removeItem(int index) {
		if (inventory.get(index) != null) {
			inventory.remove(index);
		} else {
			System.out.println("You do not have this item");
		}
	}

	/**
	 * pick up the loot
	 * 
	 * @param i inventory
	 * @return true: we pick it up false:we don't and leave it there
	 */
	public boolean pickUpItem(Item i) {

		if (inventory.size() < 5) {
			inventory.add(i);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Do we have a medkit or not
	 * 
	 * @return open an option to heal ourself
	 */
	public boolean hasMedKit() // Not detecting item
	{
		for (Item inventory : inventory) {
			if (inventory.getName().equals("Med Kit")) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Do we have holocron,if we do we can do force abilities
	 * 
	 * @return true/false and decide if we get do force abilities
	 */
	public boolean hasHolocron() {
		for (Item inventory : inventory) {
			if (inventory.getName().equals("Holocron")) {
				return true;
			}
		}
		return false;
	}

	/**
	 * If we have the key then we can leave the room
	 * 
	 * @return if we have the key or not
	 */
	public boolean hasKey() {
		for (Item inventory : inventory) {
			if (inventory.getName().equals("Key")) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Check if we have armor on when we were fighting the enemy
	 * 
	 * @return if we have armor or not
	 */
	public boolean hasArmor() {
		for (Item inventory : inventory) {
			if (inventory.getName().equals("Helmet") || inventory.getName().equals("Shield")
					|| inventory.getName().equals("Chestplate")) {
				return true;
			}
		}
		return false;
	}

	/**
	 * The hero position
	 * 
	 * @return the hero current position
	 */
	public Point getLocation() {
		return location;
	}

	/**
	 * We move north with great purpose
	 * 
	 * @return the symbol of the room north of us
	 */
	public char goNorth() {
		try {
			location.x--;
			map.reveal(location);
		} catch (ArrayIndexOutOfBoundsException ab) {
			System.out.println("You are not god,you cannot 'walk' outside of the map");
			return map.getCharAtLoc(location);
		}
		return map.getCharAtLoc(location);
	}

	/**
	 * We move south of our position
	 * 
	 * @return the symbol of the room
	 */
	public char goSouth() {
		try {
			location.x++;
			map.reveal(location);
		} catch (ArrayIndexOutOfBoundsException ab) {
			location.x--;
			System.out.println("You are not god,you cannot 'walk' outside of the map");
			return map.getCharAtLoc(location);
		}
		return map.getCharAtLoc(location);

	}

	/**
	 * We head east of our position
	 * 
	 * @return the symbol of the room
	 */
	public char goEast() {
		try {
			location.y++;
			map.reveal(location);
		} catch (ArrayIndexOutOfBoundsException ab) {
			location.y--;
			System.out.println("You are not god,you cannot 'walk' outside of the map");
			return map.getCharAtLoc(location);
		}
		return map.getCharAtLoc(location);
	}

	/**
	 * we head west of our position
	 * 
	 * @return the symbol of the room
	 */
	public char goWest() {
		try {
			location.y--;
			map.reveal(location);
		} catch (ArrayIndexOutOfBoundsException ab) {
			location.y++;
			System.out.println("You are not god,you cannot 'walk' outside of the map");
			return map.getCharAtLoc(location);
		}
		return map.getCharAtLoc(location);
	}

	/**
	 * Remove the first armor
	 * 
	 * @return The string of the first armor we found
	 */
	public String RemoveFirstArmorItem() {
		String firstArmor = new String();
		for (Item _inventory : inventory) {
			if (_inventory.getName().equals("Helmet") || _inventory.getName().equals("Shield")
					|| _inventory.getName().equals("Chestplate")) {
				firstArmor = _inventory.getName();
			}
		}
		return firstArmor;
	}

	// Force Abilities
	/**
	 * force push does 0 to 10 damage * hero level
	 */
	@Override
	public int forcePush() {
		return ((int) (Math.random() * 5)) * super.getLevel();
	}

	/**
	 * force choke our enemies with snapping effect
	 */
	@Override
	public int forceChoke() {
		return ((int) (Math.random() * 10)) * super.getLevel();
	}

	/**
	 * Slam our enemy with devastating effect
	 */
	@Override
	public int forceSlam() {
		return ((int) (Math.random() * 15)) * super.getLevel(); // forceSlam does 15 damage
	}

}