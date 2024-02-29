package real.objects;

import actions.Action;

public abstract class RealObject {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "RealObject[name: " + name + "]";
    }

    @Override
    public int hashCode() {
        return 3 * super.hashCode() + 2040;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof RealObject)) return false;
        return this.hashCode() == obj.hashCode();
    }
}
