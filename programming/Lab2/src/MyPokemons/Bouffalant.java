package MyPokemons;

import MyMoves.HeadCharge;
import MyMoves.Leer;
import MyMoves.RockClimb;
import MyMoves.StoneEdge;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

//https://pokemondb.net/pokedex/bouffalant

public class Bouffalant extends Pokemon {
    public Bouffalant (String name, int level) { // конструктор класса
        super(name, level); // вызов конструктора суперкласса (класса-предка - т.е. Pokemon)
        super.setType(Type.NORMAL);
        super.setStats(95, 110, 95, 40, 95, 55);

        HeadCharge headCharge = new HeadCharge();
        RockClimb rockClimb = new RockClimb();
        StoneEdge stoneEdge = new StoneEdge();
        Leer leer = new Leer();
        super.setMove(headCharge, rockClimb, stoneEdge, leer);
    }
    public Bouffalant () {
        super();
        super.setType(Type.NORMAL);
        super.setStats(95, 110, 95, 40, 95, 55);

        HeadCharge headCharge = new HeadCharge();
        RockClimb rockClimb = new RockClimb();
        StoneEdge stoneEdge = new StoneEdge();
        Leer leer = new Leer();
        super.setMove(headCharge, rockClimb, stoneEdge, leer);
    }
}
