package real.objects.items;

import enums.Material;
import real.objects.Place;
import real.objects.Person;
import interfaces.Speakable;
import system.CheckBadWords;

public class SpeakableItem extends Item implements Speakable {
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
