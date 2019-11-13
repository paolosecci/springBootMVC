//Battlefield
package army;

public class Battlefield{

  public static void main(String args[]){
    System.out.println("Welcome to Normandy...\n");
    //Company
    Unit charlieCo = new Company("Charlie");
    //System.out.println(charlieCo.lineUp());
    //Platoon
    Unit platoon2 = charlieCo.getSubUnits().get(1);
    //System.out.println(plt2.lineUp());
    //Squad
    Unit bravoSquad = platoon2.getSubUnits().get(1);
    //System.out.println(bSqd.lineUp());

    //reports
    System.out.println(
      charlieCo.getLeader().report() + "\n" +
      platoon2.getLeader().report() + "\n" +
      bravoSquad.getLeader().report()
    );

    //Squad s = new Squad();
    //System.out.println(s.lineUp());
    //System.out.println("Able Count: " + s.getSize());
  }
}
