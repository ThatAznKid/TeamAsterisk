public class Mage extends Character {
    
    private String _name = "J. Doe"; 
   
    public Mage() {
	_hitPts = 99999;
	_strength = 99999;
	_defense = 0; 
	_EXP = 0;
	_daysAlive = 0; 
	_origHitPts = _hitPts; 
	_Bstrength = 0;
    }

    public Mage( String name ) {
	this();
	_name = name;
    }

    public String getName() { return _name; }

    public void specialize() {
	_Bstrength = _strength + 4;
    }

    public void normalize() {
	_Bstrength = _strength;
    }

    public String moveSet(){
	String s = "";
	s += "\t1: Basic Attack\n\t2. Mana Blast\n";
	return s;
    }

     public int attack ( Character opponent ) { 
	int holder = opponent.getTalisman();
	double modifier = 1 - ( holder / ( 50 + holder ));
	int damage = (int) (modifier * _strength); 
	if (damage < 0) { 
	    damage = 1; 
	} 
	opponent.lowerHP (damage); 
	return damage; 
    }

    public String about(){
	String s = "";
	s += "MAGE: \n";
	s += "A connoisseur of the ancient arts and having years of experience studying modern magic, the mage wishes to study the new foes that appear before him in order to forward his knowledge.\n";
       	return s;
    }

}//end class Mage
