import java.io.*;
import java.util.*;

public class Inventory{
    private Item[] equipment;
    private Item[][] slots;
    private InputStreamReader isr;
    private BufferedReader in;
    private int strTotal;
    private int defTotal;
    
    public Inventory(){
        slots = new Item[3][3];
        equipment = new Item[3];
        isr = new InputStreamReader( System.in );
    	in = new BufferedReader( isr );
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
		System.out.println("That doesn't seem to be a valid input. Try again.\n"); 
	    } 
	    if (holder <= range) { 
		isGood = true; 
	    } 
	}
	return holder;
    }
    
    public int getReq(String town){
	    if (town.equals("Dragnok")) {return 5;}
    	if (town.equals("Yeevile")) {return 10;}
    	if (town.equals("Cernar"))  {return 15;}
    	if (town.equals("Wayner"))  {return 20;}
    	else return 0;
    }
    
    public String toString(){
        String retstr = "Equipment:\n" + displayEqu() + "\nInventory:\n" + displayInv();
        return retstr;
    }
    
    public boolean spaceCheck(){
        for (Item[] r : slots){
            for (Item c : r){
                if (c == null){
                    return true;
                }
            }
        }
        return false;
    }
    
    public String displayEqu(){
        String retstr = "";
        for (Item r : equipment){
            retstr += "[" + r + "]";
        }
        return retstr;
    }
    
    public String displayInv(){
        String retstr = "";
			for (Item[] r: slots){
	    			for (Item c: r){
	    				retstr += "[" +  c + "]";
	    			}
	    		    retstr += "\n";
			}
	return retstr;
    }
    
    public Item equip(int s){
        Item holder = slots[s/3][s%3];
        int place = slots[s/3][s%3].getEslot();
        if (equipment[place] != null){
            slots[s/3][s%3] = equipment[place];
            equipment[place] = holder;
            return holder; 
             }
        else {
            equipment[place] = holder;
            slots[s/3][s%3] = null;
            return holder;
        }
    }
    
    public int drop(int s){
        int gold = slots[s/3][s%3].getGold();
        slots[s / 3][s % 3] = null;
        return gold;
    }
    
    public void add(Item a){
        for (int y = 0; y < slots.length; y++){
            for (int x = 0; x < slots[y].length; x++){
                if (slots[y][x] == null){
                    slots[y][x] = a;
                    return;
                }
            }
        }
    }
    
    
    public int sell(int s){
        if (slots[s/3][s % 3] == null){
            return -1;
        }
        return drop(s);
    }
    
    public int buy(Item x){
        add(x);
        return x.getGold();
    }
    
    //interactions with inventory handler
    public int interact(int lvl, int g, String Town){
        int opt = 0;
        System.out.println("\033[H\033[2J");
        while (opt != 5){
            System.out.println(this);
            System.out.println("\nWhat do you wish to do to your inventory?");
            System.out.println("1. Drop item | 2. Equip item | 3. View Item details | 4. Trade (in Town) | 5. Return to the game.");
            opt = errorHandlerInt(5);
	        
	        if (opt == 5){
	            
	            return g;
	        }
	        else if (opt == 4){
	            int ch = 0;
	            System.out.println("\033[H\033[2J");
	            while (ch != 4){
	            if (Town.equals("null") || Town.equals("Boss")){
                    System.out.println("\033[H\033[2J" + "You're not in a town!");
                    break;
                }   
	            System.out.println(this + "You have " + g + " gold.\n" + "\nWhat would you like to trade?\n1. Sell items | 2. Buy potions | 3. Buy equipment | 4. Return to inventory");
	            ch = errorHandlerInt ( 4 );
	            if (ch == 4){
	                System.out.println("\033[H\033[2J");
	            }
                else if (ch == 3){
	                g += interactbuy(g, getReq(Town), 1);
                }
	            else if (ch == 2){
	                g += interactbuy(g, getReq(Town), 0);
	            }
	            else{
	                g += interactsell(Town);
	            }
	           }
	       }
	       else if (opt == 3){
	            interactview();
	       }
           else if (opt == 2){
	            interactequip(lvl);
	            }
	       else {
	            interactdrop();
	            }
        }
        return g;
    }
    
    //drop handler
    public void interactdrop(){
        int o = 0;
        System.out.println("\033[H\033[2J");
        while (o != -10){
        System.out.println("\n" + this);
        System.out.println("Which item slot would you like to empty? (0 - 8) | -10 if done.");
        o = errorHandlerInt(8);
	    if (o == -10){System.out.println("\033[H\033[2J");
	    break;}
	    if (o > 8 || o < 0){
	        System.out.print("\033[H\033[2J");
	        System.out.println("ERROR: Item slot invalid.");
	        return;
	    }
	    if (slots[o/3][o%3] == null){
	        System.out.print("\033[H\033[2J");
	        System.out.println("ERROR: Item slot null.");
	        return;
	    }
	    else {
	        System.out.println("Are you sure? Y/N");
	        String confirm = "";
	        try{
	            confirm = in.readLine();
	        }
	        catch (IOException e) { }
	        if (confirm.equals("Y")){
	            System.out.println("\033[H\033[2J" + "You just dropped a " + slots[o/3][o%3]);
	            drop(o);
	            }
	        else System.out.println( "\033[H\033[2J" );
	        }
	    }
	    System.out.println("\033[H\033[2J");
    }
    
    //equip handler
    public void interactequip(int lvl){
        int eq = 0;
        System.out.println("\033[H\033[2J");
        while (eq != -10){
        System.out.println("\n" + this);
        System.out.println("Which item would you like to equip? (0 - 8) | -10 if done.");
        eq = errorHandlerInt(8);
	    if (eq == -10){System.out.println("\033[H\033[2J");
	    break;}
	    if (eq > 8 || eq < 0){
	        System.out.print("\033[H\033[2J");
	        System.out.println("ERROR: Item slot invalid.");
	    }
	   
	    else if (slots[eq/3][eq%3] == null){
	        System.out.print("\033[H\033[2J");
	        System.out.println("ERROR: Item slot null.");
	    }
	   
	    else if (slots[eq/3][eq%3].getReq() > lvl){
	        System.out.println("\033[H\033[2J");
	        System.out.println("This is too high level for you!");
	    }
	   
	    else if (slots[eq/3][eq%3].getEslot() == -1){
	        System.out.println("\033[H\033[2J");
	        System.out.println("You can't wear this item.");
	    }
	    else {
	        System.out.println("\033[H\033[2J" + "You just equiped a " + equip(eq));
	    }
        }
            
    }
    
    //view handler
    public void interactview(){
        int v = 0;
        System.out.println("\033[H\033[2J");
        while (v != -10){
        System.out.println("\n" + this);
        System.out.println("Which item would you like to view? (0 - 8) | -10 if done.");
        v = errorHandlerInt(8);
        if (v == -10){System.out.println("\033[H\033[2J");
        break;}
	    if (v > 8 || v < 0){
	        System.out.print("\033[H\033[2J");
	        System.out.println("ERROR: Item slot invalid.");
	    }
	   
	    else if (slots[v/3][v%3] == null){
	        System.out.print("\033[H\033[2J");
	        System.out.println("ERROR: Item slot null.");
	    }
        else {System.out.println("\033[H\033[2J" + slots[v/3][v%3].about() + "\nType anything to go back.");
            try {
                in.readLine();
                }
            catch ( IOException e) { }
            System.out.println("\033[H\033[2J");
        }
        }
    }
    
    //sell handler
    public int interactsell(String Town){
        int s = 0;
        int gain = 0;
        if (Town.equals("null") || Town.equals("Boss")){
            System.out.println("\033[H\033[2J" + "You're not in a town!");
            return gain;
        }
        System.out.println("\033[H\033[2J");
        while (s != -10){
        System.out.println("\n" + this);
        System.out.println("Which item slot would you like to sell? (0 - 8) | -10 if done.");
        s = errorHandlerInt(8);
	    if (s == -10){break;}
	    if (s > 8 || s < 0){
	        System.out.print("\033[H\033[2J");
	        System.out.println("ERROR: Item slot invalid.");
	        return gain;
	    }
	    if (slots[s/3][s%3] == null){
	        System.out.print("\033[H\033[2J");
	        System.out.println("ERROR: Item slot null.");
	        return gain;
	    }
	    else {
	        System.out.println("Are you sure? Y/N");
	        String confirm = "";
	        try{
	            confirm = in.readLine();
	        }
	        catch (IOException e) { }
	        if (confirm.equals("Y")){
	            System.out.println("\033[H\033[2J" + "You just sold a " + slots[s/3][s%3] + " for " + (slots[s/3][s%3].getGold() * .75) + " gold");
	            gain += (sell(s) * .75);
	            }
	        else System.out.println( "\033[H\033[2J" );
	        }
	    }
	    System.out.println("\033[H\033[2J");
	    return gain;
    }
    
    //buy handler
    public int interactbuy(int g, int l, int type){
        Shop temp = new Shop(type, l);
        System.out.println("\033[H\033[2J");
        int gain = 0;
        int c = 0;
        while (c != -10){
            System.out.println(temp + "\nWhat do you wish to buy? " + "(0 - " + (temp.getLength() - 1) + ") -10 if you're done!") ;
            c = errorHandlerInt(temp.getLength()-1);
            if (c == -10){break;}
            
            if (c > temp.getLength() - 1 || c < 0){
                System.out.println("\033[H\033[2J" + "\nThis is not an item in the store.");
            }
            else if (g < (temp.getItem(c)).getGold()){
                System.out.println("\033[H\033[2J" + "\nYou're too poor, you can't buy this.");
            }
            
            else if (!this.spaceCheck()) {
                System.out.println("\033[H\033[2J" + "\nYou have no space in your inventory.");
            }
            
            else {
	            System.out.println("Are you sure? Y/N");
	            String confirm = "";
	            try{
	                confirm = in.readLine();
	            }
	            catch (IOException e) { }
	            if (confirm.equals("Y")){
	                System.out.println("\033[H\033[2J" + "You just bought a " + temp.getItem(c) + " for " + this.buy(temp.getItem(c)) + " gold");
	                gain -= (temp.getItem(c)).getGold();
	                g += gain;
	                }
	            else System.out.println("\033[H\033[2J");
                }  
        }
        System.out.println("\033[H\033[2J");
        return gain;
    }
    
    public int strEval(){
        int sum = 0;
        for (Item n: equipment){
            if (n == null){
                sum+= 0;
            }
            else {sum += n.getStrength();}
        }
        return sum;
    }
    
    public int defEval(){
        int sum = 0;
        for (Item n: equipment){
            if (n == null){
                sum+= 0;
            }
            else {sum += n.getDef();}
        }
        return sum;
    }
    
    public int getstrtot(){
        strTotal = this.strEval();
        return strTotal;
    }
    public int getdeftot(){
        defTotal = this.defEval();
        return defTotal;
    }
    
    public int interactuse(){
        int use = 0;
        int ret = 0;
        System.out.println("\033[H\033[2J");
        while (use != -10){
        System.out.println("\n" + this);
        System.out.println("Which item would you like to use? (0 - 8) | -10 if done.");
        use = errorHandlerInt(8);
	    if (use == -10){break;}
	    if (use > 8 || use < 0){
	        System.out.print("\033[H\033[2J");
	        System.out.println("ERROR: Item slot invalid.");
	    }
	   
	    else if (slots[use/3][use%3] == null){
	        System.out.print("\033[H\033[2J");
	        System.out.println("ERROR: Item slot null.");
	    }
	   
	    else if (slots[use/3][use%3].getEslot() != -1){
	        System.out.println("\033[H\033[2J");
	        System.out.println("You can't use this item.");
	    }
	    else {
	        System.out.println("You just used a " + slots[use/3][use%3] + " potion.");
	        ret = slots[use/3][use%3].getHealth();
	        drop(use);
	        return ret;
	    }
        }
        return ret;
    }
    
    
    public static void main(String[] args){
        Inventory yeah = new Inventory();
        Item m0nique = new Item(500,"m0nique", 5, 2, "Mad m0nique and unique.");
        Item Un1que = new Item(600, "Un1que", 5, 2, "Too m0nique to Un1que.");
        
        yeah.buy(m0nique);
        yeah.buy(Un1que);
        for (int x = 1; x < 5; x++){
            yeah.buy(Un1que);
            
        }
        
        yeah.interact( 10, 500, "Dragnok");
    }
}