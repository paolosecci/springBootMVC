//Platoon
package army;
import com.github.javafaker.Faker;
import java.util.ArrayList;
import java.util.Locale;

public class Platoon implements Unit{
  private String title;
  private int id;
  private String base;
  private String location;
  private Lieutenant firstLt;
  private Lieutenant secondLt;
  private ArrayList<Unit> squads = new ArrayList<Unit>();
  private String[] abcCodes = new String[]{"Able", "Bravo", "Charlie", "Delta", "Echo"};
  private Faker faker = new Faker();
  private Faker franceFaker = new Faker(new Locale("fr_FR"));

  public Platoon(Unit co){
    //platoon name
    this.id = 3;
    this.title = "Platoon 3";
    this.base = co.getLocation();
    this.location = franceFaker.address().city();
    //leadership
    this.firstLt = new Lieutenant("Briggs", 1, this);
    this.secondLt = new Lieutenant("DeWindt", 2, this);
    //squads
    Unit ableSquad = new Squad(this);
    Unit bakerSquad = new Squad("Baker", this);
    Unit charlieSquad = new Squad("Charlie", this);
    this.squads.add(ableSquad);
    this.squads.add(bakerSquad);
    this.squads.add(charlieSquad);
  }
  public Platoon(int number, Unit co){
    //platoon name
    this.id = number;
    this.title = "Platoon " + number;
    this.base = co.getLocation();
    this.location = franceFaker.address().city();
    //leadership
    this.firstLt = new Lieutenant(this.faker.name().lastName(), 1, this);
    this.secondLt = new Lieutenant(this.faker.name().lastName(), 2, this);
    //squads
    int randomPltSize = (int)(Math.random()*2.17+3);
    for(int i = 0; i < randomPltSize; i++){
      Unit randomSquad = new Squad(abcCodes[i], this);
      this.squads.add(randomSquad);
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
    //platoon info
    String outStr = this.title.toUpperCase();
    outStr += " (Headcount: " + this.getSize() + ")\n"
            + this.firstLt.reportTitle() + "\n"
            + this.secondLt.reportTitle() + "\n";
    //squads info
    for(int i = 0; i < squads.size(); i++){
      outStr += squads.get(i).lineUp().replaceAll("(?m)^", "\t");;
    }
    return outStr;
  }
  public int getSize(){
    int count = 0;
    if(this.firstLt.isAlive()){
      count++;
    }
    if(this.secondLt.isAlive()){
      count++;
    }
    for(int i = 0; i < squads.size(); i++){
      count += squads.get(i).getSize();
    }
    return count;
  }
  public int getNumOfSubUnits(){
    return this.squads.size();
  }
  public ArrayList<Unit> getSubUnits(){
    return this.squads;
  }
  public String getBase(){
    return this.base;
  }
  public String getLocation(){
    return this.location;
  }
  public Leader getLeader(){
    if(!this.firstLt.isAlive()){
      if(!this.secondLt.isAlive()){
        Leader potentialLeader = null;
        for(Unit u: this.squads){
          Leader candidate = u.getLeader();
          if(candidate != null){
            if(candidate.reportTitle().substring(5,8).equals("Pvt")){
              potentialLeader = candidate;
            }else{
              System.out.println(candidate.reportTitle() + " promoted to 2nd Lieutenant");
              Leader promotedCandidate = new Lieutenant(candidate.reportTitle(), 2, this);
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
      return this.secondLt;
    }
    return this.firstLt;
  }
  public String reportTitle(){
    return this.title;
  }

}
