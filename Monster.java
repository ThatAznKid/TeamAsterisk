public class Monster extends Character {

    public Monster() {
	super();
	_hitPts = 3;
	_strength = 1;
	_defense = 1;
    }

    public String moveSet(){
	return "";
    }
    
    public void normalize(){
    }

    public void specialize(){
    }

    public void specialize2(){
    }

    public String about(){
        return "";
    }

    public int expWorth () { 
	return ((int) (Math.random() * 5)); 
    }
}//end class Monster
