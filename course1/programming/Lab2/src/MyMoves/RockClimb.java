package MyMoves;

import ru.ifmo.se.pokemon.*;

/**
 * Rock Climb deals damage and has a 20% chance of confusing the target.
 * https://pokemondb.net/move/rock-climb
 */
public class RockClimb extends PhysicalMove {
    public RockClimb () {
        super(Type.NORMAL, 90, 85);
    }

    @Override
    protected String describe() {
        return "does Rock Climb";
    }

    @Override
    protected void applyOppEffects(Pokemon def) {
        super.applyOppEffects(def);
        if (0.2 > Math.random()) {
            Effect.confuse(def);
        }
    }
}
