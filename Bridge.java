public class Bridge extends Tile{
    private int levels;
    
    public Bridge(){
	town = "null";
	isSafe = false;
	levels = 0;
    }
    
    public void option(int n){
	if (n == 0){
	    System.out.println("Nice job, scrub");
	}
	else System.out.println ("Nice try");
    } 
}
