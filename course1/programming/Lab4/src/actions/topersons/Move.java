package actions.topersons;

import actions.topersons.Action;
import enums.TypeOfTravel;
import real.objects.Person;
import real.objects.Place;
import real.objects.RealObject;
import system.myExceptions.CantMoveException;

import java.util.ArrayList;

public class Move extends Action {

    public Move(Person whoDoIt) {
        super(whoDoIt);
    }

    public void move(Place place, TypeOfTravel typeOfTravel) {
        try {
            if (!getWhoDoIt().getBody().getLegs().isCanMove()) throw new CantMoveException();

            ArrayList<RealObject> whatIsWhere = getWhoDoIt().getWhereIsIt().getWhatIsWhere();       //
            whatIsWhere.remove(getWhoDoIt());                                                       // удаляет человека из содержимого места в котором он находился
            getWhoDoIt().getWhereIsIt().setWhatIsWhere(whatIsWhere);                                //

            getWhoDoIt().setWhereIsIt(place);                                                       // устанавливает новое место для человека
            place.getWhatIsWhere().add(getWhoDoIt());                                               // добавляет его в содержимое места, в котором человек теперь находится
            getWhoDoIt().changeInventoryItemPlaces();                                                     // меняет место каждого предмета инвентаря (кринж пздц)

            System.out.println(getWhoDoIt().getName() + " " + typeOfTravel + describe() + place.getName());
        }
        catch (CantMoveException ex) {
            System.out.println(ex.getMessage(getWhoDoIt()));
        }
    }
    @Override
    public String describe() {
        return " to ";
    }

}
