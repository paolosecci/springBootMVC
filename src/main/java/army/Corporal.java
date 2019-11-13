//Corporal
package army;

public class Corporal implements Leader{
  private String title;
  private int minYears = 2;
  private Unit squad;
  private Boolean isAlive;

  public Corporal(String name, Squad s){
    this.squad = s;
    this.title = "Cpl. " + name;
    this.isAlive = true;
  }
  public String reportTitle(){
    return this.title;
  }
  public void coach(){
    System.out.println("Keep extra ammo for your fellow private.");
  }
  public int countSubordinates(){
    System.out.println(this.squad);
    return -1;
  }
  public Boolean isAlive(){
    return this.isAlive;
  }
  public String unitReport(){
    String unitReport = "";
    unitReport += "Infantry: " + this.squad.getSize() + "\n"
                + "Base: " + this.squad.getBase() + "\n"
                + "Location: " + this.squad.getLocation() + "\n";
    return unitReport;
  }
  public String report(){
    return this.squad.reportTitle().toUpperCase() + "\n" + this.unitReport();
  }
}
