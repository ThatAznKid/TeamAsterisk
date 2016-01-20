public class Tile{
    private String type;

    public Tile(){
	type = "null";
    }    
    public Tile(Object in){
	type = process(in);
    }

    public String process(Object key){
	if (key.equals("o") || key.equals("T") || key.equals("R") || key.equals("A") || key.equals("C")){
	    return "town";
	}
	if (key.equals("+")){
	    return "road";
	}
	if (key.equals("=") || key.equals("|")){
	    return "bridge";
	}
	if(key.equals("B")){
	    return "boss";
	}
	return "space";
    }
}
