package MyPokemons;

import MyMoves.Facade;
import MyMoves.Rest;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

//https://pokemondb.net/pokedex/flabebe

public class Flabebe extends Pokemon {
    public Flabebe (String name, int level) {
        super(name, level);
        super.setType(Type.FAIRY);
        super.setStats(44, 38, 39, 61, 79, 42);

        Facade facade = new Facade();
        Rest rest = new Rest();
        super.setMove(facade, rest);
    }
    public Flabebe () {
        super();
        super.setType(Type.FAIRY);
        super.setStats(44, 38, 39, 61, 79, 42);

        Facade facade = new Facade();
        Rest rest = new Rest();
        super.setMove(facade, rest);
    }
}
