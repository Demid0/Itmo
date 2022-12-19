package actions;

import enums.TypeOfTravel;
import real.objects.Person;
import real.objects.Place;
import real.objects.RealObject;

import java.util.ArrayList;

public class MoveTo extends Action {

    public MoveTo(Person whoDoIt) {
        super(whoDoIt);
    }

    public void setPlace(Place place, TypeOfTravel typeOfTravel) {
        ArrayList<RealObject> whatIsWhere = getWhoDoIt().getWhereIsHe().getWhatIsWhere();
        whatIsWhere.remove(getWhoDoIt());
        getWhoDoIt().getWhereIsHe().setWhatIsWhere(whatIsWhere);

        getWhoDoIt().setWhereIsHe(place);
        place.getWhatIsWhere().add(getWhoDoIt());

        System.out.println(getWhoDoIt().getName() + " " + typeOfTravel + describe() + place.getName());
    }
    @Override
    public String describe() {
        return " to ";
    }
}
