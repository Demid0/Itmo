package actions;

import enums.TypeOfTravel;
import real.objects.alive.Person;
import real.objects.Place;
import real.objects.RealObject;

import java.util.ArrayList;

public class MoveTo extends Action {

    public MoveTo(Person whoDoIt) {
        super(whoDoIt);
    }

    public void setPlace(Place place, TypeOfTravel typeOfTravel) {
        try {
            Person person = getWhoDoIt();
            if (!(person.getBody().getLeftLeg() && person.getBody().getRightLeg())) throw new CantMoveException();

            ArrayList<RealObject> whatIsWhere = getWhoDoIt().getWhereIsHe().getWhatIsWhere();       //
            whatIsWhere.remove(getWhoDoIt());                                                       // удаляет человека из содержимого места в котором он находился
            getWhoDoIt().getWhereIsHe().setWhatIsWhere(whatIsWhere);                                //

            getWhoDoIt().setWhereIsHe(place);                                                       // устанавливает новое место для человека
            place.getWhatIsWhere().add(getWhoDoIt());                                               // добавляет его в содержимое места, в котором человек теперь находится
            person.changeInventoryItemPlaces();                                                     // меняет место каждого предмета инвентаря (кринж пздц)

            System.out.println(getWhoDoIt().getName() + " " + typeOfTravel + describe() + place.getName());
        }
        catch (CantMoveException ex) {
            System.out.println(ex.getMessage());
        }
    }
    @Override
    public String describe() {
        return " to ";
    }

    public class CantMoveException extends Exception{
        @Override
        public String getMessage() {
            return MoveTo.this.getWhoDoIt().getName() + " не может двигаться";
        }
    }
}
