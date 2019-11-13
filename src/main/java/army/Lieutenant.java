//Lieutenant
package army;

public class Lieutenant implements Leader{
  private String title;
  private int minYears;
  private Unit platoon;
  private Boolean isAlive;

  public Lieutenant(String name, int ltNum, Platoon p){
    this.platoon = p;
    this.isAlive = true;

    if(ltNum == 1){
      this.title = "1st Lt. " + name;
      this.minYears = 3;
    }else
    if(ltNum == 2){
      this.title = "2nd Lt. " + name;
      this.minYears = 2;
    }else{
      //demote
      this.title = "Pvt. " + name;
      this.minYears = 0;
    }
  }
  public String reportTitle(){
    return this.title;
  }
  public void coach(){
    System.out.println("Keep extra ammo for your fellow private.");
  }
  public int countSubordinates(){
    System.out.println(this.platoon);
    return -1;
  }
  public Boolean isAlive(){
    return this.isAlive;
  }
  public String unitReport(){
    String unitReport = "";
    unitReport += "Infantry: " + this.platoon.getSize() + "\n"
                + "Base: " + this.platoon.getBase() + "\n"
                + "Location: " + this.platoon.getLocation() + "\n"
                + "Squads: " + this.platoon.getNumOfSubUnits() + "\n";
    return unitReport;
  }
  public String report(){
    return this.platoon.reportTitle().toUpperCase() + "\n" + this.unitReport();
  }
}
