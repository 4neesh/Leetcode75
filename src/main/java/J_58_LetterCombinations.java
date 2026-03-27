import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class J_58_LetterCombinations {

    public static void main(String[] args) {

        J_58_LetterCombinations a = new J_58_LetterCombinations();
        System.out.println(a.letterCombinations("23"));
    }

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        for (Character i : digits.toCharArray()) {
            List<String> newResult = new ArrayList<>();
            for (Character j : getCharactersForDigit(i)) {
                if(result.isEmpty()){
                    newResult.add(j.toString());
                }
                for (String k : result) {
                    newResult.add(k + j);
                }
            }
            result = newResult;
        }
        return result;
    }

    private Character[] getCharactersForDigit(Character i) {
        return switch (i) {
            case '2' -> new Character[]{'a', 'b', 'c'};
            case '3' -> new Character[]{'d', 'e', 'f'};
            case '4' -> new Character[]{'g', 'h', 'i'};
            case '5' -> new Character[]{'j', 'k', 'l'};
            case '6' -> new Character[]{'m', 'n', 'o'};
            case '7' -> new Character[]{'p', 'q', 'r', 's'};
            case '8' -> new Character[]{'t', 'u', 'v'};
            case '9' -> new Character[]{'w', 'x', 'y', 'z'};
            default -> new Character[]{};
        };
    }
}
