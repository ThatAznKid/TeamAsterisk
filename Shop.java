import java.io.*;
import java.util.*;

public class Shop{
    private Object[][] items;
    private Item[] potions = new Item[4];
    private Item[] equips = new Item[3];
    private String[] potname = {"10HP", "20HP", "30HP", "50HP", "100HP"};
    private String[][] equipname = {{"Rags", "Stick", "Stone"},
                                  {"Leather", "Dagger", "Ruby"},
                                  {"Chainmail", "Fireblade", "Diamond"},
                                  {"Runeforge", "Trident", "Amber"}};
    private String[][] equipdesc = {{"Pieces of strung together hide.", "A tree branch.", "A stone pendant."},
                                    {"A set of leather armour.", "A small inconspicuous dagger.", "A ruby pendant."},
                                    {"A set of iron chainmail armour.", "A blazing blade of fire.", "A diamond pendant."},
                                    {"Set of armour forged from the strongest runes.", "The trident of Poseidon.", "An amber pendant."}};
    private int[] potprice = {100, 200, 300, 400, 600};
    private int[] eqprice = {50, 200, 450, 750};
    private int[] potheal = {10,20,30,50,100};
    private InputStreamReader isr;
    private BufferedReader in;
    
    public String toString(){
        String retstr = "Item | Price \n";
        for (Object[] r : items){
            for (Object c : r){
                retstr += "[" + c + "]";
            }
            retstr += "\n";
        }
        return retstr;
    }
    
    public Item getItem(int c){
        return (Item)items[c][0];
    }
    public int getLength(){
        return items.length;
    }
    
    public Shop(int type, int lvl){
        int ctr = 0;
        if (type == 0){
            items = new Object[5][2];
            for (Object[] rows : items){
                rows[0] = new Item(potprice[ctr], potname[ctr], "A health potion.", potheal[ctr]);
                rows[1] = potprice[ctr];
                ctr++;
                }
            isr = new InputStreamReader( System.in );
    	    in = new BufferedReader( isr );
            }
        ctr = 0;
        if (type == 1){
            items = new Object[3][2];
            for (Object[] rows : items){
                rows[0] = new Item(eqprice[lvl/5 - 1], equipname[lvl/5 - 1][ctr], lvl, ctr, equipdesc[lvl/5 - 1][ctr]);
                rows[1] = eqprice[lvl/5 - 1];
                ctr ++;
                }
            isr = new InputStreamReader( System.in );
    	    in = new BufferedReader( isr );
            }
        }
    
        public static void main(String[] args){
            Shop tis = new Shop(0,0);
            Shop tat = new Shop(1,10);
            
            System.out.println("tis shop:\n" + tis); 
            System.out.println("tat shop:\n" + tat); 
            
        }
    }