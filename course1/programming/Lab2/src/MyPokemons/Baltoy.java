package MyPokemons;

import MyMoves.ChargeBeam;
import MyMoves.Facade;
import MyMoves.Psychic;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

//https://pokemondb.net/pokedex/baltoy

public class Baltoy extends Pokemon {
    public Baltoy (String name, int level) {
        super(name, level);
        super.setType(Type.GROUND, Type.PSYCHIC);
        super.setStats(40, 40, 55, 40, 70, 55);

        Facade facade = new Facade();
        Psychic psychic = new Psychic();
        ChargeBeam chargeBeam = new ChargeBeam();
        super.setMove(facade, psychic, chargeBeam);
    }
    public Baltoy () {
        super();
        super.setType(Type.GROUND, Type.PSYCHIC);
        super.setStats(40, 40, 55, 40, 70, 55);

        Facade facade = new Facade();
        Psychic psychic = new Psychic();
        ChargeBeam chargeBeam = new ChargeBeam();
        super.setMove(facade, psychic, chargeBeam);
    }
}
