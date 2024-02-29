package MyPokemons;

import MyMoves.StoneEdge;

//https://pokemondb.net/pokedex/claydol

public class Claydol extends Baltoy {
    public Claydol (String name, int level) {
        super(name, level);
        super.setStats(60, 70, 105, 70, 120, 75);

        StoneEdge stoneEdge = new StoneEdge();
        super.addMove(stoneEdge);
    }
    public Claydol () {
        super();
        super.setStats(60, 70, 105, 70, 120, 75);

        StoneEdge stoneEdge = new StoneEdge();
        super.addMove(stoneEdge);
    }
}
