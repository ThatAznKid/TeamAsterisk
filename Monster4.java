public class Monster4 extends Character {

    public Monster4() {
	super();
	_hitPts = 44;
	_strength = 14;
	Talisman = 15; 
	Shield = 15; 
	_level = 17;
	_name = "Bloodred Wyvern";
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

    public int attack ( Character opponent ) { 
	int holder = opponent.getShield();
	double modifier = 1 - ( holder / ( 50 + holder ));
	int damage = (int) (modifier * _strength); 
	if (damage < 0) { 
	    damage = 1; 
	} 
	opponent.lowerHP (damage); 
	return damage; 
    }

}//end class Monster4


