public class Monster8 extends Character {

    public Monster8() {
	super();
	_hitPts = 55;
	_strength = 25;
	Talisman = 20; 
	Shield = 20; 
	_level = 20;
	_name = "Ragged Dragon";
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

}//end class Monster8



    
