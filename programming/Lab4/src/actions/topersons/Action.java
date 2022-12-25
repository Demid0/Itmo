package actions.topersons;

import interfaces.Describeable;
import real.objects.Person;

public abstract class Action implements Describeable {
    private Person whoDoIt;
    protected Action(Person whoDoIt) {
        this.whoDoIt = whoDoIt;
    }
    protected Action() {}

    public void setWhoDoIt(Person whoDoIt) {
        this.whoDoIt = whoDoIt;
    }
    public Person getWhoDoIt() {
        return whoDoIt;
    }
    @Override
    public String toString() {
        return "Action[whoDoIt: " + whoDoIt.getName() + "]";
    }

    @Override
    public int hashCode() {
        return 3 * super.hashCode() + 2040;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Action)) return false;
        return this.hashCode() == obj.hashCode();
    }
}
