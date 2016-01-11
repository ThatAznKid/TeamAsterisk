public class Warrior extends Character {

    private String _name = "J. Doe"; 
  
    public Warrior() {
	_hitPts = 10;
	_strength = 5;
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
	s += "\t1: Basic Attack\n\t2: Offensive Charge\n";
	return s;
    } 

    public String about(){
	String s = "";
	s += "WARRIOR: \n";
	s += "A renowned fighter whose courage is unquestioned and his might undisputed. He indefatigably fights against the forces of evil and happens to be around and up for slime fighting.\n";
	return s;
    }

}//end class Warrior
