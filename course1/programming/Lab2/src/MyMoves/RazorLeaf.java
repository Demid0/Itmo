package MyMoves;

import ru.ifmo.se.pokemon.*;

/**
 * Razor Leaf deals damage and has an increased critical hit ratio (1⁄8 instead of 1⁄24).
 * https://pokemondb.net/move/razor-leaf
 */
public class RazorLeaf extends PhysicalMove {
    public RazorLeaf() {
        super(Type.GRASS, 55, 95);
    }

    @Override
    protected String describe() {
        return "does Razor Leaf";
    }

    @Override
    protected double calcCriticalHit(Pokemon att, Pokemon def) {
        if (att.getStat(Stat.SPEED) / 8.0 > Math.random()) {
            System.out.println("critical");
            return 2.0;
        } else {
            return 1.0;
        }
    }
}
