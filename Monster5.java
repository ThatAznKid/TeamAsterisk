public class Monster5 extends Character {

    public Monster5() {
	super();
	_hitPts = 7;
	_strength = 3;
	Talisman = 2; 
	Shield = 2; 
	_level = 4;
	_name = "Decaying Skeleton";
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

}//end class Monster5



    
    
