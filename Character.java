import java.io.*;
import java.util.*;
public abstract class Character {

    protected int _hitPts;
    protected int _strength;
    protected int _defense; 
    protected int _EXP;
    protected int _origHitPts; 
    protected int _daysAlive;
    protected int _level; 
    protected int _Bstrength;
    protected int _GOLD;
    protected String _name;
    protected int strtot;
    protected int deftot;
    private InputStreamReader isr;
    private BufferedReader in;

    public Character() {
	_hitPts = 1;
	_strength = 0;
	_defense = 0; 
	_EXP = 0;
	_origHitPts = _hitPts; 
	_level = 1;
    }

    public void printWithDelay (String s) { 
	for ( int x = 0 ; x < s.length() ; x++ ) { 
	    System.out.print (s.substring(x,x+1)); 
	    try {
		Thread.sleep(20); 
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }// end printWithDelay
    
    public int getHealth() {
	if (_hitPts < 0){
	    return 0;
	}
	return _hitPts;
    }
    
    public int getGold(){
    return _GOLD; 
    }
    public int setGold(int g){
      _GOLD = g;
      return _GOLD;
    }

    public boolean isAlive() {
	return _hitPts > 0;
    }

    public abstract int attack( Character opponent );//end attack

    public void lowerHP( int damageInflicted ) {
	_hitPts = _hitPts - damageInflicted;
    }
    public void gainEXP (int exp) { 
	_EXP = _EXP + exp; 
    }
    public void gainGOLD (int gold) {
    _GOLD += gold;    
    }
    
    public abstract void specialize();

    public abstract void normalize();

    public abstract String moveSet();

    public String getName(){
	return "???";
    }

    public void daysAliveIncrement () { 
	_daysAlive += 1;
    }  

    public void setHitPts (int hitPts) { 
	_hitPts = hitPts;
    } 
    
    public int getHitPts () { 
	return _hitPts; 
    } 
    
    public void setOrigHitPts (int hitPts) { 
	_origHitPts = _hitPts;
    } 

    public int getOrigHitPts () { 
	return _origHitPts; 
    }

    public void setStrength(int str) { 
	_strength = str; 
    } 
    
    public int getStrength () { 
	return _strength;
    } 
    
    public void setDefense (int def) { 
	_defense = def; 
    } 
    
    public int getDefense () { 
	return _defense; 
    } 
    
    public int getDaysAlive() { 
	return _daysAlive;
    } 

    public abstract String about(); 
    
    public int getLevel () { 
	return _level; 
    }
    
    public int getstrtot(){
  return strtot;
    }
    public int getdeftot(){
  return deftot;
    }
    
    public void setstrtot(int s){
  strtot = s;
    }
    public void setdeftot(int d){
  deftot = d;
    }
    

    public int levelUp () {
    isr = new InputStreamReader( System.in );
    in = new BufferedReader( isr );
	    if ((40 * _level) < _EXP) { 
	    _EXP -= 40 * _level;
	    _level += 1;  
	    String s;  
	    int h1,h2,h3;
	    s= "Congrats. You leveled up!\n"; 
	    s+= "You are now " + getLevel() + "!\n"; 
	    printWithDelay(s); 
	    s= "Your stats have increased as well!\n"; 
	    h1 = (int)(Math.random() * 5) + 1; 
	    h2 = (int)(Math.random() * 4) + 1; 
	    h3 = (int)(Math.random() * 4) + 1; 
	    s+= "Your health as been increased by " + h1 + " point(s)!\n"; 
	    setHitPts(getOrigHitPts() + h1); 
	    setOrigHitPts(getHitPts());
	    s+= "Your strength as been increased by " + h2 + " point(s)!\n";
	    setStrength(getStrength() + h2); 
	    s+= "Your defense as been increased by " + h3 + " point(s)!\n"; 
	    setDefense(getDefense() + h3); 
	    s+= "Type anything to go back.";
	    printWithDelay (s);
        try {
          in.readLine();
             }
        catch ( IOException e) { }
	}
	return _level;
    } 
    
    public int getEXP () { 
	return _EXP;
    } 

    public int getdefense() { 
	 return _defense; 
    }
}//end class Character
