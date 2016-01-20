public class Tile{
    private String type;

    public Tile(){
	type = "null";
    }    
    public Tile(String in){
	type = process(in);
    }

    public String process(String key){
	if (key.equals("o") || key.equals("T") || key.equals("R") || key.equals("A") || key.equals("C")){
	    return "town";
	}
	if (key.equals("+")){
	    return "road";
	}
	if (key.equals("=")){
	    return "bridge";
	}
	if(key.equals("B")){
	    return "boss";
	}
	return "space";
    }
}
