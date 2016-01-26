public class Mage extends Character {
    
    private String _name = "J. Doe"; 
   
    public Mage() {
	_hitPts = 25;
	_strength = 6;
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
	s += "\t1: Basic Attack\n\t2. Mana Blast\n\t3. Use Potion.\n";
	return s;
    }

    public int attack ( Character opponent ) { 
	int holder = opponent.getdefense();
	double modifier = 1 - ( holder / ( 50 + holder ));
	int damage = (int) (modifier * (_strength + this.getstrtot())); 
	if (damage < 0) { 
	    damage = 1; 
	} 
	damage = chancer(damage);
	opponent.lowerHP (damage); 
	return damage; 
    }
    
    public int chancer(int d){
        if (d < 10){return d + (int)(3 * Math.random());}
        if (d < 20){return d - 5 + (int)(10 * Math.random());}
        if (d < 30){return d - 10 + (int)(10 * Math.random());}
        else return d - 15 + (int)(20 * Math.random());
    }

    public String about(){
	String s = "";
	s += "MAGE: \n";
	s += "A connoisseur of the ancient arts and having years of experience studying modern magic, the mage wishes to study the new foes that appear before him in order to forward his knowledge.\n";
       	return s;
    }

}//end class Mage
