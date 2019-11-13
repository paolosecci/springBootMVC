//leader
package army;

public interface Leader extends Soldier{
    public void coach();
    public int countSubordinates();
    public String unitReport();
    public String report();
}
