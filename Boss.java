public class Boss extends Tile{
    private int power;
    
    public Boss(){
	town = "Boss";
	isSafe = false;
	power = 1;
    }
    
    public String toString(){
    	return "in the very heart of the mountain. You feel goosebumps as you realize someone (or something...) is rapidly approaching...";
    }

    public void option(int n){
	if (n == 0){
	    System.out.println("Nice job, scrub");
	}
	else System.out.println ("Nice try");
    }
}
