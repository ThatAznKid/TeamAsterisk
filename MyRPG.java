import java.io.*;
import java.util.*;

public class MyRPG { 
     
    private Character noob; 
    private Monster weewoo;
    private InputStreamReader isr;
    private BufferedReader in;
    private int delay;
    private Inventory inv;
    private Map rpg;
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    
    public MyRPG () { 
    	isr = new InputStreamReader( System.in );
    	in = new BufferedReader( isr );
		delay = 10;
    	newGame (); 
    }
    
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
    String Town = (rpg.tileGet(rpg.getx(),rpg.gety())).getTown();
	String s;
	if (choice.equals("!")) { 
	    s= "Nice seeing ya around. Hope to see you again sometime.\n"; 
	    printWithDelay(s);
	    System.exit(0); 
	}
	else if (choice.equals("r")) { 
	    rest(Town); 
	} 
	else if (choice.equals("v")) { 
	    viewStats(); 
	}
	else if (choice.equals("o")) { 
	    options(); 
	}	
	else if (choice.equals("i")) {
		noob.setGold(inv.interact(noob.getLevel(),noob.getGold(),(rpg.tileGet(rpg.getx(), rpg.gety())).getTown()));
	}
	else if (choice.equals("yes")) {
		noob.setGold(500);
		noob.gainEXP(500);
		noob.levelUp();
		noob.levelUp();
		noob.levelUp();
		noob.levelUp();
		noob.levelUp();
	}
    }//end dailyLife
	
	
	
    //dailyLife option 1
    public void fightMonster() { 
	String s;
	int holder = -1; 
	int damage1, damage2;
	weewoo = mapMonster();
	((Character)noob).setdeftot(((Inventory)inv).getdeftot());
	((Character)noob).setstrtot(((Inventory)inv).getstrtot());
	s= "\033[H\033[2J" + "You've encountered a " + weewoo + "\n";
	printWithDelay(s);
	while (weewoo.isAlive() && noob.isAlive()) { 
	    //hit 'em with a splash attack 
		s= noob.getName() + " has " + noob.getHealth() + " hitpoints left.\n";
		s+= weewoo.getName() + " has " + weewoo.getHealth() + " hitpoints left.\n";
		s+= "What will you do?\n"; 
		s+= noob.moveSet();   
		printWithDelay(s); 
		holder = errorHandlerInt (3); 

	    
	    //what do? 
	    if (holder == 3){
	    		noob.setHitPts(noob.getHitPts() + inv.interactuse());
	    	}	
	    else if (holder == 2) { 
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
		s= "Thou hath been slewn!\n";
		s+= "Odin incurs His wrath upon thee!\n";
		s+= "'Thou hast lost thy game of life.'\n";
		printWithDelay(s);
		try {
        in.readLine();
         }
    	catch ( IOException e) { }
    	System.exit(1);
	    } 
	    else if (noob.isAlive() && !weewoo.isAlive()) {  
		int placeholder = weewoo.expWorth();
		int placeholder2 = weewoo.goldWorth();
		s= "You seem to have killed the guy. Great job!\n"; 
		s+= "You gained " + placeholder + " EXP!\n";
		s+= "You gained " + placeholder2 + " GOLD!\nType anything to continue.";
		noob.gainEXP (placeholder);
		noob.gainGOLD (placeholder2);
		printWithDelay(s);
		try {
        in.readLine();
         }
    	catch ( IOException e) { }
		noob.levelUp();
		
		if (weewoo.equals("Dark Arcane Magician")){
			s = "The mage's body contorts, soaring high into the sky.\n";
			s += "Lights beam across the sky, Odin bows his head.\n";
			s += "'You've done it... you've saved us, thank you!'";
			printWithDelay(s);
			try {
	    	in.readLine();
			}
			catch ( IOException e ) { }
			System.exit(1);
		}
	    } 
	    else if (!noob.isAlive() && !weewoo.isAlive()){ 
		s= "I guess both of you killed each other simultaneously somehow...\n";
		s+= "That's cool..."; 
		s+= "Wonder if it was like an anime scene...\n"; 
		s+= "Jesus is holding his hand out for you...\n";
		s+= "'It's time to go, my son.'";
		printWithDelay(s);
		try {
	    in.readLine();
		}
		catch ( IOException e ) { }
		System.exit(1);
	    }
	}
	      
    }//end fightMonster
    
	//dailyLife option 2 
    public void rest(String Town) {
	String s; 
    if (Town == "null" || Town == "Boss"){
    	s= "You are not in a town, you can't rest here!\n";
    	s+= "Type anything to continue.";
		printWithDelay(s);
		try {
	    in.readLine();
		}
		catch ( IOException e ) { }
    	}
	else {noob.setHitPts(noob.getOrigHitPts()); 
		s= "You awake feeling well refreshed and determined.\n";
		s+= "Type anything to continue.";
		printWithDelay(s);
		try {
        	in.readLine();
         	}
    	catch ( IOException e) { }
    	}
    }//end rest
	
	//dailyLife option 3
    public void viewStats() { 
	String s;
	s= "\033[H\033[2J" + "Level: " + noob.getLevel()+"\n"; 
	s+= "EXP: " + noob.getEXP()+"\n";  
	s+= "EXP needed to level up: " + (40 * noob.getLevel() - noob.getEXP()) +"\n"; 
	s+= "Current HP: " + noob.getHealth()+"\n"; 
	s+= "Total HP: " + noob.getOrigHitPts()+"\n"; 
	s+= "Attack Power: " + noob.getStrength() + " " + ANSI_GREEN + "(+ " + inv.getstrtot() + ")" + ANSI_RESET + "\n"; 
	s+= "Defense: " + noob.getDefense() + " " + ANSI_GREEN + "(+ " + inv.getdeftot() + ")" + ANSI_RESET + "\n";
	s+= "Gold: " + noob.getGold() +"\n"; 
	s+= "Type anything to go back.";
	printWithDelay (s);
    try {
        in.readLine();
         }
    catch ( IOException e) { }
    }//end viewStats 

    //dailyLife 4
    public void options () {
	int holder = -1;
	    String s; 
	    s = "How fast would you like the text to be?\n"; 
	    s+= "1. Fast\n"; 
	    s+= "2. Medium\n"; 
	    s+= "3. Slow\n"; 
	    s+= "4. No delay\n"; 
	    printWithDelay(s);	
	    holder = errorHandlerInt (4); 
	if (holder == 4) { 
	    delay = 0; 
	} 
	else if (holder == 3) { 
	    delay = 50; 
	} 
	else if (holder == 2) { 
	    delay = 25; 
	} 
	else{ 
	    delay = 10; 
	} 
    }

	//let's begin
    public void newGame() { 

	//starting a new game... 
	//let's get that name of yours...
	rpg = new Map();
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
	s= "\033[H\033[2J" + "Ah, I see...\n"; 
	s+= "Pleased to meet you, " + name + ". "; 
	s+= "Well, what class happens to tickle your fancy?\n";
	s+= "1. Warrior\n"; 
	s+= "2. Mage\n"; 
	printWithDelay (s); 
	holder = errorHandlerInt (2);


	//time to begin? initialize a new one
	s=  "\033[H\033[2J" +"I see...I see...\n"; 
	s+= "It is time to start your adventure!\n";
	s+= "Your objective is to reach the top and defeat the Dark Arcane Magician!\n";
	s+= "You must reach a certain level to progress through each town.\n";
	s+= "Each town will provide stronger and stronger equipment!\n";
	s+= "But, BEWARE! There have been stories about some cons selling bad equipment.\n\n";
	s+= "You use WASD to traverse the map.\n";
	s+= "Remember! You are prone to attacks from monsters outside of town.\n";
	s+= "The X will mark where you are.\n\n";
	s+= "Type anything to continue.\n";
	printWithDelay (s);
	try {
        in.readLine();
         }
    catch ( IOException e) { }
	if (holder == 1) { 
	    noob = new Warrior (name);
	    inv = new Inventory();
	} 
	else { 
	    noob = new Mage(name);
	    inv = new Inventory();
	} 

	//story time 
	while (holder != -1) {
	    System.out.println("\033[H\033[2J" + rpg);
	    s= "You are now " + rpg.tileGet(rpg.getx(), rpg.gety()) + "\nWhat would you like to do?\n";
	    s+= localopt((rpg.tileGet(rpg.getx(),rpg.gety())).getTown());
	    printWithDelay(s);
	    try {
		str = in.readLine();
	    }
	    catch ( IOException e ) { }
	    double c = Math.random();
	    String Town = (rpg.tileGet(rpg.getx(), rpg.gety())).getTown();
	    if (Town.equals("Boss")){
	    	fightMonster();
	    }
	    else if (c > .75 && (Town == "null")){
	    	fightMonster();
	    }
	    else{
	    dailyLife(str); 	
	    if (str.equals("w")) { 
			rpg.move ("w"); 
	    }
	    if (str.equals("a")) {
	    	if ((rpg.tileGet(rpg.getx() - 1, rpg.gety()).getTown()).equals("Wayner") && noob.getLevel() < 20){
	    	s = "'You are too weak for our town!' squeeled the Galways. Level 20 required.";
	    	s += "\nType anything to continue.\n";
	    	printWithDelay(s);
	    	try{
	    		in.readLine();
	    	}
	    	catch (IOException e) { };}
	    else rpg.move ("a"); 
	    }
	    if (str.equals("s")) {
	    	if ((rpg.tileGet(rpg.getx(), rpg.gety() + 1).getTown()).equals("Cernar") && noob.getLevel() < 15){
	    	s = "'You shall not pass!' quoth the White King. Level 15 required.";
	    	s += "\nType anything to continue.\n";
	    	printWithDelay(s);
	    	try{
	    		in.readLine();
	    	}
	    	catch (IOException e) { };}
	    else rpg.move ("s"); 
	    }
	    if (str.equals("d")) {
	    	if ((rpg.tileGet(rpg.getx() + 1, rpg.gety()).getTown()).equals("Yeevile") && noob.getLevel() < 10){
	    	s = "'Halt frail boy, where do you think you're going!' said the guard. Level 10 required.";
	    	s += "\nType anything to continue.\n";
	    	printWithDelay(s);
	    	try{
	    		in.readLine();
	    	}
	    	catch (IOException e) { };}
		else rpg.move ("d"); 
	    }
	    }
	}
    }//end newGame 

	public String localopt(String Town){
		String s = "";
		if (Town == "null"){
				s+= "!. Quit game. All data will be lost.\n";
				s+= "v. View Stats\n";
				s+= "i. Open Inventory\n";
				s+= "o. Settings/Options\n"; 
		}
		else if (Town == "Boss"){
				s+= "!. Quit game. All data will be lost.\n"; 
				s+= "v. View Stats\n";
				s+= "i. Open Inventory\n";
				s+= "o. Settings/Options\n";
		}
		else {
				s+= "!. Quit game. All data will be lost.\n";
				s+= "r. Rest and restore health.\n";  
				s+= "v. View Stats\n";
				s+= "i. Open Inventory\n";
				s+= "o. Settings/Options\n";
		}
		return s;
	}
	
	public Monster mapMonster(){
		int x = rpg.getx();
		int y = rpg.gety();
		Monster nota;
		double c = Math.random();
		if (x >= 3 && x <= 8 && y == 1){
			if (c >= .25){
				nota = new Monster(1 + (int)(2 * Math.random()), "Green Slime");
				return nota;
			}
			if (c < .25){
				nota = new Monster(3 + (int)(3 * Math.random()), "Decaying Skeleton");
				return nota;
			}
		}
		
		if (x == 10 && y >= 3 && y <= 8){
			if (c >= .25){
				nota = new Monster(5 + (int)(2 * Math.random()), "Rabid Wolf");
				return nota;
			}
			if (c < .25){
				nota = new Monster(7 + (int)(3 * Math.random()), "Ferocious Zombie");
				return nota;
			}
		}
		
		if (x >= 3 && x <= 8 && y == 10){
			if (c >= .25){
				nota = new Monster(10 + (int)(2 * Math.random()), "Goblin Warrior");
				return nota;
			}
			if (c < .25){
				nota = new Monster(12 + (int)(3 * Math.random()), "Ancient Golem");
				return nota;
			}
		}
		
		if (x == 5 && y == 3){
			nota = new Monster(25,"Dark Arcane Magician");
			return nota;
			}
		
		if (x > 0 && x < 8 && y >= 3 && y <= 8){
			if (c >= .25){
				nota = new Monster(15 + (int)(3 * Math.random()), "Bloodred Wyvern");
				return nota;
			}
			if (c < .25){
				nota = new Monster(17 + (int)(3 * Math.random()), "Ragged Dragon");
				return nota;
			}
		}
		return null;
	}

    public static void main (String [] args) { 
	MyRPG game = new MyRPG();
    }// end main
    
}//end class myRPG
