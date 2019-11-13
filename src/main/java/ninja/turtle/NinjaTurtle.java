package ninja.turtle;

import org.apache.hadoop.mapred.Master;

public class NinjaTurtle {
    private String name;
    private String color;
    private String weapon;
    private MasterPiece mp;

    public NinjaTurtle(String name){
        if(name.equals("Leonardo") || name.equals("leonardo")){
            this.name = "Leonardo";
            this.color = "Blue";
            this.weapon = "Swords";
            this.mp = new MasterPiece("The Last Supper", "Santa Maria del Grazie, Milan", 1498);
        }
        else if(name.equals("Donatello") || name.equals("donatello")){
            this.name = "Donatello";
            this.color = "Purple";
            this.weapon = "Staff";
            this.mp = new MasterPiece("Wooden Crucifix", "Santa Croce, Firenze", 1425);
        }
        else if(name.equals("Raphael") || name.equals("raphael")){
            this.name = "Raphael";
            this.color = "Red";
            this.weapon = "Sais";
            this.mp = new MasterPiece("The School of Athens", "Apostolic Palace, Vatican City", 1511);
        }
        else if(name.equals("Michelangelo") || name.equals("michelangelo")){
            this.name = "Michelangelo";
            this.color = "Orange";
            this.weapon = "NunChucks";
            this.mp = new MasterPiece("David", "Uffizi Gallery, Firenze", 1504);
        }
        else if(name.equals("Splinter") || name.equals("splinter") || name.equals("Sensei") || name.equals("sensei")){
            this.name = "Master Splinter";
            this.color = "Black";
            this.weapon = "Cane";
            this.mp = new MasterPiece("The Ninja Turtles", "Sewers of New York City", 1983);
        }
        else{
            this.name = "Paolo";
            this.color = "Green";
            this.weapon = "Java";
            this.mp = new MasterPiece("Rose Thorns", "Getty Villa, Los Angeles", 2018);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public MasterPiece getMp() {
        return mp;
    }

    public void setMp(MasterPiece mp) {
        this.mp = mp;
    }
}
