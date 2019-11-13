package ninja.turtle;

public class MasterPiece {
    public String title;
    public String location;
    public int year;

    public MasterPiece(){
        this.title = "The Life of Pablo";
        this.location = "Los Angeles, California";
        this.year = 2016;
    }

    public MasterPiece(String title, String location, int year){
        this.title = title;
        this.location = location;
        this.year = year;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
