package system.myExceptions;

import real.objects.Person;

import java.util.ArrayList;

public class CantMoveException extends Exception {

    public String getMessage(Person person) {
        ArrayList<Person.Body.Piece> pieces = new ArrayList<>(1);
        pieces.add(person.getBody().getLegs());
        pieces.add(person.getBody().getHands());
        pieces.add(person.getBody().getMouth());
        StringBuilder out = new StringBuilder();
        out.append(person.getName()).append(" cant do it because ");
        for (Person.Body.Piece piece : pieces) {
            if (!piece.isCanMove()) {
                out.append(piece.getName()).append(" ");
            }
        }
        out.append("is/are unmoved");
        return out.toString();
    }
}
