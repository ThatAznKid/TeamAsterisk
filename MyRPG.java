import java.io.*;
import java.util.*;

public class MyRPG { 
     
    private Character noob; 
    private Monster weewoo;
    private InputStreamReader isr;
    private BufferedReader in;
    private int delay;	
    
    public MyRPG () { 
    	isr = new InputStreamReader( System.in );
    	in = new BufferedReader( isr );
	delay = 25;
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
    
    public void dailyLife (int choice) { 
	String s;
	if (choice == 0) { 
	    s= "Nice seeing ya around. Hope to see you again sometime."; 
	    printWithDelay(s); 
	}
	else if (choice == 1) { 
	    fightMonster();  
	} 
	else if (choice == 2) { 
	    rest(); 
	} 
	else if (choice == 3) { 
	    viewStats(); 
	}
	else if (choice == 4) { 
	    options();
	}	
    }//end dailyLife

    //dailyLife option 1
    public void fightMonster () { 
	String s;
	int holder = -1; 
	int damage1, damage2;
	weewoo = new Monster(); 
	while (weewoo.isAlive() && noob.isAlive()) { 
	    //hit 'em with a splash attack 
	    try { 
		s= "You've encountered a monster!\n"; 
		s+= "What will you do?\n"; 
		s+= noob.getName() + " has " + noob.getHealth() + " hitpoints left.\n";
		s+= weewoo.getName() + " has " + weewoo.getHealth() + " hitpoints left.\n";
		s+= noob.moveSet();   
		printWithDelay(s); 
		holder = Integer.parseInt (in.readLine()); 
	    } 
	    catch ( IOException e ) { } 
	    
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
		s+= "Back to the town we go...\n"; 
		printWithDelay(s); 
	    } 
	    else if (noob.isAlive() && !weewoo.isAlive()) {  
		int placeholder = weewoo.expWorth();
		s= "You seem to have killed the guy. Great job!\n"; 
		s+= "You gained " + placeholder + " EXP!\n"; 
		noob.gainEXP (placeholder);  
		printWithDelay(s); 
		noob.levelUp();
		s= "Time to return to town.\n"; 
		printWithDelay(s);
	    } 
	    else if (!noob.isAlive() && !weewoo.isAlive()){ 
		s= "I guess both of you killed each other simultaneously somehow...\n";
		s+= "That's cool..."; 
		s+= "Wonder if it was like an anime scene...\n"; 
		s+= "Ahem. Back to the town we go.\n"; 
		s+= "Don't think you're getting any gold or exp for this.\n"; 
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
	s+= "EXP: " + noob.getEXP()+"\n";  
	s+= "EXP needed to level up: " + (noob.getLevel() * (10 + noob.getLevel())) +"\n"; 
	s+= "Current HP: " + noob.getHealth()+"\n"; 
	s+= "Total HP: " + noob.getOrigHitPts()+"\n"; 
	s+= "Attack Power: " + noob.getStrength()+"\n"; 
	s+= "Defense: " + noob.getDefense()+"\n";
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

	//let's begin
    public void newGame() { 

	//starting a new game... 
	//let's get that name of yours...
	String s; 
	String name = "";
	int holder = -1;
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
	try {
	    holder = Integer.parseInt(in.readLine());
	}
	catch ( IOException e ) { }

	//time to begin? initialize a new one
	s= "I see...I see...\n"; 
	s+= "Well, it appears it is time to start your adventure...\n"; 
	s+= "So...for the time being you're in town.\n"; 
	printWithDelay (s); 
	if (holder == 1) { 
	    noob = new Warrior (name); 
	} 
	else { 
	    noob = new Mage(name); 
	} 

	//story time 
	while (holder != 0) {
	    s= "Day " + noob.getDaysAlive() + " of being here, congrats.\n";
	    s+= "Right now, you can: \n";  
	    s+= "0. Quit game. All data will be lost.\n";
	    s+= "1. Fight some gnarly monsters!\n";  
	    s+= "2. Take a rest and restore your health\n"; 
	    s+= "3. View Inventory and Stats\n"; 
	    s+= "4. Settings/Options\n";
	    printWithDelay(s);
	    try {
		holder = Integer.parseInt(in.readLine());
	    }
	    catch ( IOException e ) { }
	    dailyLife(holder); 
	}
    }//end newGame 

    public static void main (String [] args) { 
	MyRPG game = new MyRPG();
    }// end main
    
}//end class myRPG
