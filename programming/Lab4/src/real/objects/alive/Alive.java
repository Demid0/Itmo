package real.objects.alive;

import real.objects.Place;
import real.objects.RealObject;
public abstract class Alive extends RealObject {
    private Place whereIsHe;


    public Place getWhereIsHe() {
        return whereIsHe;
    }
    public void setWhereIsHe(Place whereIsHe) {
        this.whereIsHe = whereIsHe;
    }

}
