package system;

import system.myExceptions.BadWords;

import java.util.ArrayList;
import java.util.Arrays;

public class CheckBadWords {
    private static final ArrayList<String> badWords = new ArrayList<>(Arrays.asList("fuck", "shit", "bitch", "хуй", "пизда", "шлюха", "гондон", "сука", "javarush"));
    public static void run(String s) {
        s = s.toLowerCase();
        String[] words = s.split("[\\s\\,\\.]+");
        for(String word : words) {
            if (badWords.contains(word)) throw new BadWords();
        }
    }
}
