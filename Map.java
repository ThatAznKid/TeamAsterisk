import java.io.*;
import java.util.*;

public class Map {
    private static InputStreamReader isr;
    private static BufferedReader in;
    
    private static final Object[][] _map = {{"o","o","o"," "," "," "," "," "," ","o","o","o"},
					    {"o","T","o","+","+","=","=","+","+","o","A","o"},
					    {"o","o","o"," "," "," "," "," "," ","o","o","o"},
					    {" "," "," "," "," ","B","=","+"," "," ","+"," "},
					    {" "," "," "," "," "," "," ","|"," "," ","|"," "},
					    {" ","+","=","=","+"," "," ","|"," "," ","|"," "},
					    {" ","|"," "," ","+"," ","+","+"," "," ","|"," "},
					    {" ","+"," "," ","+","=","+"," "," "," ","+"," "},
					    {" ","+"," "," "," "," "," "," "," "," ","+"," "},
					    {"o","o","o"," "," "," "," "," "," ","o","o","o"},
					    {"o","R","o","+","+","=","=","+","+","o","C","o"},
					    {"o","o","o"," "," "," "," "," "," ","o","o","o"}};
    private static Tile[12][12] _mop;	
    private int xcord;
    private int ycord;
    
    public Map(){
	isr = new InputStreamReader( System.in );
    	in = new BufferedReader( isr );
	xcord = 0;
	ycord = 0;
    }

    public String toString() {
	String s = "";
	for (int x = 0; x < _map.length; x++) { 
	    for (int y = 0; y < _map[x].length; y++) {
		if (x == ycord && y == xcord){
		    s += " x ";
		}
		else s += " " + _map[x][y] + " "; 
	    }
	    s+="\n";
	}
	return s;
    }
    
    //accessors and mutators for x and y
    public int getx() {
	return xcord;
    }
    public void setx(int newx) {
	xcord = newx;
    }

    public int gety() {
	return ycord;
    }
    public void sety(int newy) {
	ycord = newy;
    }

    //movement
    public void move(String dir){
	if (dir.equals("w") && (ycord - 1) >= 0){
	    if (_map[ycord - 1][xcord].equals(" ")){
		    return;}
	    else sety(ycord - 1);
	}
	if (dir.equals("s") && (ycord + 1) < 12){ 
	    if (_map[ycord + 1][xcord].equals(" ")){
		    return;}
	    else sety(ycord + 1);
	}

	if (dir.equals("a") && (xcord - 1) >= 0){
	    if (_map[ycord][xcord - 1].equals(" ")){
		    return;}
	    else setx(xcord - 1);
	}
	
	if (dir.equals("d") && (xcord + 1) < 12){
	    if (_map[ycord][xcord + 1].equals(" ")){
		    return;}
	    else setx(xcord + 1);
	}
    }
	

    public static void main(String[] args){
    Map test = new Map();
    String holder = "";
    while (holder != "EXIT"){
	System.out.println(test);
	try {
	    holder = in.readLine();
	}
	catch ( IOException e ){ }
	test.move(holder);
    }
    }

}//end map
    
		
