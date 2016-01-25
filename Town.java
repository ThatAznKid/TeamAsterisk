public class Town extends Tile{
    private int num;
    
    public Town(String name, int blocknum){
	town = name;
	isSafe = true;
	num = blocknum;
    }
    
    public String toString(){
    	return "in " + towndesc(town);
    }

    public void option(int n){
	if (n == 0){
	    System.out.println("Nice job, scrub");
	}
	else System.out.println ("Nice try");
    }

    public String towndesc(String town){
	if (town.equals("Dragnok")) {return "Dragnok, the first town.";}
	if (town.equals("Yeevile")) {return "Yeevile, the second town.";}
	if (town.equals("Cernar"))  {return "Cernar, the third town.";}
	if (town.equals("Wayner"))  {return "Wayner, the fourth and final town.";}
	else return "none";
    }
}
