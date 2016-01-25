public class Blank extends Tile{
    public Blank(){
	town = "null";
	isSafe = false;
    }
    
    public String toString(){
    	return "I got a blank space baby, and I'll write your name."; //easter egger
    }
    
    public void option(int n){
	if (n == 0){
	    System.out.println("Nice job, scrub");
	}
	else System.out.println ("Nice try");
    } 
}
