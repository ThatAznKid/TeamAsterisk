public class Monster extends Character {

    public Monster() {
	super();
	_hitPts = 3;
	_strength = 1;
	_defense = 1;
	_level = 1;
	_name = "Green Slime";
    }
    
    public Monster(int lvl, String name){
        _level = lvl;
        _hitPts = (_level * 3) - 1;
        _strength = (_level * 2);
        _defense = (_level * 2);
        _name = name;
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
    
    public String getName(){
        return _name;
    }
    
    public String toString(){
        return _name;
    }

    public int expWorth() { 
	return ((_level * 3) + (int)(Math.random() * 10)); 
    }
    public int goldWorth() { 
	return ((_level * 3) + (int)(Math.random() * 10)); 
    }
    
    
    public int attack ( Character opponent ) { 
	int holder = opponent.getdefense() + opponent.getdeftot();
	double modifier = 1 - ( holder / ( 50 + holder ));
	int damage = (int) (modifier * _strength); 
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

}//end class Monster
