public class Map { 
    
    private Object[][] _map; 
    
    public Map {
	_map = new Object[3][3]; 
	
    } 
    
    public String toString() {
	String s = "";
	for (int x = 0; x < 3; x++) { 
	    for (int y = 0; y < 3; y++) { 
		s+= _map[x][y]; 
	    } 
	    s+="\n";
	}
	return s;
    }

}//end map
    
		
