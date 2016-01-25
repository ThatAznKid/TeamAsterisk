public class Monster3 extends Character {

    public Monster3() {
	super();
	_hitPts = 30;
	_strength = 14;
	Talisman = 10; 
	Shield = 10; 
	_level = 11;
	_name = "Goblin Warrior";
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

}//end class Monster3


