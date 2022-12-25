package real.objects.items;

import enums.Material;
import interfaces.Actionable;
import real.objects.Place;
import real.objects.Person;
import system.CheckBadWords;

public class SpeakableItem extends Item implements Actionable {
    private final String noise;
    public SpeakableItem(String name, Person owner, Material material, Place place, String noise) {
        super(name, owner, material, place);
        CheckBadWords.run(noise);
        this.noise = noise;
    }

    public String getNoise() {
        return noise;
    }
}
