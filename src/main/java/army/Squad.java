//Squad
package army;
import com.github.javafaker.Faker;
import java.util.ArrayList;
import java.util.Locale;

public class Squad implements Unit{
  private String title;
  private String id;
  private String base;
  private String location;
  private Leader sgt;
  private Leader cpl;
  private ArrayList<Unit> privates = new ArrayList<Unit>();
  private Faker faker = new Faker();
  private Faker franceFaker = new Faker(new Locale("fr_FR"));
  public Squad(Unit plt){
    //Squad name
    this.id = "Able";
    this.title = "Able Squad";
    this.base = plt.getLocation();
    this.location = "Ramelle";
    //leadership
    this.sgt = new Sergeant("Mike", this);
    this.cpl = new Corporal("Upham", this);
    //infantry
    Unit pvt1 = new Private("Ryan", this);
    Unit pvt2 = new Private("Caparzo", this);
    Unit pvt3 = new Private("Jackson", this);
    Unit pvt4 = new Private("Rieben", this);
    Unit pvt5 = new Private("Mellish", this);
    Unit pvt6 = new Private("Wade", this);
    this.privates.add(pvt1);
    this.privates.add(pvt2);
    this.privates.add(pvt3);
    this.privates.add(pvt4);
    this.privates.add(pvt5);
    this.privates.add(pvt6);
  }
  public Squad(String name, Unit plt){
    //Squad name
    this.id = name;
    this.title = name + " Squad";
    this.base = plt.getLocation();
    this.location = franceFaker.address().city();
    //leadership
    this.sgt = new Sergeant(this.faker.name().lastName(), this);
    this.cpl = new Corporal(this.faker.name().lastName(), this);
    //infantry
    int randomSqSize = (int)(Math.random()*7) + 2;
    for(int i = 0; i < randomSqSize; i++){
      Unit randomPvt = new Private(this.faker.name().lastName(), this);
      this.privates.add(randomPvt);
    }
  }
  //methods
  public void attack(){
    System.out.println(this.title + " is attacking...");
  }
  public void defend(){
    System.out.println(this.title + " is defending...");
  }
  public String lineUp(){
    //squad info
    String outStr = this.title.toUpperCase();
    outStr += " (Headcount: " + this.getSize() + ")\n"
            + this.sgt.reportTitle() + "\n"
            + this.cpl.reportTitle() + "\n";
    //infantry info
    for(int i = 0; i < privates.size(); i++){
      outStr += "\t" + privates.get(i).reportTitle() + "\n";
    }
    return outStr;
  }
  public int getSize(){
    int count = 0;
    if(this.sgt.isAlive()){
      count++;
    }
    if(this.cpl.isAlive()){
      count++;
    }
    for(int i = 0; i < this.privates.size(); i++){
      Soldier pvt = (Private) this.privates.get(i);
      if(pvt.isAlive()){
        count++;
      }
    }
    return count;
  }
  public int getNumOfSubUnits(){
    return 0;
  }
  public ArrayList<Unit> getSubUnits(){
    return this.privates;
  }
  public String getBase(){
    return this.base;
  }
  public String getLocation(){
    return this.location;
  }
  public Leader getLeader(){
    if(!this.sgt.isAlive()){
      if(!this.cpl.isAlive()){
        for(int i = 0; i < this.privates.size(); i++){
          Soldier pvt = (Private) this.privates.get(i);
          if(pvt.isAlive()){
            System.out.println(pvt.reportTitle() + " promoted to Corporal");
            Leader promotedPrivate = new Corporal(pvt.reportTitle(), this);
            return promotedPrivate;
          }
        }
        System.out.println("Everyone in " + this.title + " is dead.");
        return null;
      }
      return this.cpl;
    }
    return this.sgt;
  }
  public String reportTitle(){
    return this.title;
  }
}
