public class Monster6 extends Character {

    public Monster6() {
	super();
	_hitPts = 25;
	_strength = 13;
	Talisman = 8; 
	Shield = 8; 
	_level = 9;
	_name = "Ferocious Zombie";
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

}//end class Monster6



    
    

    
    
