public class Shop{
    private Object[][] items;
    private Item[] potions = new Item[4];
    private Item[] equips = new Item[3];
    private String[] potname = {"10HP", "20HP", "30HP", "50HP", "100HP"};
    private String[] equipname = {"Overalls", "Weapon", "Talisman"};
    private int[] potprice = {100, 350, 800, 1200, 2000};
    private int[] eqprice = {500,1000,1500,2500};
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
                rows[0] = new Item(eqprice[lvl/10 - 1], equipname[ctr], lvl, ctr, "A " + equipname[0]);
                rows[1] = eqprice[lvl/10 - 1];
                ctr ++;
                }
            isr = new InputStreamReader( System.in );
    	    in = new BufferedReader( isr );
            }
        }
    
    public int interactbuy(int g, int l, int type){
        Shop temp = new Shop(type, l);
        System.out.println("\033[H\033[2J");
        System.out.println(this + "\n What do you wish to buy?" + "1 - " + Shop.length + "-10 if you're done!") ;
        int gain = 0;
        int c = 0;
        while (c != -10){
            try {
                c = Integer.parseInt(in.readLine());
            }
            catch (IOException e) { }
            
            if (c > Shop.length - 1 || (c < 0 && c != -10)){
                System.out.println("\033[H\033[2J");
                return gain;
            }
            
            
            }
        }
    }
    
        public static void main(String[] args){
            Shop tis = new Shop(0,0);
            Shop tat = new Shop(1,10);
            
            System.out.println("tis shop:\n" + tis); 
            System.out.println("tat shop:\n" + tat); 
        }
    }