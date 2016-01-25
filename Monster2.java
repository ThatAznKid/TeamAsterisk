public class Monster2 extends Character {

    public Monster2() {
	super();
	_hitPts = 18;
	_strength = 9;
	Talisman = 5; 
	Shield = 5; 
	_level = 7;
	_name = "Rabid Wolf";
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

}//end class Monster2

    
