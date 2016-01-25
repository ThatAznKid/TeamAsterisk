public class Item{
    private int gold;
    private String name;
    private int req;
    private int eslot;
    private String desc;
    private int health;
    
    public Item(int g, String n, int r, int e, String d){
        gold = g;
        name = n;
        req = r;
        eslot = e;
        desc = d;
        health = -1;
    }
    
    public Item(int g, String n, String d, int h){
        gold = g;
        name = n;
        req = 0;
        eslot = -1;
        desc = d;
        health = h;
    }
    
    
    
    public String toString(){
        return name;
    }

    public String about(){
        return ("Name: " + name + "\nWorth: " + gold + " gold\nLevel Requirement: " + req + "\nDescription: " + desc + "\n");
    }
    
    public int getGold(){
        return gold;
    }
    public int getReq(){
        return req;
    }
    public int getEslot(){
        return eslot;
    }
    public int getHealth(){
        return health;
    }
}