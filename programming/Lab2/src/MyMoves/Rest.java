package MyMoves;

import ru.ifmo.se.pokemon.*;

/**
 * User sleeps for 2 turns, but user is fully healed.
 * https://pokemondb.net/move/rest
 */
public class Rest extends StatusMove {
    public Rest () {
        super(Type.PSYCHIC, 0, 100);
    }

    @Override
    protected boolean checkAccuracy(Pokemon att, Pokemon def) {
        return true;
    }

    @Override
    protected String describe() {
        return "does Rest";
    }

    @Override
    protected void applySelfEffects(Pokemon att) {
        att.setMod(Stat.HP, (int)(att.getHP() - att.getStat(Stat.HP)));
        Effect effect = new Effect().turns(2).condition(Status.SLEEP);
        att.addEffect(effect);
    }
}
