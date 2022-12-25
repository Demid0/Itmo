package real.objects;
import system.CheckBadWords;

import java.util.ArrayList;

public class Place {
    public static final Place Default = new Place("Default");
    private ArrayList<RealObject> whatIsWhere = new ArrayList<>(1);
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        CheckBadWords.run(name);
        this.name = name;
    }
    public Place(String name) {
        setName(name);
    }

    public ArrayList<RealObject> getWhatIsWhere() {
        return whatIsWhere;
    }

    public void setWhatIsWhere(ArrayList<RealObject> whatIsWhere) {
        this.whatIsWhere = whatIsWhere;
    }
}
