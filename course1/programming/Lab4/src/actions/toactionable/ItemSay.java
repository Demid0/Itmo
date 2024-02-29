package actions.toactionable;
import actions.toactionable.ItemAction;
import real.objects.items.SpeakableItem;

public class ItemSay extends ItemAction {

    public ItemSay(SpeakableItem item) {
        setWhoDoIt(item);
    }

    public void say() {
        System.out.println(describe() + ((SpeakableItem)getWhoDoIt()).getNoise());
    }
    @Override
    public String describe() {
        return ((SpeakableItem)getWhoDoIt()).getName() + " make noise: ";
    }
}
