import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Main 
{
        public static void main(String[] args) 
                {
                        Scanner scnr = new Scanner(System.in);

                        Player mainChar = new Player();

                        createCharacter(mainChar, scnr);
                        runPrologue(mainChar);

                        continueGame(scnr);

                        runChapter1(mainChar, scnr);

                        continueGame(scnr);

                        runChapter2(mainChar, scnr);

                        continueGame(scnr);

                        runChapter3(mainChar, scnr);

                        continueGame(scnr);

                        runChapter4(mainChar, scnr);

                        System.out.println("To Be Continued...");

                        scnr.close();
                }
        

        //This is the player class. It defines variables for the player, as well as constructors for both a standard/neutral character and a custom player character.
        public static class Player 
                {
                        String name;
                        String proSubj;
                        String proObj;
                        String proPossAdj;
                        int age;
                        int gold;
                        String weapon;
                        String attribute;
                        String[] inventory = new String[5]; 
                        String motivation;
                        public int health = 50;
                        
                        public Player()
                                {
                                        name = "Stala";
                                        proSubj = "they";
                                        proObj = "them";
                                        proPossAdj = "their";
                                        age = 23;
                                        gold = 15;
                                        weapon = "revolver";
                                        attribute = "charisma";
                                        motivation = "justice";

                                        inventory[0] = "bag of gold";
                                        inventory[1] = "5 rations";
                                        inventory[2] = weapon;
                                        inventory[3] = "empty";
                                        inventory[4] = "empty";
                                }

                        public Player(String name, String proSubj, String proObj, String proPossAdj, int age, int gold, String weapon, String attribute, String motivation)
                                {
                                        this.name = name;
                                        this.proSubj = proSubj;
                                        this.proObj = proObj;
                                        this.proPossAdj = proPossAdj;
                                        this.age = age;
                                        this.gold = gold;
                                        this.weapon = weapon;
                                        this.attribute = attribute;
                                        this.motivation = motivation;

                                        inventory[0] = "bag of gold";
                                        inventory[1] = "5 rations";
                                        inventory[2] = this.weapon;
                                        inventory[3] = "empty";
                                        inventory[4] = "empty";
                                }

                        //this method prints each inventory item name to the console
                        public void printInventory(Player player)
                        {
                                System.out.println("Current inventory: ");

                                for (String inventoryItem : player.inventory)
                                {
                                        System.out.println(inventoryItem);
                                }
                        
                        }

                        // this method takes a slot number (1-5) as a parameter and will print what is in that slot in the player's inventory
                        public void printInventory(Player player, int slot)
                                {
                                if (slot<inventory.length + 1 && slot>0)
                                {
                                        System.out.println("Inventory item in slot " + slot + ": " + inventory[slot - 1]);
                                }
                                else
                                {
                                        System.out.println("Valid inventory slots are slots 1 through 5.");
                                }
                        
                        }

                        //this method allows the player to attack an enemy using their weapon of choice, and returns a damage value for damaging the enemy.
                        public void playerAttack(Player player, Enemy enemy)
                                {
                                        int attackDamage = returnRandom(2, 5); 
                                        enemy.health -= attackDamage;

                                        if (player.weapon.equals("sword"))
                                        {
                                                System.out.println(player.name + " swings " + player.proPossAdj + " " + player.weapon + ", dealing " + attackDamage + " points of damage to the " + enemy + ".");
                                        }

                                        if (player.weapon.equals("bow"))
                                        {
                                                System.out.println(player.name + " aims " + player.proPossAdj + " " + player.weapon + " and pierces the " + enemy + " with an arrow, dealing " + attackDamage + " points of damage.");
                                        }

                                        if (player.weapon.equals("revolver"))
                                        {
                                                System.out.println(player.name + " aims " + player.proPossAdj + " " + player.weapon + " and fires a bullet at the " + enemy + ", dealing " + attackDamage + " points of damage.");
                                        }
                                        
                                }

                        public void playerHeal(Player player)
                                {
                                        if (player.health == 50)
                                        {
                                                System.out.println(player.name + " is at full health.");
                                        }

                                        if (player.health < 50)
                                        {
                                                int amountToHeal = returnRandom(3, 6);
                                                player.health += amountToHeal;

                                                if (player.health > 50)
                                                {
                                                        player.health = 50;
                                                }

                                                System.out.println(player.name + " draws magical energy from " + player.proPossAdj + " surroundings, and heals for " + amountToHeal + " points.");

                                                displayHealth(player);
                                        }
                                }

                        public void displayHealth(Player player)
                                {
                                        System.out.println(player.name + " has " + player.health + "/50 health points.");
                                }

                }

        //This method gets all the information needed to create the player's character, and then sets a character object's fields.
        public static void createCharacter(Player player, Scanner in)
                {
                        System.out.print("Enter your character's name: ");
                        player.name = in.nextLine();

                        System.out.print("Choose a pronoun subject (he/she/they): ");
                        player.proSubj = in.next().toLowerCase();         // e.g., he / she / they

                        System.out.print("Choose a pronoun object (him/her/them): ");
                        player.proObj = in.next().toLowerCase();          // e.g., him / her / them

                        System.out.print("Choose a possessive adjective (his/her/their): ");
                        player.proPossAdj = in.next().toLowerCase();      // e.g., his / her / their

                        System.out.print("Enter your character's age: ");
                        player.age = in.nextInt();
                        
                        // --- Determining how much gold the character has with them ---
                        System.out.print("Enter a whole number between 10 and 30: ");
                        player.gold = in.nextInt();

                        // --- Collecting more character info, focusing on proficiencies/personality ---
                        System.out.print("Choose one weapon (sword/bow/revolver): ");
                        player.weapon = in.next().toLowerCase();

                        System.out.print("Choose one attribute (strength/charisma/wit): ");
                        player.attribute = in.next().toLowerCase();
                        
                }
        
        //This method will return a random number using two ints as parameters that define the min and max number can be.
        public static int returnRandom(int min, int max)
                {
                        Random random = new Random();
                        int randomNum;

                        randomNum = random.nextInt(max - min + 1) + min;

                        return randomNum;
                }        

        //What it says on the tin-game over.
        public static void gameOver()
                {
                        System.out.println("GAME OVER");
                        System.exit(0);
                }

        
        //This method returns true if the player enters 'y' and false if the player enters anything else
        public static boolean yesNo(Scanner in)
                {
                        char choice = in.next().charAt(0);

                        if (choice == 'y')
                                {
                                        return true;
                                }
                        else
                                {
                                        return false;
                                }
                }


        //All this method does is pause the game until the player inputs a 'y' character and chooses to continue the game. It is currently impractical, but could potentially be expanded into a save/continue method later.
        public static void continueGame(Scanner in)
                {
                        System.out.print("Continue playing? (y/n): ");

                        while (!yesNo(in))
                                {
                                        System.out.print("Continue playing? (y/n): ");
                                        yesNo(in);
                                }
                }
        
        //This abstract class lays the framework for what methods and variables a generic enemy object should have.
        public static abstract class Enemy 
                {
                        int health;
                        String name;

                        public abstract void attack(Player player);
                }
        
        //The wolf class defines behaviors specific to an enemy type of Wolf.
        public static class Wolf extends Enemy
                {
                        int health;
                        String name;

                        public Wolf()
                        {
                                health = 7;
                                name = "wolf";
                        }
                        
                        public void attack(Player player)
                                {
                                        int attackDamage = returnRandom(1, 4);
                                        int attackType = returnRandom(1, 2);

                                        if (attackType == 1)
                                        {
                                                System.out.println("The wolf lashes out with its claws, dealing " + attackDamage + " points of damage to " + player.name + ".");
                                        }

                                        if (attackType == 2)
                                        {
                                                System.out.println("The wolf lunges to bite " + player.name + ", dealing " + attackDamage + " points of damage.");
                                        }

                                        player.health -= attackDamage;
                                }
                }

        //The bandit class defines behaviors specific to an enemy type of bandit.
        public static class Bandit extends Enemy
                {
                        int health;
                        String name;

                        public Bandit()
                        {
                                health = 10;
                                name = "bandit";
                        }
                        
                        public void attack(Player player)
                                {
                                        int attackDamage = returnRandom(2, 5);
                                        int attackType = returnRandom(1, 2);

                                        if (attackType == 1)
                                        {
                                                System.out.println("The bandit bludgeons " + player.name + " with their quarterstaff, dealing " + attackDamage + " points of damage to " + player.name + ".");
                                        }

                                        if (attackType == 2)
                                        {
                                                System.out.println("The bandit slashes with their knife, dealing " + attackDamage + " points of damage to " + player.name + ".");
                                        }

                                        player.health -= attackDamage;
                                }
                }
        
        //The spellcaster class defines behaviors specific to an enemy type of spellcaster.
        public static class Spellcaster extends Enemy
                {
                        int health;
                        String name;

                        public Spellcaster()
                        {
                                health = 15;
                                name = "spellcaster";
                        }
                        
                        public void attack(Player player)
                                {
                                        int attackDamage = returnRandom(4, 10);
                                        int attackType = returnRandom(1, 2);

                                        if (attackType == 1)
                                        {
                                                System.out.println("The spellcaster shouts an incantation that causes " + player.name + " to take " + attackDamage + " points of magical damage.");
                                        }

                                        if (attackType == 2)
                                        {
                                                System.out.println("The spellcaster waves their hands in an arc in the air, causing " + player.name + " to take " + attackDamage + " points of magical damage.");
                                        }

                                        player.health -= attackDamage;
                                }
                }
        
        //This method can be called to begin and complete an encounter with different types and numbers of enemies.
        public static void EnemyEncounter(Player player, Scanner in, ArrayList<Enemy> enemyList)
                {
                        int round = 1; 

                        System.out.println(player.name + " has entered an encounter. There are " + enemyList.size() + " enemies, of the following types:");

                         for (Enemy enemy : enemyList)
                                {
                                        System.out.println(enemy.name + ": " + enemy.health + " health");
                                }
                
                        System.out.println("Each player turn, " + player.name + " may either attack an enemy or heal " + player.proObj + "self. Then, the enemies will take their turn.");

                        while (enemyList.size() > 0)
                        {
                                System.out.println("Begin round " + round + ":");
                                System.out.println("Enemy status:");

                                for (Enemy enemy : enemyList)
                                {
                                        System.out.println(enemy.name + ": " + enemy.health + " health");
                                }

                                player.displayHealth(player);
                                System.out.println("Should " + player.name + " attack or heal? (attack/heal):");
                                String choice = in.next();

                                if (choice.equals("attack"))
                                {
                                        System.out.println("Which enemy should " + player.name + " attack? Valid responses are 1-" + enemyList.size());
                                        int enemyToAttack = in.nextInt() - 1;
                                        player.playerAttack(player, enemyList.get(enemyToAttack));
                                        
                                        if (enemyList.get(enemyToAttack).health <= 0)
                                        {
                                                enemyList.remove(enemyToAttack);
                                        }

                                        if (enemyList.size() < 1)
                                        {
                                                break;
                                        }
                                }
                                else if (choice.equals("heal"))
                                {
                                        player.playerHeal(player);
                                }
                                else
                                {
                                        System.out.println("Invalid response.");
                                        continue;
                                }

                                if (enemyList.size() == 0)
                                {
                                        break;
                                }

                                int attackingEnemy = returnRandom(0, enemyList.size());

                                System.out.println("Enemy " + (attackingEnemy + 1) + " takes a turn.");

                                enemyList.get(attackingEnemy).attack(player);

                                if (player.health <= 0)
                                {
                                        System.out.println(player.name + "'s health has been depleted.");
                                        gameOver();
                                        break;
                                }
                                else
                                {
                                        System.out.println("End round " + round + ".");
                                        round++;
                                        continue;
                                }
                        }

                        System.out.println("Encounter completed.");
                }


        //This method prints to console the first part of the story, using Player player's fields.
        public static void runPrologue(Player player) 
                {
                        System.out.println();
                        System.out.println("~ ~ ~ Adventure Prologue ~ ~ ~");
                        System.out.println(player.name + " set out at dawn, " + player.proPossAdj + " pack light and hopes high.");
                        System.out.println("At only " + player.age + " years old, " + player.proSubj + " already carried stories that most would never dare to tell.");
                        System.out.println("In the pouch at " + player.proPossAdj + " side clinked " + player.gold + " gold coins..."
                                + "not much, but more than enough for bread and a bed in a quiet inn.");
                        System.out.println("A weathered sign pointed toward the Whispering Woods, and " + player.proSubj
                                + " felt a shiver that had nothing to do with the cold.");
                        System.out.println("Whatever waited beyond the treeline would test " + player.proObj + ", but " + player.name
                                + " walked on without looking back.");
                }

        //This method both gets some variables from the player and prints them in the story. These variables should not be needed in the future, so it is fine to keep them local to the method.
        public static void runChapter1(Player player, Scanner in) 
                {
                        System.out.println();
                        System.out.print("What is the name of " + player.name + "'s hometown?: ");
                        String hometown = in.next();

                        System.out.print("How many years has it been since " + player.proSubj + " left home to explore?: ");
                        int exploreExp = in.nextInt();

                        System.out.print("Enter another character's name: ");
                        String mentor = in.next();

                        System.out.print("How old is this new character?: ");
                        int mentorAge = in.nextInt();
                        mentorAge = mentorAge * 100;

                        System.out.print("Enter the name of a season (winter/spring/summer/fall): ");
                        String season = in.next().toLowerCase();

                        System.out.print("Enter the name of a color: ");
                        String color1 = in.next().toLowerCase();

                        System.out.print("Enter the name of another color: ");
                        String color2 = in.next().toLowerCase();

                        System.out.println("~ ~ ~ The Adventure Begins ~ ~ ~");
                        System.out.println(player.name + " entered the Whispering Woods, taking the dirt path marked on " + player.proPossAdj + " map.");
                        System.out.println("As " + player.proSubj + " walked, " + player.proSubj + " couldn't help but feel a bit wistful for home.");
                        System.out.println("It had been more than " + exploreExp + " years since " + player.proSubj + " had left " + hometown + "."); 
                        System.out.println("But, for as much as " + player.name + " missed " + player.proPossAdj + " loved ones, " + player.proSubj + " knew that the journey would be worth it in the end.");
                        System.out.println("Besides..." + player.proSubj + " had been prepared, when they left. " + player.name + " smiled fondly, remembering the kind smile and lessons that "
                                + mentor + " had taught " + player.proObj + ".");
                        System.out.println("Heck, if a " + mentorAge + " year old wizard could believe in " + player.proPossAdj + " " + player.attribute 
                                + " in a bind, then surely there was nothing to fear.");
                        System.out.println(player.name + " idly ran a hand over " + player.proPossAdj + " " + player.weapon + " with a soft sigh. Well, there was always that, too.");
                        System.out.println("The chill from before nearly gone, " + player.proSubj + " marched along the path with renewed vigor and confidence.");
                        System.out.println();

                        System.out.println(player.name + " had been walking for many hours through the Whispering Woods, admiring the beauty of the forest during the "
                                + season + ", when " + player.proSubj + " noticed that something...wasn't quite right.");
                        System.out.println(player.proSubj + " looked skyward and noticed that the brilliant " + color1 + " of the daytime sky had almost entirely faded into the "
                                + color2 + " of night.");
                        System.out.println("Had " + player.proSubj + " really been walking for that long?? According to the map, " + player.proSubj + " definitely should have found the next town by now.");
                        System.out.println("Nervous, " + player.proSubj + " opened up " + player.proPossAdj + " map.");
                        System.out.println("To be lost in the Whispering Woods was a very bad thing...a position that nobody in their right mind wanted to find themselves in.");
                        System.out.println("A sudden SNAP caused " + player.name + " to turn around abruptly. " + player.proSubj + " instinctually reached for " + player.proPossAdj + " " + player.weapon + "."); 

                }

        //This method will run Chapter 2, and it includes various if statements and loops to add more player choice into the mix.
        public static void runChapter2(Player player, Scanner in)
                {
                        System.out.println("~ ~ ~ Chapter One ~ ~ ~");
                        System.out.println(player.name + " was suddenly staring at a creature unlike any that " + player.proSubj + "'d ever encountered before."); 
                        System.out.println("There, standing on its hind legs and sharp teeth bared, was a large and feathered serpent. " + player.proSubj + " knew that " + player.proSubj + " needed to act fast.");

                        // player's first (y/n) choice
                        System.out.print("Does " + player.name + " approach the creature? (y/n): ");

                        boolean stolenFrom = false;

                        if (yesNo(in))
                                {
                                        System.out.println("The creature before " + player.proObj + " looked to be just as startled as " + player.proSubj + " were.");
                                        System.out.println(player.name + " took a slow, cautious step forward, " + player.proPossAdj + " grip on " + player.proPossAdj + " " + player.weapon + " slackening slightly.");
                                        System.out.println("The serpent was 3 good paces away, but " + player.name + " continued on with slow, cautious steps.");
                                        
                                        System.out.println(player.proSubj + " stopped just one pace away from the beast. Both the creature and " + player.name + " were trembling.");
                                        
                                        System.out.println("The beast bristled, its dark black eyes flicking between the " + player.weapon + " and " + player.name + "'s face.");
                                        System.out.println("As " + player.proSubj + " continued stand still, " + player.proSubj + " noticed the creature was gripping something in its claws. Slowly, cautiously, the serpent opened its hand to reveal its contents.");

                                        System.out.print(player.name + " felt uneasy...should " + player.proSubj + " stay and see what the creature has for them? (y/n): ");
                                        

                                        if (yesNo(in))
                                                {
                                                        System.out.println(player.proSubj + " decided to stick around and see what the serpent was holding. " + player.proSubj + " stopped in front of the beast and waited.");
                                                        System.out.println("In its hand, outstretched in offering, were 3 golden coins. " + player.name + " furrowed " + player.proPossAdj + " brows, but took the coins despite the confusion.");
                                                        System.out.println(player.proSubj + " settled the coins into " + player.proPossAdj + " pouch, and noticed with bewilderment that 3 of their coins had been missing. Was this creature returning them?");
                                                        System.out.println("Before " + player.name + " got the chance to thank " + player.proPossAdj + " newfound friend, there was a shout in the distance.");
                                                        System.out.println("The beast jumped before it quickly ran away on all fours.");
                                                }
                                        else
                                                {
                                                        System.out.println(player.name + " decided to err on the side of caution, and backed away from the creature. It seemed to deflate at this.");
                                                        System.out.println("But before " + player.proSubj + " could rethink " + player.proPossAdj + " decision, there was a loud shout in the distance.");
                                                        System.out.println("The beast fled.");

                                                        player.gold = player.gold - 3;
                                                        stolenFrom = true;
                                                }
                                }
                        else
                                {
                                        System.out.println(player.name + " decided that whatever this creature was, it wasn't worth the risk finding out. It was late and " + player.proSubj + " really needed to get to the next town before it became necessary to sleep in the woods.");
                                        System.out.println(player.proSubj + " slowly backed away from the feathered serpent. It seemed to deflate at this.");
                                        System.out.println("But before " + player.proSubj + " could rethink " + player.proPossAdj + " decision, there was a loud shout in the distance.");
                                        System.out.println("The beast fled."); 

                                        player.gold = player.gold - 3;
                                        stolenFrom = true;
                                }                              
                                
                        System.out.println("A shout like that in the Whispering Woods at this hour could only mean trouble...but at the same time, " + player.name + " was lost, alone, and growing increasingly nervous.");
                        System.out.println(player.proSubj + " decided that following the voice was " + player.proPossAdj + " best shot at getting out of the woods. Whoever was in danger would surely be of help were they to be rescued.");
                        System.out.println("With no better plan in mind, " + player.name + " set off in the direction they heard the shout come from.");

                        

                        System.out.println(player.name + "soon came upon a clearing with 3 ravenous wolves snarling at " + player.proObj + ". Lying dead at the wolves' feet was a young man.");
                        System.out.println(player.proSubj + " knew there was no chance of outrunning the wolves..." + player.proSubj + " were going to have to fight. " + player.proSubj + " drew " + player.proPossAdj + " " + player.weapon + ".");

                        ArrayList<Enemy> wolfPack = new ArrayList<Enemy>();
                        Enemy wolf1 = new Wolf();
                        Enemy wolf2 = new Wolf();
                        Enemy wolf3 = new Wolf();
                        wolfPack.add(wolf1);
                        wolfPack.add(wolf2);
                        wolfPack.add(wolf3);
                        EnemyEncounter(player, in, wolfPack);


                        System.out.println("After what seemed like an eternity, " + player.name + " finally felled the last wolf. " + player.proSubj + " could not believe " + player.proPossAdj + " luck.");
                        System.out.println("Before " + player.proObj + " lay the body of a young man who had not been so lucky. " + player.name + " gently closed the man's eyes before " + player.proSubj + " looked around.");
                        System.out.println("To " + player.proPossAdj + " astonishment, following the poor man's shout seemed to have led " + player.proSubj + " right back onto the right path.");
                        System.out.println(player.proSubj + " whispered a thank you to the man, but knew that " + player.proSubj + " could not linger in the woods any longer.");
                        System.out.println(player.proSubj + ", exhausted and with a heavy heart, finally trudged the last half mile or so out of the forest.");

                        System.out.println(player.proSubj + " emerged into the next town with a sigh of relief. " + player.proSubj + " immediately made a beeline for the nearest tavern.");
                        System.out.println("Despite the late hour, the inside of inn was bustling with people when " + player.name + " entered it. It seemed the first floor served as a lively bar. Considering the small size of the town, " + player.proSubj + " supposed that made sense.");
                        System.out.println(player.proSubj + " inquired about a room. A private room cost 3 coins per night.");

                        if (stolenFrom)
                                {
                                        System.out.println(player.proSubj + " reached into " + player.proPossAdj + " coin purse to pay and noticed that some of " + player.proPossAdj + " golden coins had seemed to vanish.");
                                        System.out.println("Disbelieving, " + player.proSubj + " counted them one by one.");

                                        for (int i = 1; i <= player.gold; ++i)
                                        {
                                                System.out.print(i + ", ");
                                        }

                                        System.out.println();
                                        System.out.println("Somehow short 3 coins, " + player.name + " frowned as they handed over 3 more precious coins to the tavernkeep.");
                                }
                        else
                        {
                        System.out.println(player.name + " handed over 3 coins to the tavernkeep, grateful that " + player.proSubj + " had risked approaching the creature earlier.");
                        }

                        System.out.println("Finally, after an exhausting and troublesome day, " + player.name + " settled into " + player.proPossAdj + " room for the night.");
                        System.out.println("Before sleeping, however, " + player.proSubj + " decided that perhaps " + player.proSubj + " should check " + player.proPossAdj + " bag to be sure everything was still there.");
                        System.out.println("After all, somewhere, somehow, " + player.proSubj + " had lost those 3 golden coins. It might be wise to double check.");

                        System.out.print(player.name + " has 5 inventory slots. Check inventory now? (y/n): ");

                        if (yesNo(in))
                                {
                                        System.out.println(player.name + " decided to check " + player.proPossAdj + " inventory.");
                                        player.printInventory(player);
                                        System.out.println("Everything that should be there was there, and so " + player.name + " sighed in relief.");
                                }
                        else    
                                {
                                        System.out.println(player.name + " decided that it could wait until tomorrow.");
                                }

                        System.out.println(player.proSubj + " locked the door, flung onto the bed, and promptly fell asleep.");
                }
        
        public static void runChapter3(Player player, Scanner in)
                {
                        System.out.println("When " + player.name + " opened " + player.proPossAdj + " eyes, " + player.proSubj + " found " + player.proPossAdj + "self floating in an endless, soundless, colorless abyss.");
                        System.out.println("When " + player.proSubj + " tried to move, or shout, or see anything at all, " + player.proSubj + " could not. It was as if " + player.proSubj + " could only exist in a state of thought.");
                        System.out.println("Time seemed to stretch on and on, and " + player.name + " was quickly losing hope. Perhaps " + player.proSubj + " should just accept this new reality. Maybe there truly was nothing to be done.");
                        System.out.println("After what felt like a lifetime of lonely nothingness, " + player.name + " heard it...just the faintest whispering, in the back of " + player.proPossAdj + " mind, that did not belong to " + player.proObj + ".");

                        System.out.println("The voice whispered but four words: 'Why do you persist?'");
                        System.out.println(player.name + " knew, in that moment, that " + player.proPossAdj + " answer was crucial to " + player.proPossAdj + " survival.");
                        System.out.println("What do you persist for? (love/justice/riches/duty/vengeance/knowledge)");

                        player.motivation = in.next().toLowerCase();

                        System.out.println(player.name + " knew what " + player.proPossAdj + " answer was, and concentrated on thinking it...it was for " + player.motivation + ".");

                        if (player.motivation.equals("riches") || player.motivation.equals("vengeance"))
                                {
                                        System.out.println("The voice in " + player.proPossAdj + " became louder, sharper.");
                                        System.out.println("It spoke: 'Go. Leave this place, for that will not serve you here. I cannot help you.");
                                        System.out.println("Suddenly, " + player.name + "'s thoughts began to collapse, one by one.");
                                        System.out.println(player.proPossAdj + " very last thought was that your answer cost " + player.proObj + " " + player.proPossAdj + " life.");
                                        System.out.println();
                                        gameOver();
                                }
                        else
                                {
                                        System.out.println("The voice let out a soft hum before it spoke again:");
                                        System.out.println("'I understand. I will do what I can to help you.'");
                                        System.out.println(player.name + " watched as the nothingness surrounding " + player.proObj + " slowly began to turn to a bright and warm golden light.");
                                        System.out.println("The light became blinding, and " + player.proSubj + " closed the eyes that " + player.proSubj + " had once again.");
                                        System.out.println(player.proSubj + " woke with a start, then, alone and safe in " + player.proPossAdj + " bed at the inn.");
                                        System.out.println("Hanging around " + player.proPossAdj + " neck lay a necklace with a milky amber gem that had not been there before.");
                                }
                }

        public static void runChapter4(Player player, Scanner in)
                {

                }

}
