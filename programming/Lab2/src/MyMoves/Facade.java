package MyMoves;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Status;

/**
 * Facade deals damage, and hits with double power (140) if the user is burned, poisoned or paralyzed.
 * https://pokemondb.net/move/facade
 */
public class Facade extends PhysicalMove {
    public Facade () {
        super();
    }

    @Override
    protected String describe() {
        return "does Facade";
    }

    @Override
    protected double calcCriticalHit(Pokemon att, Pokemon def) {
        Status A = att.getCondition();
        if (A == Status.BURN || A == Status.PARALYZE || A == Status.POISON) {
            return 2.0;
        }
        else {
            return 1.0;
        }
    }
}
