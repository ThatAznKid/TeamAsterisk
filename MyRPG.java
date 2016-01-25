import java.io.*;
import java.util.*;

public class MyRPG { 
     
    private Character noob; 
    private Character weewoo;
    private InputStreamReader isr;
    private BufferedReader in;
    private int delay;	
    
    public MyRPG () { 
    	isr = new InputStreamReader( System.in );
    	in = new BufferedReader( isr );
	delay = 0; //0 for testing, 25 for general users
    	newGame (); 
    }
    
    public void printWithDelay (String s) { 
	for ( int x = 0 ; x < s.length() ; x++ ) { 
	    System.out.print (s.substring(x,x+1)); 
	    try {
		Thread.sleep(delay); 
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }// end printWithDelay
    
    public void dailyLife (String choice) { 
	String s;
	if (choice.equals("!")) { 
	    s= "Nice seeing ya around. Hope to see you again sometime.\n"; 
	    printWithDelay(s);
	    System.exit(0); 
	}
	else if (choice.equals("r")) { 
	    rest(); 
	} 
	else if (choice.equals("v")) { 
	    viewStats(); 
	}
	else if (choice.equals("o")) { 
	    options(); 
	}	
	else if (choice.equals("h")) { 
	    help(); 
	}
    }//end dailyLife

    //dailyLife option 1
    public void fightMonster (int difficulty) { 
	String s;
	int holder = -1; 
	int damage1, damage2;
	holder = difficulty; 
	if (holder == 1) { 
	    weewoo = new Monster1(); 
	} 
	if (holder == 2) { 
	    weewoo = new Monster2(); 
	} 
	if (holder == 3) { 
	    weewoo = new Monster3(); 
	} 
	if (holder == 4) { 
	    weewoo = new Monster4(); 
	} 
	if (holder == 5) { 
	    weewoo = new Monster5(); 
	}
	if (holder == 6) { 
	    weewoo = new Monster6(); 
	}
	if (holder == 7) { 
	    weewoo = new Monster7(); 
	}
	if (holder == 8) { 
	    weewoo = new Monster8(); 
	}
	if (holder == 9000) { 
	    weewoo = new Boss(); 
	} 
	while (weewoo.isAlive() && noob.isAlive()) { 
	    //hit 'em with a splash attack 

	    s= "You've encountered a monster!\n"; 
	    s+= "What will you do?\n"; 
	    s+= noob.getName() + " has " + noob.getHealth() + " hitpoints left.\n";
	    s+= weewoo.getName() + " has " + weewoo.getHealth() + " hitpoints left.\n";
	    s+= noob.moveSet();   
	    printWithDelay(s); 
	    holder = errorHandlerInt(2); 
	  
	    //what do? 
	    if (holder == 2) { 
		noob.specialize(); 
	    } 
	    else { 
		noob.normalize(); 
	    }
	      
	    //fight! 
	    damage1 = noob.attack (weewoo); 
	    damage2 = weewoo.attack (noob); 
	    
	    s = noob.getName() + " dealt " + damage1 + " points of damage!\n"; 
	    s+= noob.getName() + " took " + damage2 + " points of damage from the attack!\n";
	    printWithDelay (s);   

	    //still alive and kicking? 
	    if (!noob.isAlive() && weewoo.isAlive()) { 
		s= "You seem to have gotten knocked out cold.\n"; 
		s+= "Back to the field we go...\n"; 
		s+= "I think you lost some gold, while you were out cold...\n";
		printWithDelay(s); 
	    } 
	    else if (noob.isAlive() && !weewoo.isAlive()) {  
		int placeholder = weewoo.expWorth();
		int placeholder2 = weewoo.goldWorth();
		s= "You seem to have killed the guy. Great job!\n"; 
		s+= "You gained " + placeholder + " EXP!\n"; 
		s+= "You also gained " + placeholder2 + " gold!\n";
		noob.gainEXP (placeholder);  
		noob.gainGold (placeholder2);
		printWithDelay(s); 
		noob.levelUp();
		s= "Back to the field we go.\n"; 
		printWithDelay(s);
	    } 
	    else if (!noob.isAlive() && !weewoo.isAlive()){ 
		s= "I guess both of you killed each other simultaneously somehow...\n";
		s+= "That's cool..."; 
		s+= "Wonder if it was like an anime scene...\n"; 
		s+= "Ahem. Back to the field we go.\n"; 
		s+= "Don't think you're getting any gold or exp for this.\n";
		s+= "You do seem strangely resilient, however...Didn't you die just now? Whatever, I do think you lost some gold, though.";
		printWithDelay(s); 
	    }
	}
	      
    }//end fightMonster
    
	//dailyLife option 2 
    public void rest() { 
	noob.daysAliveIncrement();   
	noob.setHitPts(noob.getOrigHitPts());  
	String s; 
	s= "You awake feeling well refreshed and determined.\n";
	printWithDelay(s); 
    }//end rest
	
	//dailyLife option 3
    public void viewStats() { 
	String s; 
	s= "Level: " + noob.getLevel()+"\n"; 
	s+= "EXP needed to level up: " + (noob.getLevel() * 60 - noob.getEXP() ) +"\n"; 
	s+= "Current HP: " + noob.getHealth()+"\n"; 
	s+= "Total HP: " + noob.getOrigHitPts()+"\n"; 
	s+= "Attack Power: " + noob.getStrength()+"\n"; 
	s+= "Defense: " + noob.getDefense()+"\n";
	s+= "Gold: " + noob.getGold() + "\n";
	printWithDelay (s);
    }//end viewStats 

    //dailyLife 4
    public void options () {
	int holder = -1;
	try { 
	    String s; 
	    s = "How fast would you like the text to be?\n"; 
	    s+= "1. Fast\n"; 
	    s+= "2. Medium\n"; 
	    s+= "3. Slow\n"; 
	    s+= "4. No delay\n"; 
	    printWithDelay(s);	
	    holder = Integer.parseInt (in.readLine()); 
	}
	catch (	IOException e ) { }
	if (holder == 1) { 
	    delay = 10; 
	} 
	else if (holder == 2) { 
	    delay = 25; 
	} 
	else if (holder == 3) { 
	    delay = 50; 
	} 
	else if (holder == 4) { 
	    delay = 0; 
	} 
    }

    //dailyLife5 
    public void help () { 
	String s;
	s= "Remember, just use WASD to move around on the map.\n";
	s+= "Right now, you can: \n";  
	s+= "!. Quit game. All data will be lost.\n";
	s+= "f. Fight some gnarly monsters!\n";  
	s+= "r. Take a rest and restore your health\n"; 
	s+= "v. View Inventory and Stats\n"; 
	s+= "o. Settings/Options\n"; 
	s+= "X will mark where you are.\n";
	s+= "There is a large chance of encountering a monster with every step you take.";
	printWithDelay(s); 
    }
	
    //error handling for int inputs
    public int errorHandlerInt (int range) { 
	boolean isGood = false;
	int holder = 100;
	while (isGood == false) {
	    try {
		holder = Integer.parseInt(in.readLine());
	    }
	    catch ( IOException e ) { } 
	    catch ( NumberFormatException e ) { 
		printWithDelay ("That doesn't seem to be a valid input. Try again.\n"); 
	    } 
	    if (holder <= range) { 
		isGood = true; 
	    } 
	}
	return holder;
    }

    //let's begin
    public void newGame() { 

	//starting a new game... 
	//let's get that name of yours...
	Map rpg = new Map();
	String s; 
	String name = "";
	int holder = -1;
	String str = "";
	s= "Welcome to the Stereotypical RPG!\n"; 
	s+= "What would you like to be called?\n"; 
	s+= "Please enter your name:\n";
	printWithDelay (s); 
	try {
	    name = in.readLine();
	}
	catch ( IOException e ) { }
       
	//done with the intro, time to pick a class
	s= "Ah, I see.\n"; 
	s+= "Pleased to meet you, " + name + ". "; 
	s+= "Well, what class happens to tickle your fancy? "; 
	s+= "You only have a choice between a warrior and a mage right now, but each class has a variety of options to work with that you will find out about later.\n"; 
	s+= "Pick the number choice of the class you'd like.\n"; 
	s+= "1. Warrior\n"; 
	s+= "2. Mage\n"; 
	printWithDelay (s); 
	holder = errorHandlerInt(2);
	if (holder == 1) { 
	    noob = new Warrior (name); 
	} 
	else { 
	    noob = new Mage(name); 
	}  
	//time to begin? initialize a new one
	s= "I see...I see...\n"; 
	s+= "Well, it appears it is time to start your adventure...\n"; 
	s+= "So...for the time being you're in the first town, Dragnok.\n"; 
	s+= "Recently, there's been a large infestation of monsters in every town, and we think the source is coming from the mountain in the middle. Please, we need your help! Stop the source of these irregularities!";
	s+= "Remember, just use WASD to move around on the map.\n";
	s+= "Right now, you can: \n";  
	s+= "!. Quit game. All data will be lost.\n";
	s+= "f. Fight some gnarly monsters!\n";  
	s+= "r. Take a rest and restore your health\n"; 
	s+= "v. View Inventory and Stats\n"; 
	s+= "o. Settings/Options\n"; 
	s+= "X will mark where you are.\n";
	s+= "Remember, type h for help if you forget any commands.\n";
	printWithDelay (s); 

	//story time 
        for ( ; ; ) {
	    System.out.println(rpg);
	    s= "Day " + noob.getDaysAlive() + " of being here, congrats.\n";
	    s+= "Right now, you are in " + rpg.townDef(rpg.getx(),rpg.gety()) + "\n";
	    printWithDelay(s);
	    try {
		str = in.readLine();
	    }
	    catch ( IOException e ) { }
	    dailyLife(str); 	
	    if (str.equals("w")) { 
		rpg.move ("w"); 
	    }
	    if (str.equals("a")) { 
		rpg.move ("a"); 
	    }
	    if (str.equals("s")) { 
		rpg.move ("s"); 
	    }
	    if (str.equals("d")) { 
		rpg.move ("d"); 
	    }	
	    holder = ((int) (Math.random ()*10));
	    if (3 > holder) { 
		fightMonster(rpg.monsterDeterminer(rpg.getx(),rpg.gety())); 
	    }
	}
    }//end newGame 

    public static void main (String [] args) { 
	MyRPG game = new MyRPG();
    }// end main
    
}//end class myRPG
