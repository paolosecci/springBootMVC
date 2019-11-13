//Captain
package army;

public class Captain implements Leader{
  private String title;
  private int minYears = 6;
  private Unit company;
  private Boolean isAlive;

  public Captain(String name, Company c){
    this.company = c;
    this.title = "Cpt. " + name;
    this.isAlive = true;
  }
  public String reportTitle(){
    return this.title;
  }
  public void coach(){
    System.out.println("Keep extra ammo for your fellow private.");
  }
  public int countSubordinates(){
    System.out.println(this.company);
    return -1;
  }
  public Boolean isAlive(){
    return this.isAlive;
  }
  public String unitReport(){
    String unitReport = "";
    unitReport += "Infantry: " + this.company.getSize() + "\n"
                + "Base: " + this.company.getBase() + "\n"
                + "Location: " + this.company.getLocation() + "\n"
                + "Platoons: " + this.company.getNumOfSubUnits() + "\n";
    return unitReport;
  }
  public String report(){
    return this.company.reportTitle().toUpperCase() + "\n" + this.unitReport();
  }
}
