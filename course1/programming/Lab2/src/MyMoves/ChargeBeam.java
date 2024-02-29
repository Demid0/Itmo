package MyMoves;

import ru.ifmo.se.pokemon.*;

import static java.lang.Math.random;

/**
 * Charge Beam deals damage and has a 70% chance of raising the user's Special Attack by one stage.
 * https://pokemondb.net/move/charge-beam
 */
public class ChargeBeam extends SpecialMove {
    public ChargeBeam () {
        super(Type.ELECTRIC, 50, 90);
    }

    @Override
    protected String describe() {
        return "does Charge Beam";
    }

    @Override
    protected void applySelfEffects(Pokemon att) {
        super.applySelfEffects(att);
        if (0.7 > random()) {
            Effect effect = new Effect().stat(Stat.SPECIAL_ATTACK, 1);
            att.addEffect(effect);
            System.out.println(att + "raises own SPECIAL ATTACK at 1 point");
        }
    }
}
