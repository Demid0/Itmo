package MyPokemons;

import MyMoves.RazorLeaf;

//https://pokemondb.net/pokedex/floette

public class Floette extends Flabebe {
    public Floette (String name, int level) {
        super(name, level);
        super.setStats(54, 45, 47, 75, 98, 52);

        RazorLeaf razorLeaf = new RazorLeaf();
        super.addMove(razorLeaf);
    }
    public Floette () {
        super();
        super.setStats(54, 45, 47, 75, 98, 52);

        RazorLeaf razorLeaf = new RazorLeaf();
        super.addMove(razorLeaf);
    }
}
