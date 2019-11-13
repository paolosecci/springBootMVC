//Private
package army;
import java.util.ArrayList;

public class Private implements Soldier, Unit{
  private String title;
  private String base;
  private String location;
  private int minYears = 0;
  private Boolean isAlive;

  public Private(String name, Unit sqd){
    this.title = "Pvt. " + name;
    this.isAlive = true;
    this.base = sqd.getLocation();
    this.location = "Prague";
  }
  public String reportTitle(){
    return this.title;
  }
  public void shoot(){
    System.out.println("pew. pew.");
  }
  public Boolean isAlive(){
    return this.isAlive;
  }
  public void attack(){
    System.out.println("Sir, yes Sir! Attacking...");
  }
  public void defend(){
    System.out.println("Sir, yes Sir! Attacking...");
  }
  public String lineUp(){
    return this.reportTitle();
  }
  public int getSize(){
    if(this.isAlive()){return 1;}
    else{return 0;}
  }
  public int getNumOfSubUnits(){
    return 0;
  }
  public ArrayList<Unit> getSubUnits(){
    return null;
  }
  public String getBase(){
    return this.base;
  }
  public String getLocation(){
    return this.location;
  }
  public Leader getLeader(){
    return null;
  }
}
