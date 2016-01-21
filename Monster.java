public class Monster extends Character {

    public Monster() {
	super();
	_hitPts = 3;
	_strength = 1;
	_defense = 1;
	Talisman = 0; 
	Shield = 0;
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

}//end class Monster
