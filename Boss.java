public class Boss extends Character {

    public Boss() {
	super();
	_hitPts = 75;
	_strength = 25;
	Talisman = 22; 
	Shield = 22; 
	_level = 25;
	_name = "Dark Arcane Magician";
    }

    public String moveSet(){
	return "";
    }
    
    public void normalize(){
    }
    
    public String toString(){
    	return "in the very heart of the mountain. You feel goosebumps as you realize someone (or something...) is rapidly approaching...";
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

}//end class Boss


