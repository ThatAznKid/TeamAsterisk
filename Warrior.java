public class Warrior extends Character {

    private String _name = "J. Doe"; 
  
    public Warrior() {
	_hitPts = 25;
	_strength = 6;
	_defense = 0; 
	_EXP = 0;
	_daysAlive = 0; 
	_origHitPts = _hitPts;  
	_Bstrength = 0;
    }

    public Warrior( String name ) {
	this();
	_name = name;
    }

    public String getName() { return _name; }

    public void specialize() {
	_Bstrength = _strength + 2;
    }

    public void normalize() {
	_Bstrength = _strength;
    }

    public String moveSet(){
	String s = "";
	s += "\t1: Basic Attack\n\t2: Offensive Charge\n\t3: Use Potion.\n";
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
	s += "WARRIOR: \n";
	s += "A renowned fighter whose courage is unquestioned and his might undisputed. He indefatigably fights against the forces of evil and happens to be around and up for slime fighting.\n";
	return s;
    }

}//end class Warrior
