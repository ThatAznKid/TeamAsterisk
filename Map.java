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
    private Tile[][] _mop = new Tile[12][12] ;	
    private int xcord;
    private int ycord;
    
    public Map(){
	isr = new InputStreamReader( System.in );
    in = new BufferedReader( isr );
	xcord = 0;
	ycord = 0;
	int ctr = 1;
	
	for (int y = 0; y < _mop.length; y++) { 
	    for (int x = 0; x < _mop[y].length; x++) {
		Object key = _map[y][x];
	        if (key.equals("o") || key.equals("T") || key.equals("R") || key.equals("A") || key.equals("C")){
		    _mop[y][x] = new Town(townDef(x,y), ctr);
		    ctr += 1;
			}
		else if (key.equals("+")){
		    _mop[y][x] = new Road();
		}
		else if (key.equals("=") || key.equals("|")){
		    _mop[y][x] = new Bridge();
		}
		else if (key.equals("B")){
		   _mop[y][x] = new Boss();
		}
		else _mop[y][x] = new Blank();
	    }
	}
    }

    public String toString() {
	String s = "";
	for (int y = 0; y < _map.length; y++) { 
	    for (int x = 0; x < _map[y].length; x++) {
		if (y == ycord && x == xcord){
		    s += " x ";
		}
		else s += " " + _map[y][x] + " "; 
	    }
	    s+="\n";
	}
	return s;
    }

    public String townDef(int x, int y){
	if (x < 3 && y < 3) {
	    return "Dragnok";
	}
	if (x > 8 && y < 3) {
	    return "Yeevile";
        }
	if (x < 3 && y > 8) {
	    return "Cernar";
	}
	if (x > 8 && y > 8) {
	    return "Wayner";
	}
	return "";
    }

    public Tile tileGet(int x, int y){
    	return _mop[y][x];
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
    
		
