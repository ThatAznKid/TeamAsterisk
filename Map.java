public class Map { 
    
    private static Object[][] _map = {{"o","o","o"," "," "," "," "," "," ","o","o","o"},
 			       {"o","T","o","+","+","=","=","+","+","o","A","o"},
 			       {"o","o","o"," "," "," "," "," "," ","o","o","o"},
 			       {" ","+"," "," "," ","B","=","+"," "," ","+"," "},
			       {" ","|"," "," "," "," "," ","|"," "," ","|"," "},
 			       {" ","+","=","=","+"," "," ","|"," "," ","|"," "},
 			       {" ","|"," "," ","+"," ","+","+"," "," ","|"," "},
 			       {" ","+"," "," ","+","=","+"," "," "," ","+"," "},
 			       {" ","+"," "," "," "," "," "," "," "," ","+"," "},
 			       {"o","o","o"," "," "," "," "," "," ","o","o","o"},
   			       {"o","R","o","+","+","=","=","+","+","o","C","o"},
 			       {"o","o","o"," "," "," "," "," "," ","o","o","o"}};
    private int xcord;
    private int ycord;
    
    public Map(){
	xcord = 1;
	ycord = 1;
    }

    public String toString() {
	String s = "";
	for (int x = 0; x < _map.length; x++) { 
	    for (int y = 0; y < _map[x].length; y++) {
		if (x == xcord && y == ycord){
		    s += " x ";
		}
		else s += " " + _map[x][y] + " "; 
	    }
	    s+="\n";
	}
	return s;
    }

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
    
    public static void main(String[] args){
    Map test = new Map();
    System.out.println(test);
    }


}//end map
    
		
