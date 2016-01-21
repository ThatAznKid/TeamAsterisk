public class Boss extends Tile{
    private int power;
    
    public Boss(){
	town = "Boss";
	isSafe = false;
	power = 1;
    }

    public void option(int n){
	if (n == 0){
	    System.out.println("Nice job, scrub");
	}
	else System.out.println ("Nice try");
    }
}
