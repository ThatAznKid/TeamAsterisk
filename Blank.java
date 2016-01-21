public class Blank extends Tile{
    public Blank(){
	town = "null";
	isSafe = false;
    }
    
    public void option(int n){
	if (n == 0){
	    System.out.println("Nice job, scrub");
	}
	else System.out.println ("Nice try");
    } 
}
