import java.util.HashMap;
import java.util.Map;

public class BalancedWordsCounter {

    public Integer count(String input){
        if(!containsLettersOnly(input))
            throw new RuntimeException();

        int output = 0;

        for(int i = 0; i < input.length(); i++){
            for(int j = i+1; j < input.length() + 1; j++)
                if(isBalanced(input.substring(i, j)))
                    output++;
        }

        return output;
    }

    private boolean containsLettersOnly(String word){
        for(char c : word.toCharArray())
            if(!isLetter(c))
                return false;

        return true;
    }

    private boolean isLetter(char c){
        return (c >= 'a' && c <= 'z') ||
                (c >= 'A' && c <= 'Z');
    }

    private boolean isBalanced(String input){
        //Maps each character to number of its occurrences
        Map<Character, Integer> occurrences = new HashMap<>();
        input.chars()
                .forEach(i -> {
                    char c = (char) i;
                    if(occurrences.putIfAbsent(c, 1) != null)
                        occurrences.put(c, occurrences.get(c) + 1);
                });

        //Checks if each character appears the same number of times
        return occurrences
                .values()
                .stream()
                .distinct()
                .count() == 1;
    }
}
