import java.util.HashMap;
import java.util.Map;

public class LetterCounter {
    public static void main(String[] args) {
        String word = "Supercalifragilisticexpialidocious";
        char letter = 'i';
        int count = countOccurrences(word, letter);
        System.out.println("The letter '" + letter + "' appears " + count + " times in the word '" + word + "'.");
    }

    public static int countOccurrences(String word, char letter) {
        Map<Character, Integer> letterCount = new HashMap<>();
        for (char c : word.toCharArray()) {
            letterCount.put(c, letterCount.getOrDefault(c, 0) + 1);
        }
        return letterCount.getOrDefault(letter, 0);
    }
}
