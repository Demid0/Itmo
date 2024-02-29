package MyMoves;

import ru.ifmo.se.pokemon.*;

/**
 * Stone Edge deals damage and has an increased critical hit ratio (1⁄8 instead of 1⁄24).
 * https://pokemondb.net/move/stone-edge
 */
public class StoneEdge extends PhysicalMove {
    public StoneEdge () {
        super(Type.ROCK, 100, 80);
    }

    @Override
    protected String describe() {
        return "does Stone Edge";
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
