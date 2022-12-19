package MyPokemons;

import MyMoves.Confide;

//https://pokemondb.net/pokedex/florges

public class Florges extends Floette {
    public Florges (String name, int level) {
        super(name, level);
        super.setStats(78, 65, 68, 112, 154, 75);

        Confide confide = new Confide();
        super.addMove(confide);
    }
    public Florges () {
        super();
        super.setStats(78, 65, 68, 112, 154, 75);

        Confide confide = new Confide();
        super.addMove(confide);
    }
}
