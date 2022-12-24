package real.objects;
import java.util.ArrayList;

public class Place extends RealObject {
    private ArrayList<RealObject> whatIsWhere = new ArrayList<>(1);

    public Place(String name) {
        super.setName(name);
    }

    public ArrayList<RealObject> getWhatIsWhere() {
        return whatIsWhere;
    }

    public void setWhatIsWhere(ArrayList<RealObject> whatIsWhere) {
        this.whatIsWhere = whatIsWhere;
    }
}
