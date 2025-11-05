import java.util.Scanner;
import java.util.Random;

public class Main {

        //This method will return a random number using two ints as parameters that define the min and max number can be.
        public static int returnRandom(int min, int max)
                {
                        Random random = new Random();
                        int randomNum;

                        randomNum = random.nextInt(max - min + 1) + min;

                        return randomNum;
                }        
        //All this method does is pause the game until the player inputs a 'y' character and chooses to continue the game. It is currently impractical, but could potentially be expanded into a save/continue method later.
        public static void continueGame()
                {
                        System.out.print("Continue playing? (y/n): ");

                        char continueChoice = in.next().charAt(0);

                        while (continueChoice != 'y')
                                {
                                        System.out.print("Continue playing? (y/n): ");
                                        continueChoice = in.next().charAt(0);
                                }
                }
        //this method prints each inventory item name to the console
        public static void printInventory()
                {
                        System.out.println("Current inventory: ");

                        for (String inventoryItem : inventory)
                                {
                                        System.out.println(inventoryItem);
                                }
                        
                }

        // this method takes a slot number (1-5) as a parameter and will print what is in that slot in the player's inventory
        public static void printInventory(int slot)
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

        //basic encounter method that allows for the player to fight 3 enemies, and takes enemyType (wolf, bandit, etc) and enemyHealth as parameters. The player does not take damage when this method is used.
        public static void basicEncounter(String enemyType, int enemyHealth)
                {
                        int[] enemies = new int[3];

                        enemies[0] = enemyHealth;
                        enemies[1] = enemyHealth;
                        enemies[2] = enemyHealth;

                        while (!(enemies[0] <= 0 && enemies[1] <= 0 && enemies[2] <= 0))
                {
                        for (int i = 0; i < enemies.length; ++i)
                                {
                                        System.out.println(enemyType + " " + (i+1) + " has " + enemies[i] + " health remaining.");
                                }
                        
                        System.out.print("Which " + enemyType + " should " + name + " attack? (1/2/3): ");

                        int enemyToAttack = in.nextInt();

                        int attackDamage = returnRandom(1, enemyHealth - 1);

                        enemies[enemyToAttack - 1] = enemies[enemyToAttack - 1] - attackDamage;

                        System.out.println(name + " attacked " + enemyType + " " + enemyToAttack + " and dealt " + attackDamage + " damage.");
                        System.out.println("The " + enemyType + " tried to attack " + proObj + ", but they missed.");

                        if (enemies[0] <= 0 && enemies[1] <= 0 && enemies[2] <= 0)
                                {
                                        break;
                                }
                        else
                                {
                                        continue;
                                }

                }
                }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        // --- Collecting basic character info ---
        System.out.print("Enter your character's name: ");
        String name = in.nextLine();

        System.out.print("Choose a pronoun subject (he/she/they): ");
        String proSubj = in.next().toLowerCase();         // e.g., he / she / they

        System.out.print("Choose a pronoun object (him/her/them): ");
        String proObj = in.next().toLowerCase();          // e.g., him / her / them

        System.out.print("Choose a possessive adjective (his/her/their): ");
        String proPossAdj = in.next().toLowerCase();      // e.g., his / her / their

        System.out.print("Enter your character's age: ");
        int age = in.nextInt();

        // --- Determining how much gold the character has with them ---
        System.out.print("Enter a whole number between 10 and 30: ");
        int gold = in.nextInt();

        // --- Prologue paragraph ---
        System.out.println();
        System.out.println("~ ~ ~ Adventure Prologue ~ ~ ~");
        System.out.println(name + " set out at dawn, " + proPossAdj + " pack light and hopes high.");
        System.out.println("At only " + age + " years old, " + proSubj + " already carried stories that most would never dare to tell.");
        System.out.println("In the pouch at " + proPossAdj + " side clinked " + gold + " gold coins..."
                + "not much, but more than enough for bread and a bed in a quiet inn.");
        System.out.println("A weathered sign pointed toward the Whispering Woods, and " + proSubj
                + " felt a shiver that had nothing to do with the cold.");
        System.out.println("Whatever waited beyond the treeline would test " + proObj + ", but " + name
                + " walked on without looking back.");

        // --- Collecting more basic character info, focusing on their backstory---
        System.out.println();
        System.out.print("What is the name of " + name + "'s hometown?: ");
        String hometown = in.next();

        System.out.print("How many years has it been since " + proSubj + " left home to explore?: ");
        int exploreExp = in.nextInt();

        System.out.print("Enter another character's name: ");
        String mentor = in.next();

        System.out.print("How old is this new character?: ");
        int mentorAge = in.nextInt();
        mentorAge = mentorAge * 100;

        // --- Collecting more character info, focusing on proficiencies/personality ---
        System.out.print("Choose one weapon (sword/bow/revolver): ");
        String weapon = in.next().toLowerCase();

        System.out.print("Choose one attribute (strength/charisma/wit): ");
        String attribute = in.next().toLowerCase();

        // --- Continuing the story, briefly fleshing out character's background ---
        System.out.println();
        // System.out.println("~ ~ ~ The Adventure Begins ~ ~ ~");
        System.out.println(name + " entered the Whispering Woods, taking the dirt path marked on " + proPossAdj + " map.");
        System.out.println("As " + proSubj + " walked, " + proSubj + " couldn't help but feel a bit wistful for home.");
        System.out.println("It had been more than " + exploreExp + " years since " + proSubj + " had left " + hometown + "."); 
        System.out.println("But, for as much as " + name + " missed " + proPossAdj + " loved ones, " + proSubj + " knew that the journey would be worth it in the end.");
        System.out.println("Besides..." + proSubj + " had been prepared, when they left. " + name + " smiled fondly, remembering the kind smile and lessons that "
                + mentor + " had taught " + proObj + ".");
        System.out.println("Heck, if a " + mentorAge + " year old wizard could believe in " + proPossAdj + " " + attribute 
                + " in a bind, then surely there was nothing to fear.");
        System.out.println(name + " idly ran a hand over " + proPossAdj + " " + weapon + " with a soft sigh. Well, there was always that, too.");
        System.out.println("The chill from before nearly gone, " + proSubj + " marched along the path with renewed vigor and confidence.");

        // --- Collecting info about MC's environment ---
        System.out.println();
        System.out.print("Enter the name of a season (winter/spring/summer/fall): ");
        String season = in.next().toLowerCase();

        System.out.print("Enter the name of a color: ");
        String color1 = in.next().toLowerCase();

        System.out.print("Enter the name of another color: ");
        String color2 = in.next().toLowerCase();

        // --- Continuing the story, minor worldbuilding ---
        System.out.println();
        // System.out.println("~ ~ ~ The Adventure Continues ~ ~ ~");
        System.out.println(name + " had been walking for many hours through the Whispering Woods, admiring the beauty of the forest during the "
                + season + ", when " + proSubj + " noticed that something...wasn't quite right.");
        System.out.println(proSubj + " looked skyward and noticed that the brilliant " + color1 + " of the daytime sky had almost entirely faded into the "
                + color2 + " of night.");
        System.out.println("Had " + proSubj + " really been walking for that long?? According to the map, " + proSubj + " definitely should have found the next town by now.");
        System.out.println("Nervous, " + proSubj + " opened up " + proPossAdj + " map.");
        System.out.println("To be lost in the Whispering Woods was a very bad thing...a position that nobody in their right mind wanted to find themselves in.");
        System.out.println("A sudden SNAP caused " + name + " to turn around abruptly. " + proSubj + " instinctually reached for " + proPossAdj + " " + weapon + "."); 

        System.out.println();

        // creates an inventory array for the player with 5 inventory slots
        String[] inventory = new String[5];
        inventory[0] = "bag of gold";
        inventory[1] = weapon;
        inventory[2] = "5 rations";
        inventory[3] = "empty";
        inventory[4] = "empty";
        
        continueGame();

        System.out.println("~ ~ ~ Chapter One ~ ~ ~");
        System.out.println(name + " was suddenly staring at a creature unlike any that " + proSubj + "'d ever encountered before."); 
        System.out.println("There, standing on its hind legs and sharp teeth bared, was a large and feathered serpent. " + proSubj + " knew that " + proSubj + " needed to act fast.");

        // player's first (y/n) choice
        System.out.print("Does " + name + " approach the creature? (y/n): ");

        char choice1 = in.next().charAt(0);

        boolean stolenFrom = false;

        if (choice1 == 'y')
                {
                        System.out.println("The creature before " + proObj + " looked to be just as startled as " + proSubj + " were.");
                        System.out.println(name + " took a slow, cautious step forward, " + proPossAdj + " grip on " + proPossAdj + " " + weapon + " slackening slightly.");
                        System.out.println("The serpent was 3 good paces away.");

                        System.out.print("Proceed? (y/n): ");
                        char proceed = in.next().charAt(0);
                        int paces = 2;

                        while (proceed == 'y' && paces > 0)
                                {
                                        paces = paces - 1;
                                        System.out.println(name + " took another step forward. There were " + paces + " pace(s) to go.");
                                        System.out.print("Proceed? (y/n): ");
                                        proceed = in.next().charAt(0);
                                }
                        
                        
                        System.out.println(proSubj + " stopped, " + paces + " pace(s) away from the beast. Both the creature and " + name + " were trembling.");
                        
                        System.out.println("The beast bristled, its dark black eyes flicking between the " + weapon + " and " + name + "'s face.");
                        System.out.println("As " + proSubj + " continued stand still, " + proSubj + " noticed the creature was gripping something in its claws. Slowly, cautiously, the serpent opened its hand to reveal its contents.");

                        System.out.print(name + " felt uneasy...should " + proSubj + " stay and see what the creature has for them? (y/n): ");
                        char choice2 = in.next().charAt(0);
                        

                        if (choice2 == 'y')
                                {
                                        System.out.println(proSubj + " decided to stick around and see what the serpent was holding. " + proSubj + " stopped in front of the beast and waited.");
                                        System.out.println("In its hand, outstretched in offering, were 3 golden coins. " + name + " furrowed " + proPossAdj + " brows, but took the coins despite the confusion.");
                                        System.out.println(proSubj + " settled the coins into " + proPossAdj + " pouch, and noticed with bewilderment that 3 of their coins had been missing. Was this creature returning them?");
                                        System.out.println("Before " + name + " got the chance to thank " + proPossAdj + " newfound friend, there was a shout in the distance.");
                                        System.out.println("The beast jumped before it quickly ran away on all fours.");
                                }
                        else
                                {
                                        System.out.println(name + " decided to err on the side of caution, and backed away from the creature. It seemed to deflate at this.");
                                        System.out.println("But before " + proSubj + " could rethink " + proPossAdj + " decision, there was a loud shout in the distance.");
                                        System.out.println("The beast fled.");

                                        gold = gold - 3;
                                        stolenFrom = true;
                                }
                }
        else
                {
                        System.out.println(name + " decided that whatever this creature was, it wasn't worth the risk finding out. It was late and " + proSubj + " really needed to get to the next town before it became necessary to sleep in the woods.");
                        System.out.println(proSubj + " slowly backed away from the feathered serpent. It seemed to deflate at this.");
                        System.out.println("But before " + proSubj + " could rethink " + proPossAdj + " decision, there was a loud shout in the distance.");
                        System.out.println("The beast fled."); 

                        gold = gold - 3;
                        stolenFrom = true;
                }                              
                
        System.out.println("A shout like that in the Whispering Woods at this hour could only mean trouble...but at the same time, " + name + " was lost, alone, and growing increasingly nervous.");
        System.out.println(proSubj + " decided that following the voice was " + proPossAdj + " best shot at getting out of the woods. Whoever was in danger would surely be of help were they to be rescued.");
        System.out.println("With no better plan in mind, " + name + " set off in the direction they heard the shout come from.");

        

        System.out.println(name + "soon came upon a clearing with 3 ravenous wolves snarling at " + proObj + ". Lying dead at the wolves' feet was a young man.");
        System.out.println(proSubj + " knew there was no chance of outrunning the wolves..." + proSubj + " were going to have to fight. " + proSubj + " drew " + proPossAdj + " " + weapon + ".");

        basicEncounter("wolf", 5);

        System.out.println("After what seemed like an eternity, " + name + " finally felled the last wolf. " + proSubj + " could not believe " + proPossAdj + " luck.");
        System.out.println("Before " + proObj + " lay the body of a young man who had not been so lucky. " + name + " gently closed the man's eyes before " + proSubj + " looked around.");
        System.out.println("To " + proPossAdj + " astonishment, following the poor man's shout seemed to have led " + proSubj + " right back onto the right path.");
        System.out.println(proSubj + " whispered a thank you to the man, but knew that " + proSubj + " could not linger in the woods any longer.");
        System.out.println(proSubj + ", exhausted and with a heavy heart, finally trudged the last half mile or so out of the forest.");

        System.out.println(proSubj + " emerged into the next town with a sigh of relief. " + proSubj + " immediately made a beeline for the nearest tavern.");
        System.out.println("Despite the late hour, the inside of inn was bustling with people when " + name + " entered it. It seemed the first floor served as a lively bar. Considering the small size of the town, " + proSubj + " supposed that made sense.");
        System.out.println(proSubj + " inquired about a room. A private room cost 3 coins per night.");

        if (stolenFrom)
                {
                        System.out.println(proSubj + " reached into " + proPossAdj + " coin purse to pay and noticed that some of " + proPossAdj + " golden coins had seemed to vanish.");
                        System.out.println("Disbelieving, " + proSubj + " counted them one by one.");

                        for (int i = 1; i <= gold; ++i)
                            {
                                System.out.print(i + ", ");
                            }

                        System.out.println();
                        System.out.println("Somehow short 3 coins, " + name + " frowned as they handed over 3 more precious coins to the tavernkeep.");
                }
        else
        {
            System.out.println(name + " handed over 3 coins to the tavernkeep, grateful that " + proSubj + " had risked approaching the creature earlier.");
        }

        System.out.println("Finally, after an exhausting and troublesome day, " + name + " settled into " + proPossAdj + " room for the night.");
        System.out.println("Before sleeping, however, " + proSubj + " decided that perhaps " + proSubj + " should check " + proPossAdj + " bag to be sure everything was still there.");
        System.out.println("After all, somewhere, somehow, " + proSubj + " had lost those 3 golden coins. It might be wise to double check.");

        System.out.print(name + " has 5 inventory slots. Check inventory now? (y/n): ");
        char checkInventory = in.next().charAt(0);

        if (checkInventory == 'y')
                {
                        System.out.println(name + " decided to check " + proPossAdj + " inventory.");
                        printInventory();
                        System.out.println("Everything that should be there was there, and so " + name + " sighed in relief.");
                }
        else    
                {
                        System.out.println(name + " decided that it could wait until tomorrow.");
                }

        System.out.println(proSubj + " locked the door, flung onto the bed, and promptly fell asleep.");

        System.out.println("~ ~ ~ To Be Continued ~ ~ ~");
        
    }
}
