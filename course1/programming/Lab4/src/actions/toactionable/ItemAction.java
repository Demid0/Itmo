package actions.toactionable;

import interfaces.Actionable;
import interfaces.Describeable;

public abstract class ItemAction implements Describeable {
    private Actionable whoDoIt;

    public Actionable getWhoDoIt() {
        return whoDoIt;
    }

    public void setWhoDoIt(Actionable whoDoIt) {
        this.whoDoIt = whoDoIt;
    }
}
