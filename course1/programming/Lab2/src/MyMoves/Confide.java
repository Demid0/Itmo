package MyMoves;

import ru.ifmo.se.pokemon.*;

/**
 * Confide lowers the target's Special Attack by one stage.
 * https://pokemondb.net/move/confide
 */
public class Confide extends StatusMove {
    public Confide() {
        super(Type.NORMAL, 0, 100);
    }

    @Override
    protected String describe() {
        return "does Confide";
    }

    @Override
    protected void applyOppEffects(Pokemon def) {
        Effect effect = new Effect().stat(Stat.SPECIAL_ATTACK, -1);
        def.addEffect(effect);
    }
}
