package MyMoves;

import ru.ifmo.se.pokemon.*;

/**
 * Leer lowers the target's Defense by one stage.
 * https://pokemondb.net/move/leer
 */
public class Leer extends StatusMove {
    public Leer () {
        super(Type.NORMAL, 0,100);
    }

    @Override
    protected String describe() {
        return "does Leer";
    }

    @Override
    protected void applyOppEffects(Pokemon def) {
        super.applyOppEffects(def);
        Effect effect = new Effect().stat(Stat.DEFENSE, -1);
        def.addEffect(effect);
        System.out.println(def + " lows its target's DEFENSE at 1 point");
    }
}
