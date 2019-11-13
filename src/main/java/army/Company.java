//Company
package army;
import com.github.javafaker.Faker;
import java.util.ArrayList;
import java.util.Locale;

public class Company implements Unit{
  private String title;
  private String id;
  private String base;
  private String location;
  private Captain cpt;
  private ArrayList<Unit> platoons = new ArrayList<Unit>();
  private Faker faker = new Faker();
  private Faker franceFaker = new Faker(new Locale("fr_FR"));

  public Company(){
    //company info
    this.id = "Charlie";
    this.title = "Charlie Company";
    this.base = "DC";
    this.location = "Neuville";
    //leadership
    this.cpt = new Captain("Miller", this);
    //platoons
    Unit plt1 = new Platoon(1, this);
    Unit plt2 = new Platoon(2, this);
    Unit plt3 = new Platoon(this);
    Unit plt4 = new Platoon(4, this);
    this.platoons.add(plt1);
    this.platoons.add(plt2);
    this.platoons.add(plt3);
    this.platoons.add(plt4);
    //find locations
    for(Unit plt: this.platoons){
      this.location += plt.getLocation();
    }
  }
  public Company(String name){
    //company name
    this.id = name;
    this.title = name + " Company";
    this.base = franceFaker.address().city();;
    this.location = franceFaker.address().city();
    //leadership
    this.cpt = new Captain(this.faker.name().lastName(), this);
    //platoons
    int randomCoSize = (int)(Math.random()*4) + 3;
    for(int i = 0; i < randomCoSize; i++){
      Unit randomPlatoon = new Platoon(i+1, this);
      this.platoons.add(randomPlatoon);
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
    //company info
    String outStr = this.title.toUpperCase();
    outStr += " (Headcount: " + this.getSize() + ")\n"
            + this.cpt.reportTitle() + "\n";
    //platoons info
    for(int i = 0; i < platoons.size(); i++){
      outStr += platoons.get(i).lineUp().replaceAll("(?m)^", "\t");;
    }
    return outStr;
  }
  public int getSize(){
    int count = 0;
    if(this.cpt.isAlive()){
      count++;}
    for(int i = 0; i < platoons.size(); i++){
      count += platoons.get(i).getSize();
    }
    return count;
  }
  public int getNumOfSubUnits(){
    return this.platoons.size();
  }
  public ArrayList<Unit> getSubUnits(){
    return this.platoons;
  }
  public String getBase(){
    return this.base;
  }
  public String getLocation(){
    return this.location;
  }
  public Leader getLeader(){
    if(!this.cpt.isAlive()){
      Leader potentialLeader = null;
      for(Unit u: this.platoons){
        Leader candidate = u.getLeader();
        if(candidate != null){
          if(candidate.reportTitle().substring(8,1).equals("Cpl")
          || candidate.reportTitle().substring(8,1).equals("Sgt")){
            potentialLeader = candidate;
          }else{
            System.out.println(candidate.reportTitle() + " promoted to Captain");
            Leader promotedCandidate = new Captain(candidate.reportTitle(), this);
            return promotedCandidate;
          }
        }
      }
      if(potentialLeader != null){
        return potentialLeader;
      }
      System.out.println("Everyone in " + this.title + " is dead.");
      return null;
    }
    return this.cpt;
  }
  public String reportTitle(){
    return this.title;
  }
}
