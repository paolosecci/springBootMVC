//Unit INTERFACE
package army;
import java.util.ArrayList;

public interface Unit{
  public void attack();
  public void defend();
  public String lineUp();
  public int getSize();
  public int getNumOfSubUnits();
  public ArrayList<Unit> getSubUnits();
  public String getBase();
  public String getLocation();
  public Leader getLeader();
  public String reportTitle();
}
