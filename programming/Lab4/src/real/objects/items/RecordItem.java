package real.objects.items;

import enums.Material;
import real.objects.alive.Person;
import system.CheckBadWords;

public class RecordItem extends Item {
    private String contain = "";

    public RecordItem(String name, Person owner) {
        super(name, owner, Material.PAPER, owner.getWhereIsHe());
    }

    public String getContain() {
        return contain;
    }

    public void setContain(String contain) {
        CheckBadWords.run(contain);
        this.contain = contain;
    }
}
