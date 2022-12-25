package real.objects;

import interfaces.Speakable;
import real.objects.items.Item;
import system.CheckBadWords;

import java.util.ArrayList;

public class Person extends RealObject implements Speakable {
    private final Body body = new Body();
    private ArrayList<Item> inventory = new ArrayList<>(1);
    private int money = 5000;

    public Person(String name, Place whereIsHe) {
        super.setName(name);
        setWhereIsIt(whereIsHe);
    }
    public Person(String name) {
        super.setName(name);
        setWhereIsIt(Place.Default);
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }

    public int getMoney() {
        return money;
    }
    public void setMoney(int nominal) {
        money = nominal;
    }
    public Body getBody(){return body;}

    public void changeInventoryItemPlaces() {
        for (Item item : getInventory()) {
            item.setWhereIsIt(getWhereIsIt());
        }
    }

    public static class Body {
        private final Piece hands = new Piece("руки", true);
        private final Piece legs = new Piece("ноги", true);
        private final Piece mouth = new Piece("рот", true);

        public Piece getMouth() {
            return mouth;
        }

        public Piece getHands() {
            return hands;
        }
        public Piece getLegs() {
            return legs;
        }

        public static class Piece {
            private boolean canMove;
            private final String name;
            private Piece(String name, boolean canMove) {
                CheckBadWords.run(name);
                this.name = name;
                setCanMove(canMove);
            }
            public boolean isCanMove() {
                return canMove;
            }
            public void setCanMove(boolean bool) {
                canMove = bool;
            }
            public String getName() {
                return name;
            }
        }
    }
}
