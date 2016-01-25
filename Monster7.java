public class Monster7 extends Character {

    public Monster7() {
	super();
	_hitPts = 36;
	_strength = 18;
	Talisman = 12; 
	Shield = 13; 
	_level = 15;
	_name = "Ancient Golem";
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

}//end class Monster7



    
