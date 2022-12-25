package real.objects.items;

import enums.Material;
import real.objects.Place;
import real.objects.Person;

public class Door extends Item {
    private boolean closed = true;
    public Door(String name, Person owner, Material material, Place place, boolean closed) {
        super(name, owner, material, place);
        setClosed(closed);
    }
    public void setClosed(boolean closed) {
        this.closed = closed;
    }
    public boolean isClosed() {
        return closed;
    }
}
