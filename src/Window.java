
//Name: Kevin Do
//Created on: 12/3/19
//Last Updated: 11/18/19
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * The Graphic User Interface
 * 
 * @author Kevin
 */
public class Window extends JFrame// implements ActionListener
{
	// staring map level
	int maplevel = 1;
	
	/**
	 * generates the items
	 */
	ItemGenerator itemgenerator = ItemGenerator.getInstance();

	/**
	 * give me an enemy to fight
	 */
	EnemyGenerator enemygenerator = EnemyGenerator.getInstance();

	/**
	 * name of the hero
	 */
	String heroName = new String();

	/**
	 * The Hero himself
	 */
	Hero hero = null;

	/**
	 * the map itself
	 */
	Map map = Map.getInstance();

	/**
	 * Main User Interface
	 */
	private JFrame mainGUI = new JFrame("Star Wars Dungeons - Remastered");

	/**
	 * Before you play,enter the name of your hero
	 */
	private JFrame userName = new JFrame();

	private JFrame emptyField = new JFrame();
	// private JPanel

	/**
	 * Show Character Label
	 */
	private JPanel characterPanel = new JPanel();

	/**
	 * contains the map
	 */
	private JPanel mapPanel = new JPanel();

	/**
	 * Contains all the information about the character
	 */
	private JPanel characterSheet = new JPanel();

	/**
	 * contains their inventory section including label and the grid itself
	 */
	private JPanel inventoryPanel = new JPanel();

	/**
	 * inventory grid
	 */
	private JPanel inventoryGrid = new JPanel();

	/**
	 * Room Information
	 */
	private JPanel situationPanel = new JPanel();

	/**
	 * action panel
	 */
	private JPanel actionPanel = new JPanel();
	// private JLabel

	/**
	 * Display Character Info Title
	 */
	private JLabel charInfoLabel = new JLabel(" Character Information ");

	/**
	 * name label
	 */
	private JLabel nameLabel = new JLabel("Name: ");

	/**
	 * what is our hero's name
	 */
	private JLabel heroNameLabel = new JLabel(" ");

	/**
	 * Health Label
	 */
	private JLabel healthLabel = new JLabel("Health: ");

	/**
	 * ask the player what his/her name is
	 */
	private JLabel heronamequestion = new JLabel("What is your name? ");

	/**
	 * display is current health/max health
	 */
	private JLabel heroHealth = new JLabel();

	/**
	 * level label
	 */
	private JLabel levelLabel = new JLabel("Level: ");

	/**
	 * display current level
	 */
	private JLabel currentlevel = new JLabel();

	/**
	 * situation icon,display the item that is found or the enemy
	 */
	private JLabel situationIcon = new JLabel();

	/**
	 * explain the situation
	 */
	private JLabel situationText = new JLabel();

	/**
	 * Label our Inventory
	 */
	private JLabel inventoryLabel = new JLabel("Inventory");

	/**
	 * Map Room 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25
	 * Legends x row number y column number
	 */
	private JLabel[] room = new JLabel[25];

	/**
	 * action label
	 */
	private JLabel actionLabel = new JLabel("Action");

	// private JButton

	/**
	 * Engage the enemy
	 */
	private JButton beginAttackButton = new JButton("Attack");

	/**
	 * fall back and regroup
	 */
	private JButton retreatButton = new JButton("Retreat");

	/**
	 * use the medkit
	 */
	private JButton useMedkitButton = new JButton("Use Medkit");

	/**
	 * use blaster
	 */
	private JButton useBlasterButton = new JButton("Use Blaster");

	/**
	 * use the force and it open the option for force choke,push and slam
	 */
	private JButton useForceButton = new JButton("Use the Force");

	/**
	 * Choke your enemies with the force
	 */
	private JButton forceChokeButton = new JButton("Force Choke");

	/**
	 * Slam your enemies with the force
	 */
	private JButton forceSlamButton = new JButton("Force Slam");

	/**
	 * Push your enemies with the force
	 */
	private JButton forcePushButton = new JButton("Force Push");

	/**
	 * first 5 inventory slot buttons
	 */

	private JButton[] inventoryslots = new JButton[5];
	
	// enemy image icon
	/**
	 * An Image of a Twi'lek
	 */
	private ImageIcon twilek = new ImageIcon("icons/Twilek_Sith.jpg");

	/**
	 * An Image of a Geonosian
	 */
	private ImageIcon geono = new ImageIcon("icons/Geono.png");

	/**
	 * An Image of a Rodian
	 */
	private ImageIcon rodian = new ImageIcon("icons/Rodian.png");

	/**
	 * An Image of a Dathormiri
	 */
	private ImageIcon datho = new ImageIcon("icons/Datho.png");

	/**
	 * An image of Jar Jar Binks
	 */
	private ImageIcon jarjarbinks = new ImageIcon("icons/jarjarbinks.jpeg");
	// JTextField

	/**
	 * image of a holocron
	 */
	private ImageIcon holocronIcon = new ImageIcon("icons/holocron.png");

	/**
	 * image of a key
	 */
	private ImageIcon keyIcon = new ImageIcon("icons/key.png");

	/**
	 * Image of a medkit
	 */
	private ImageIcon medKitIcon = new ImageIcon("icons/Medkit.png");

	/**
	 * Image of a Helmet
	 */
	private ImageIcon helmetIcon = new ImageIcon("icons/helmet.jpg");
	
	/**
	 * Image of a chest plate
	 */
	private ImageIcon chestPlateIcon = new ImageIcon("icons/chestplate.png");
	
	/**
	 * Image of a shield
	 */
	private ImageIcon shieldIcon = new ImageIcon("icons/shield.jpg");
	
	/***
	 * Input the hero name
	 */
	private JTextField username = new JTextField();

	/**
	 * Determine if we are in combat
	 */
	boolean inCombat = false;
	
	/**
	 * inventory slots
	 */
	int invNum = 0;

	/**
	 * Enemy
	 */
	Enemy enemy = null;


	// Initialize everything

	public Window() {
		userName.setTitle("Star War Dungeon - Remastered Login");
		userName.setBounds(50, 50, 500, 70);
		userName.setResizable(false);
		userName.setLocationRelativeTo(this);
		userName.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		userName.setContentPane(new login());
		userName.setVisible(true);

		mainGUI.setTitle("Star War Dungeon - Remastered");
		mainGUI.setBounds(50, 50, 765, 685);
		mainGUI.setResizable(false);
		mainGUI.setLocationRelativeTo(this);
		mainGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainGUI.setContentPane(new Panel());
		mainGUI.setVisible(false);
	}

	/**
	 * The main Game interface
	 * @author Kevin
	 */
	public class Panel extends JPanel implements ActionListener, KeyListener
	{

		/**
		 * Generate an item for me
		 */
		Item item = ItemGenerator.getInstance().generateItem();
		
		/**
		 * Our GUI interface for the entire game
		*/
		public Panel()// The main Panel
		{
			setLayout(null);
			add(mapPanel);
			add(characterSheet);
			add(characterPanel);
			add(inventoryPanel);
			add(situationPanel);
			add(actionPanel);
			addKeyListener(this);
			setFocusable(true);

			//
			map._loadMap(maplevel);
			hero = new Hero(heroName, map);
			
			// load up the map
			mapPanel.setLayout(new GridLayout(5, 5));
			mapPanel.setBounds(25, 25, 500, 500);
			mapPanel.setBackground(Color.white);
			for (int i = 0; i < room.length; i++)
			{
				room[i] = new JLabel(); // create a new Java Label
				if ((map.findStart().x != (i / 5)) || map.findStart().y != (i % 5))
				{
					room[i].setText("?");
				} else
				{
					room[i].setText("H");
				}
				room[i].setHorizontalAlignment(JLabel.CENTER);
				mapPanel.add(room[i]);
			}

			// Character Panel
			characterPanel.setLayout(new BorderLayout());
			characterPanel.setBounds(530, 25, 200, 50);
			characterPanel.setBackground(Color.white);
			charInfoLabel.setHorizontalAlignment(JLabel.CENTER);
			charInfoLabel.setVerticalAlignment(JLabel.CENTER);
			characterPanel.add(charInfoLabel, BorderLayout.CENTER);

			// Character Info
			characterSheet.setLayout(null);
			// characterSheet.setLayout(new BoxLayout(characterSheet, BoxLayout.Y_AXIS));
			characterSheet.setBounds(530, 80, 200, 100);
			characterSheet.setBackground(Color.white);
			characterSheet.add(nameLabel);
			characterSheet.add(heroNameLabel);
			characterSheet.add(levelLabel);
			characterSheet.add(currentlevel);
			characterSheet.add(healthLabel);
			characterSheet.add(heroHealth);
			nameLabel.setBounds(0, 0, 50, 10);
			heroNameLabel.setBounds(55, 0, 55, 10);
			levelLabel.setBounds(0, 15, 50, 10);
			currentlevel.setBounds(55, 15, 55, 10);
			healthLabel.setBounds(0, 30, 50, 10);
			heroHealth.setBounds(55, 30, 55, 10);

			// Inventory Panel
			inventoryPanel.setLayout(null);
			inventoryPanel.setBounds(530, 185, 200, 250);
			inventoryPanel.setBackground(Color.white);
			inventoryPanel.add(inventoryLabel);
			inventoryPanel.add(inventoryGrid);
			inventoryLabel.setBounds(0, 0, 200, 50);
			inventoryGrid.setBounds(0, 50, 200, 150);
			inventoryGrid.setLayout(new GridLayout(2, 3));
			inventoryGrid.setBackground(Color.white);
			for(int i = 0; i < inventoryslots.length; i++)
			{
				inventoryGrid.add(inventoryslots[i] = new JButton());
				inventoryslots[i].setEnabled(false);
				inventoryslots[i].setIcon(null);
				inventoryslots[i].setHorizontalAlignment(JButton.CENTER);
			}

			inventoryLabel.setHorizontalAlignment(JLabel.CENTER);

			// Situation
			situationPanel.setLayout(null);
			situationPanel.setBounds(25, 530, 500, 100);
			situationPanel.setBackground(Color.white);
			situationPanel.add(situationIcon);
			situationPanel.add(situationText);
			situationIcon.setBounds(0, 0, 100, 100);
			situationText.setBounds(105, 0, 395, 100);
			situationText.setHorizontalAlignment(JLabel.CENTER);
			situationText.setText("<html>You have entered the area" + "<br/>Which Direction do you want to go?"
					+ "<br/> W - North " + "<br/> A - East " + "<br/> S - South" + "<br/> D - West");
			situationIcon.setIcon(jarjarbinks);

			// Decision Section
			actionPanel.setLayout(null);
			actionPanel.setBounds(530, 430, 200, 200);
			actionPanel.setBackground(Color.white);
			actionPanel.add(actionLabel);
			actionPanel.add(beginAttackButton);
			actionPanel.add(retreatButton);
			actionPanel.add(useMedkitButton);
			actionPanel.add(useBlasterButton);
			actionPanel.add(useForceButton);
			actionPanel.add(forceChokeButton);
			actionPanel.add(forcePushButton);
			actionPanel.add(forceSlamButton);
			actionLabel.setBounds(0, 0, 200, 50);
			actionLabel.setHorizontalAlignment(JLabel.CENTER);
			beginAttackButton.setBounds(0, 50, 200, 50);
			retreatButton.setBounds(0, 100, 200, 50);
			useMedkitButton.setBounds(0, 150, 200, 50);
			useBlasterButton.setBounds(0, 50, 200, 50);
			useForceButton.setBounds(0, 100, 200, 50);
			forceChokeButton.setBounds(0, 50, 200, 50);
			forcePushButton.setBounds(0, 100, 200, 50);
			forceSlamButton.setBounds(0, 150, 200, 50);
			for(int i = 0; i < inventoryslots.length; i++)
			{
				inventoryslots[i].addActionListener(this);
			}
			beginAttackButton.addActionListener(this);
			retreatButton.addActionListener(this);
			useMedkitButton.addActionListener(this);
			useBlasterButton.addActionListener(this);
			useForceButton.addActionListener(this);
			forceChokeButton.addActionListener(this);
			forcePushButton.addActionListener(this);
			forceSlamButton.addActionListener(this);
			beginAttackButton.setVisible(false);
			retreatButton.setVisible(false);
			useMedkitButton.setVisible(false);
			useBlasterButton.setVisible(false);
			useForceButton.setVisible(false);
			forceChokeButton.setVisible(false);
			forcePushButton.setVisible(false);
			forceSlamButton.setVisible(false);

		}

		/**
		 * Button we press and what happens when we press *button name
		 * @param e The source of the press
		 */
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			
			/**
			 * how much damage you dealt
			 */
			int heroPrevHP = hero.getHP();

			if (e.getSource() == beginAttackButton)
			{
				if (hero.hasHolocron())
				{
					beginAttackButton.setVisible(false);
					retreatButton.setVisible(false);
					useBlasterButton.setVisible(true);
					useForceButton.setVisible(true);
				} 
				else
				{
					hero.attack(enemy);
					if (enemy.getHP() > 0)
					{
						if (hero.hasArmor())
						{
							absorbDamage();
						} 
						else
						{
							enemydealdmg(heroPrevHP);
						}
					}
					else if (hero.getHP() <= 0) // You died
					{
						situationText.setText("You died!");
						System.exit(0);
					} 
					else // You defeated the enemy
					{
						Victory();
					}
				}

			}

			if (e.getSource() == retreatButton)
			{
				inCombat = false;
				beginAttackButton.setVisible(false);
				retreatButton.setVisible(false);
				useMedkitButton.setVisible(false);
				situationIcon.setIcon(jarjarbinks);
				situationText.setText("<html> You have retreated to a nearby room");
			
				room[(5 * hero.getLocation().x) + hero.getLocation().y].setText(Character.toString(map.getCharAtLoc(hero.getLocation())));
				switch (((int) (Math.random() * 4)) + 1)
				{
				case 1:
					hero.goNorth();
					room[(5 * hero.getLocation().x) + hero.getLocation().y].setText("H");
					break;
				case 2:
					hero.goSouth();
					room[(5 * hero.getLocation().x) + hero.getLocation().y].setText("H");
					break;
				case 3:
					hero.goEast();
					room[(5 * hero.getLocation().x) + hero.getLocation().y].setText("H");
					break;
				case 4:
					hero.goWest();
					room[(5 * hero.getLocation().x) + hero.getLocation().y].setText("H");
					break;
				default:
					hero.goWest();
					room[(5 * hero.getLocation().x) + hero.getLocation().y].setText("H");
					break;
				}
			}

			if (e.getSource() == useMedkitButton)
			{
				hero.removeItem("Med kit");
				hero.heal(5);
				invNum = 0;
				heroHealth.setText(Integer.toString(hero.getHP()) + "/" + Integer.toString(hero.getMaxHP()));
				while(inventoryslots[invNum].getIcon() != medKitIcon && invNum < 4)
				{
					invNum++;
				}
				inventoryslots[invNum].setIcon(null);
				hero.removeItem(invNum);
				if(!hero.hasMedKit())
				{
					useMedkitButton.setVisible(false);
				}
				inventoryreorg();

			}

			if (e.getSource() == useBlasterButton)
			{
				System.out.println("Test");
				hero.attack(enemy);
				if (enemy.getHP() > 0)
				{
					System.out.println("Test");
					if (hero.hasArmor())
					{
						System.out.println("armored");
						absorbDamage();
					} 
					else
					{
						System.out.println("ow");
						enemydealdmg(heroPrevHP);
					}
				}
				else if (hero.getHP() <= 0) // You died
				{
					System.out.println("ded");
					situationText.setText("You died!");
					System.exit(0);
				} 
				else
				{ // You defeated the enemy
					System.out.println("victorious");
					Victory();
				}
			}

			if (e.getSource() == useForceButton)
			{
				useBlasterButton.setVisible(false);
				useForceButton.setVisible(false);
				useMedkitButton.setVisible(false);
				forcePushButton.setVisible(true);
				forceChokeButton.setVisible(true);
				forceSlamButton.setVisible(true);
			}
			//
			// Force Abilities
			//

			if (e.getSource() == forcePushButton)
			{
				invNum = 0;
				hero.removeItem("Holocron");
				enemy.takeDamage(hero.forcePush());
				while(inventoryslots[invNum].getIcon() != holocronIcon && invNum < 4)
				{
					invNum++;
				}
				System.out.println(invNum);
				inventoryslots[invNum].setIcon(null);
				inventoryreorg();
				if (enemy.getHP() > 0)
				{
					if (hero.hasArmor())
					{
						absorbDamage();
					}
					else
					{
						enemydealdmg(heroPrevHP);
					}

					if (!hero.hasHolocron()) 
					{
						forcePushButton.setVisible(false);
						forceChokeButton.setVisible(false);
						forceSlamButton.setVisible(false);
						beginAttackButton.setVisible(true);
						retreatButton.setVisible(true);
					}
				} 
				else if (hero.getHP() <= 0) // You died
				{
					situationText.setText("You died!");
					System.exit(0);
				} 
				else 
				{ // You defeated the enemy
					Victory();
				}

			}

			if (e.getSource() == forceChokeButton)
			{
				invNum = 0;
				hero.removeItem("Holocron");
				enemy.takeDamage(hero.forceChoke());
				while(inventoryslots[invNum].getIcon() != holocronIcon && invNum < 4)
				{
					invNum++;
				}
				System.out.println(invNum);
				inventoryslots[invNum].setIcon(null);
				inventoryreorg();
				if (enemy.getHP() > 0)
				{
					if (hero.hasArmor())
					{
						absorbDamage();
					} 
					else
					{
						enemydealdmg(heroPrevHP);
					}

					if (!hero.hasHolocron()) 
					{
						forcePushButton.setVisible(false);
						forceChokeButton.setVisible(false);
						forceSlamButton.setVisible(false);
						beginAttackButton.setVisible(true);
						retreatButton.setVisible(true);
					}
				} else if (hero.getHP() <= 0) 
				{
					// You died
					situationText.setText("You died!");
					System.exit(0);
				} else
				{ // You defeated the enemy
					Victory();
				}
			}
			if (e.getSource() == forceSlamButton) 
			{
				invNum = 0;
				hero.removeItem("Holocron");
				enemy.takeDamage(hero.forceSlam());
				while(inventoryslots[invNum].getIcon() != holocronIcon && invNum < 4)
				{
					invNum++;
				}
				System.out.println(invNum);
				inventoryslots[invNum].setIcon(null);
				inventoryreorg();
				if (enemy.getHP() > 0) 
				{
					if (hero.hasArmor()) 
					{
						absorbDamage();
					} 
					else
					{
						enemydealdmg(heroPrevHP);
					}

					if (!hero.hasHolocron())
					{
						forcePushButton.setVisible(false);
						forceChokeButton.setVisible(false);
						forceSlamButton.setVisible(false);
						beginAttackButton.setVisible(true);
						retreatButton.setVisible(true);
					}
				} else if (hero.getHP() <= 0)
				{
					// You died
					situationText.setText("You died!");
					System.exit(0);
				}
				else
				{ // You defeated the enemy
					Victory();
				}
			}
			
			if(e.getSource() == inventoryslots[0])
			{
				if(inventoryslots[0].getIcon() != null)
				{
					hero.removeItem(0);
					inventoryslots[0].setIcon(null);
					inventoryreorg();
					addItem();
					item = ItemGenerator.getInstance().generateItem();
					turnOffInvButton();
				}

			}

			if(e.getSource() == inventoryslots[1])
			{
				if(inventoryslots[1].getIcon() != null)
				{
					hero.removeItem(1);
					inventoryslots[1].setIcon(null);
					inventoryreorg();
					addItem();
					item = ItemGenerator.getInstance().generateItem();
					turnOffInvButton();
				}

			}

			if(e.getSource() == inventoryslots[2])
			{
				if(inventoryslots[2].getIcon() != null)
				{
					hero.removeItem(2);
					inventoryslots[2].setIcon(null);
					inventoryreorg();
					addItem();
					item = ItemGenerator.getInstance().generateItem();
					turnOffInvButton();
				}
			}

			if(e.getSource() == inventoryslots[3])
			{
				if(inventoryslots[3].getIcon() != null)
				{
					hero.removeItem(3);
					inventoryslots[3].setIcon(null);
					inventoryreorg();
					addItem();
					item = ItemGenerator.getInstance().generateItem();
					turnOffInvButton();
				}
			}
			
			if(e.getSource() == inventoryslots[4])
			{
				if(inventoryslots[4].getIcon() != null)
				{
					hero.removeItem(4);
					inventoryslots[4].setIcon(null);
					inventoryreorg();
					addItem();
					item = ItemGenerator.getInstance().generateItem();
					turnOffInvButton();
				}
			}
			
			this.requestFocus();
		}

		/**
		 * movements control
		 * 
		 * @param e W/A/S/D or Up/Down/Left/Right
		 */
		@Override
		public void keyPressed(KeyEvent e) // Player Movement is completed
		{
			System.out.println("X");
			/**
			 * If he is not in combat let him travel otherwise,don't do anything
			 */
			if (inCombat == false)
			{
				if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP)
				{
					System.out.println("Y");
					if (hero.getLocation().x > 0)
					{
						if(map.getCharAtLoc(hero.getLocation()) == 'f')
						{
							room[(5 * hero.getLocation().x) + hero.getLocation().y].setText("F");
						}
						else if(map.getCharAtLoc(hero.getLocation()) == 's')
						{
							room[(5 * hero.getLocation().x) + hero.getLocation().y].setText("S");
						}
						else
						{
							room[(5 * hero.getLocation().x) + hero.getLocation().y].setText("C");
						}

						switch (hero.goNorth())
						{
						case 'e':
							enemyEncountered();
							break;
						case 'i':
							itemFound();
							break;
						case 'f':
							loadNextmap();
							break;
						default:
							room[(5 * hero.getLocation().x) + hero.getLocation().y].setText("H");
							if(map.getCharAtLoc(hero.getLocation()) != 'f' || map.getCharAtLoc(hero.getLocation()) != 's' )
							{
								map.removeCharAtLoc(hero.getLocation());
							}
							break;
						}
					}
					else
					{
						notGod();
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT)
				{
					if (hero.getLocation().y > 0) 
					{
						if(map.getCharAtLoc(hero.getLocation()) == 'f')
						{
							room[(5 * hero.getLocation().x) + hero.getLocation().y].setText("F");
						}
						else if(map.getCharAtLoc(hero.getLocation()) == 's')
						{
							room[(5 * hero.getLocation().x) + hero.getLocation().y].setText("S");
						}
						else
						{
							room[(5 * hero.getLocation().x) + hero.getLocation().y].setText("C");
						}
						switch (hero.goWest()) 
						{
						case 'e':
							enemyEncountered();
							break;
						case 'i':
							itemFound();
							break;
						case 'f':
							loadNextmap();
							break;
						default:
							room[(5 * hero.getLocation().x) + hero.getLocation().y].setText("H");
							if(map.getCharAtLoc(hero.getLocation()) != 'f' || map.getCharAtLoc(hero.getLocation()) != 's' )
							{
								map.removeCharAtLoc(hero.getLocation());
							}
							break;
						}
					} 
					else 
					{
						notGod();
					}

				}
				if (e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN) 
				{
					if (hero.getLocation().x < 4)
					{
						if(map.getCharAtLoc(hero.getLocation()) == 'f')
						{
							room[(5 * hero.getLocation().x) + hero.getLocation().y].setText("F");
						}
						else if(map.getCharAtLoc(hero.getLocation()) == 's')
						{
							room[(5 * hero.getLocation().x) + hero.getLocation().y].setText("S");
						}
						else
						{
							room[(5 * hero.getLocation().x) + hero.getLocation().y].setText("C");
						}
						switch (hero.goSouth()) 
						{
						case 'e':
							enemyEncountered();
							break;
						case 'i':
							itemFound();
							break;
						case 'f':
							loadNextmap();
							break;
						default:
							room[(5 * hero.getLocation().x) + hero.getLocation().y].setText("H");
							if(map.getCharAtLoc(hero.getLocation()) != 'f' || map.getCharAtLoc(hero.getLocation()) != 's' )
							{
								map.removeCharAtLoc(hero.getLocation());
							}
							break;
						}
					}
					else 
					{
						notGod();
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) 
				{
					if (hero.getLocation().y < 4)
					{
						
						if(map.getCharAtLoc(hero.getLocation()) == 'f')
						{
							room[(5 * hero.getLocation().x) + hero.getLocation().y].setText("F");
						}
						else if(map.getCharAtLoc(hero.getLocation()) == 's')
						{
							room[(5 * hero.getLocation().x) + hero.getLocation().y].setText("S");
						}
						else
						{
							room[(5 * hero.getLocation().x) + hero.getLocation().y].setText("C");
						}
						
						switch (hero.goEast())
						{
						case 'e':
							enemyEncountered();
							break;
						case 'i':
							itemFound();
							break;
						case 'f':
							loadNextmap();
							break;
						default:
							room[(5 * hero.getLocation().x) + hero.getLocation().y].setText("H");
							if(map.getCharAtLoc(hero.getLocation()) != 'f' || map.getCharAtLoc(hero.getLocation()) != 's' )
							{
								map.removeCharAtLoc(hero.getLocation());
							}
							break;
						}
					} 
					else 
					{
						notGod();
					}
				}
			}
			if (hero.getNuminventory() > 4) 
			{
				if (e.getKeyCode() == KeyEvent.VK_1) 
				{
					if(inventoryslots[0].getIcon() != null)
					{
						hero.removeItem(0);
						inventoryslots[0].setIcon(null);
						inventoryreorg();
						addItem();
						item = ItemGenerator.getInstance().generateItem();
						turnOffInvButton();
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_2) 
				{
					if(inventoryslots[1].getIcon() != null)
					{
						hero.removeItem(1);
						inventoryslots[1].setIcon(null);
						inventoryreorg();
						addItem();
						item = ItemGenerator.getInstance().generateItem();
						turnOffInvButton();
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_3) 
				{
					if(inventoryslots[2].getIcon() != null)
					{
						hero.removeItem(2);
						inventoryslots[2].setIcon(null);
						inventoryreorg();
						addItem();
						item = ItemGenerator.getInstance().generateItem();
						turnOffInvButton();
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_4) 
				{
					if(inventoryslots[3].getIcon() != null)
					{
						hero.removeItem(3);
						inventoryslots[3].setIcon(null);
						inventoryreorg();
						addItem();
						item = ItemGenerator.getInstance().generateItem();
						turnOffInvButton();
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_5)
				{
					if(inventoryslots[4].getIcon() != null)
					{
						hero.removeItem(4);
						inventoryslots[4].setIcon(null);
						inventoryreorg();
						addItem();
						item = ItemGenerator.getInstance().generateItem();
						turnOffInvButton();
					}
				}
			}
		}

		/**
		 * You have encountered an enemy,display the situation
		 */
		public void enemyEncountered()
		{
			room[(5 * hero.getLocation().x) + hero.getLocation().y].setText("H");
			inCombat = true;
			enemy = EnemyGenerator.getInstance().generateEnemy(hero.getLevel());

			situationText.setText("<html>You have encountered a " + enemy.getName() + "<br/>Name: " + enemy.getName()
					+ "<br/>Level: " + enemy.getLevel() + "<br/> HP: " + enemy.getHP() + "/" + enemy.getMaxHP());
			if (enemy.getName().contains("Geonosian"))
			{
				situationIcon.setIcon(geono);
			}

			if (enemy.getName().contains("Rodian"))
			{
				situationIcon.setIcon(rodian);
			}

			if (enemy.getName().contains("Dathormiri"))
			{
				situationIcon.setIcon(datho);
			}

			if (enemy.getName().contains("Twi'lek")) 
			{
				situationIcon.setIcon(twilek);
			}

			beginAttackButton.setVisible(true);
			retreatButton.setVisible(true);
			if (hero.hasMedKit())
			{
				useMedkitButton.setVisible(true);
			}
		}

		/**
		 * Load next map
		 */
		public void loadNextmap()
		{
			room[(5 * hero.getLocation().x) + hero.getLocation().y].setText("H");
			invNum = 0;
			if(hero.hasKey())
			{
				while(inventoryslots[invNum].getIcon() != keyIcon)
				{
					invNum++;
				}
				inventoryslots[invNum].setIcon(null);
				hero.removeItem(invNum);
				maplevel++;
				map._loadMap(maplevel);
				hero.IncreaseLevel();
				hero.increaseMaxHP(10);
				hero.heal(hero.getMaxHP());
				currentlevel.setText(Integer.toString(hero.getLevel()));
				heroHealth.setText(Integer.toString(hero.getHP()) + "/" + Integer.toString(hero.getMaxHP()));
				for (int i = 0; i < room.length; i++) 
				{
					if ((map.findStart().x != (i / 5)) || map.findStart().y != (i % 5)) 
					{	
						room[i].setText("?");
					} 
					else
					{
						room[i].setText("H");
					}
				}
			}
			else if(hero.hasHolocron())
			{
				int chance = (int)(Math.random() * 40);
				if(chance <= 25)
				{
					while(inventoryslots[invNum].getIcon() != holocronIcon && invNum < 4)
					{
						invNum++;
					}
					inventoryslots[invNum].setIcon(null);
					hero.removeItem(invNum);
					maplevel++;
					map._loadMap(maplevel);
					hero.IncreaseLevel();
					hero.increaseMaxHP(10);
					hero.heal(hero.getMaxHP());
					currentlevel.setText(Integer.toString(hero.getLevel()));
					heroHealth.setText(Integer.toString(hero.getHP()) + "/" + Integer.toString(hero.getMaxHP()));
					for (int i = 0; i < room.length; i++) 
					{
						if ((map.findStart().x != (i / 5)) || map.findStart().y != (i % 5)) 
						{	
							room[i].setText("?");
						} 
						else
						{
							room[i].setText("H");
						}
					}
				}
			}
		}

		/**
		 * we found an item
		 */
		public void itemFound()
		{
			System.out.println("Item");
			room[(5 * hero.getLocation().x) + hero.getLocation().y].setText("H");
			System.out.println(hero.getNuminventory());
			item = ItemGenerator.getInstance().generateItem();
			situationText.setText("You have found a " + item.getName());
			if(hero.getNuminventory() < 5)
			{
				hero.pickUpItem(item);
				invNum = 0;
				while (inventoryslots[invNum].getIcon() != null && invNum < 4)
				{
					invNum++;
				}
			
				switch (item.getName())
				{
				case "Holocron":
					inventoryslots[invNum].setIcon(holocronIcon);
					break;
				case "Helmet":
					inventoryslots[invNum].setIcon(helmetIcon);
					break;
				case "Key":
					inventoryslots[invNum].setIcon(keyIcon);
					break;
				case "Shield":
					inventoryslots[invNum].setIcon(shieldIcon);
					break;
				case "Med Kit":
					inventoryslots[invNum].setIcon(medKitIcon);
					break;
				case "Chestplate":
					inventoryslots[invNum].setIcon(chestPlateIcon);
					break;
				}
			}
			else
			{
				situationText.setText("Your inventory is full,please drop an item to retrieve a " + item.getName());
				turnOnInvButton();
			}
			if(hero.getNuminventory() < 5)
			{
				map.removeCharAtLoc(hero.getLocation());
			}
			else
			{
				room[(5 * hero.getLocation().x) + hero.getLocation().y].setText("H");
			}
		}

		/**
		 * You cannot walk outside the map
		 */
		public void notGod()
		{
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(emptyField, "You are not god,you cannot 'walk' outside of the map");
		}
		
		/**
		 * we disable our inventory buttons so we cant drop
		 */
		public void turnOffInvButton()
		{
			for(int i = 0; i < inventoryslots.length; i++)
			{
				inventoryslots[i].setEnabled(false);
			}
		}
		
		/**
		 * add item and update the inventory
		 */
		public void addItem()
		{
			hero.pickUpItem(item);
			invNum = 0;
			while (inventoryslots[invNum].getIcon() != null && invNum < 4)
			{
				invNum++;
			}
		
			switch (item.getName())
			{
			case "Holocron":
				inventoryslots[invNum].setIcon(holocronIcon);
				break;
			case "Helmet":
				inventoryslots[invNum].setIcon(helmetIcon);
				break;
			case "Key":
				inventoryslots[invNum].setIcon(keyIcon);
				break;
			case "Shield":
				inventoryslots[invNum].setIcon(shieldIcon);
				break;
			case "Med Kit":
				inventoryslots[invNum].setIcon(medKitIcon);
				break;
			case "Chestplate":
				inventoryslots[invNum].setIcon(chestPlateIcon);
				break;
			}
		}
		
		/**
		 * turn on the inventory buttons so we can choose which item to drop
		 */
		public void turnOnInvButton()
		{
			for(int i = 0; i < inventoryslots.length; i++)
			{
				inventoryslots[i].setEnabled(true);
			}
		}
		
		/**
		 * You defeated the enemy
		 */
		public void Victory()
		{
			map.removeCharAtLoc(hero.getLocation());
			item = ItemGenerator.getInstance().generateItem();
			situationText.setText("<html>You have defeated " + enemy.getName()
					+ " and retrieved the following item: <br/>" + item.getName());
			
			inCombat = false;
			beginAttackButton.setVisible(false);
			retreatButton.setVisible(false);
			useMedkitButton.setVisible(false);
			useBlasterButton.setVisible(false);
			useForceButton.setVisible(false);
			forcePushButton.setVisible(false);
			forceChokeButton.setVisible(false);
			forceSlamButton.setVisible(false);
			situationIcon.setIcon(jarjarbinks);
			if(hero.getNuminventory() < 5)
			{
				hero.pickUpItem(item);
				invNum = 0;
				while (inventoryslots[invNum].getIcon() != null && invNum < 4)
				{
					invNum++;
				}
			
				switch (item.getName())
				{
				case "Holocron":
					inventoryslots[invNum].setIcon(holocronIcon);
					break;
				case "Helmet":
					inventoryslots[invNum].setIcon(helmetIcon);
					break;
				case "Key":
					inventoryslots[invNum].setIcon(keyIcon);
					break;
				case "Shield":
					inventoryslots[invNum].setIcon(shieldIcon);
					break;
				case "Med Kit":
					inventoryslots[invNum].setIcon(medKitIcon);
					break;
				case "Chestplate":
					inventoryslots[invNum].setIcon(chestPlateIcon);
					break;
				}
			}
			else
			{
				situationText.setText("Your inventory is full,please drop an item to get " + item.getName());
				turnOnInvButton();
			}
		}
		
		/**
		 * Enemy dealt some damage
		 * @param heroprevHP hero previous hp
		 * @param enemyprevhp enemy previous hp
		 */
		public void enemydealdmg(int heroprevHP)
		{

			enemy.attack(hero);
			if(enemy.getHP() > 0)
			{
				situationText.setText(
					"<html> You dealt some damage to " + enemy.getName()
							+ "<br/> The " + enemy.getName() + " deal " + (heroprevHP - hero.getHP())
							+ " damage to you" + "<br/> Name: " + enemy.getName() + "<br/>Level: "
							+ enemy.getLevel() + "<br/>   HP: " + enemy.getHP() + "/" + enemy.getMaxHP());
				heroHealth.setText(Integer.toString(hero.getHP()) + "/" + Integer.toString(hero.getMaxHP()));
			}
		}
		
		
		/**
		 * reorganize our inventory
		 */
		public void inventoryreorg()
		{
			int num = 0;
			while(inventoryslots[num].getIcon() != null)
			{
				num++;
			}
			for( ; num < inventoryslots.length - 1;num++)
			{
				inventoryslots[num].setIcon(inventoryslots[num + 1].getIcon()); 
				inventoryslots[num + 1].setIcon(null);
			}
		}
		
		/**
		 * The armor absorb the damage
		 * @param enemyprevHP enemy previous hitpoints
		 */
		public void absorbDamage()
		{
			situationText.setText("<html> You some damage damage to "
					+ enemy.getName() + "<br/>The enemy attack but your " + hero.RemoveFirstArmorItem()
					+ " absorb the damage and is destroyed" + "<br/>Name: " + enemy.getName()
					+ "<br/>Level: " + enemy.getLevel() + "<br/> HP: " + enemy.getHP() + "/"
					+ enemy.getMaxHP());
			invNum = 0;
			switch(hero.RemoveFirstArmorItem())
			{
			case "Helmet":
				while(inventoryslots[invNum].getIcon() != helmetIcon)
				{
					invNum++;
				}
				inventoryslots[invNum].setIcon(null);
				break;
			case"Shield":
				while(inventoryslots[invNum].getIcon() != shieldIcon)
				{
					invNum++;
				}
				inventoryslots[invNum].setIcon(null);
				break;
			case "Chestplate":
				while(inventoryslots[invNum].getIcon() != chestPlateIcon)
				{
					invNum++;
				}
				inventoryslots[invNum].setIcon(null);
				break;
				default:
					break;
			}
			hero.removeItem(hero.RemoveFirstArmorItem());
			inventoryreorg();
		}
		
		/**
		 * When key is released,not used
		 * @param e the key
		 */
		@Override
		public void keyReleased(KeyEvent e) 
		{
		}

		/**
		 * When key is released,not used
		 * @param e the key
		 */
		@Override
		public void keyTyped(KeyEvent e)
		{
		}
	}

	/**
	 * user input their name first for game to start
	 * @author Kevin
	 */
	public class login extends JPanel implements ActionListener 
	{
		public login()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			add(heronamequestion);
			add(username);
			username.addActionListener(this);

		}

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if (e.getSource() == username)
			{
				if (!username.getText().isEmpty())
				{
					heroName = username.getText();
					heroNameLabel.setText(heroName);
					currentlevel.setText(Integer.toString(hero.getLevel()));
					heroHealth.setText(Integer.toString(hero.getHP()) + "/" + Integer.toString(hero.getMaxHP()));
					mainGUI.setVisible(true);
					userName.setVisible(false);
				}
				else 
				{
					Toolkit.getDefaultToolkit().beep();
					JOptionPane.showMessageDialog(emptyField, "Your hero must have a name");
				}
			}
		}
	}
}
