import MyPokemons.*;
import ru.ifmo.se.pokemon.Battle;

import java.io.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream st = new PrintStream(new FileOutputStream("output.txt"));
        System.setOut(st);

        Battle b = new Battle();
        Bouffalant A = new Bouffalant("A", 1);
        Baltoy B = new Baltoy("B", 1);
        Claydol C = new Claydol("C", 1);
        Flabebe D = new Flabebe("D", 1);
        Floette E = new Floette("E", 1);
        Florges F = new Florges("F", 1);
        Baltoy v = new Baltoy();

        b.addAlly(v);
        b.addAlly(A);
        b.addAlly(B);
        b.addAlly(D);

        b.addFoe(C);
        b.addFoe(E);
        b.addFoe(F);

        b.go();

    }
}