package real.objects.alive;

import real.objects.Place;
import real.objects.alive.Alive;
import real.objects.items.Item;
import real.objects.items.Money;

import java.util.ArrayList;

public class Person extends Alive {
    private final Body body = new Body();
    private ArrayList<Item> inventory = new ArrayList<>(1);
    private final Money money = new Money(this, 5000);

    public Person(String name, Place whereIsHe) {
        super.setName(name);
        setWhereIsHe(whereIsHe);
        whereIsHe.getWhatIsWhere().add(this);
    }
    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }

    public Money getMoney() {
        return money;
    }
    public Body getBody(){return body;}

    public void changeInventoryItemPlaces() {
        for (Item item : getInventory()) {
            item.setWhereIsIt(getWhereIsHe());
        }
    }

    public static class Body {
        private boolean leftLeg = true, rightLeg = true, leftHand = true, rightHand = true;

        public void setLeftLeg(boolean leftLeg) {
            this.leftLeg = leftLeg;
        }

        public boolean getLeftLeg() {
            return leftLeg;
        }

        public void setRightLeg(boolean rightLeg) {
            this.rightLeg = rightLeg;
        }

        public boolean getRightLeg() {
            return rightLeg;
        }

        public boolean isRightHand() {
            return rightHand;
        }

        public void setRightHand(boolean rightHand) {
            this.rightHand = rightHand;
        }

        public boolean isLeftHand() {
            return leftHand;
        }

        public void setLeftHand(boolean leftHand) {
            this.leftHand = leftHand;
        }
    }
}
