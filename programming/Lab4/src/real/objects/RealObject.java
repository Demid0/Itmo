package real.objects;

import system.CheckBadWords;

public abstract class RealObject {
    private String name;
    private Place whereIsIt;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        CheckBadWords.run(name);
        this.name = name;
    }
    public Place getWhereIsIt() {
        return whereIsIt;
    }

    public void setWhereIsIt(Place whereIsIt) {
        if (this.whereIsIt != null) {
            var cont = this.whereIsIt.getWhatIsWhere();
            cont.remove(this);
            this.whereIsIt.setWhatIsWhere(cont);
            this.whereIsIt = whereIsIt;
            cont = this.whereIsIt.getWhatIsWhere();
            cont.add(this);
            this.whereIsIt.setWhatIsWhere(cont);
        }
        else {
            this.whereIsIt = whereIsIt;
            var cont = this.whereIsIt.getWhatIsWhere();
            cont.add(this);
            this.whereIsIt.setWhatIsWhere(cont);
        }
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
