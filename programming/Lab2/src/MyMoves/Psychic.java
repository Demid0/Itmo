package MyMoves;

import ru.ifmo.se.pokemon.*;

import static java.lang.Math.*;

/**
 * Psychic deals damage and has a 10% chance of lowering the target's Special Defense by one stage.
 * https://pokemondb.net/move/psychic
 */
public class Psychic extends SpecialMove {
    public Psychic () {
        super(Type.PSYCHIC, 90, 100);
    }

    @Override
    protected String describe() {
        return "does Psychic";
    }

    @Override
    protected void applyOppEffects(Pokemon def) {
        super.applyOppEffects(def);
        if (0.1 > random()) {
            Effect effect = new Effect().stat(Stat.SPECIAL_DEFENSE, -1);
            def.addEffect(effect);
            System.out.println(def + " lows its target's SPECIAL DEFENSE at 1 point");
        }
    }

}
