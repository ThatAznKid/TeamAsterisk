public class Town extends Tile{
    private int num;
    
    public Town(String name, int blocknum){
	town = name;
	isSafe = true;
	num = blocknum;
    }

    public void option(int n){
	if (n == 0){
	    System.out.println("Nice job, scrub");
	}
	else System.out.println ("Nice try");
    }
}
