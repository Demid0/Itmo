package MyMoves;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Type;

/**
 * Head Charge deals damage, but the user receives 1⁄4 of the damage it inflicts in recoil.
 * https://pokemondb.net/move/head-charge
 */
public class HeadCharge extends PhysicalMove {
    public HeadCharge () {
        super(Type.NORMAL, 120, 100);
    }

    @Override
    protected String describe() {
        return "does Head Charge";
    }

    @Override
    protected void applySelfDamage(Pokemon att, double damage) {
        super.applySelfDamage(att, damage);
        damage /= 4;
        att.setMod(Stat.HP, (int) Math.round(damage));
    }
}
