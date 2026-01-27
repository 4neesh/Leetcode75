import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class J_23_TwoStringsClose {

    public static void main(String[] args) {

        System.out.print(twoStringsClose("abc", "cba"));

    }

    private static boolean twoStringsClose(String word1, String word2){

        if(word1.length() != word2.length()) return false;

        int[] freqA = new int[26];
        int[] freqB = new int[26];

        for(int i = 0; i<word1.length(); i++){
            freqA[word1.charAt(i) - 'a']++;
            freqB[word2.charAt(i) - 'a']++;
        }
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for(int i = 0; i<26; i++){
            frequencyMap.merge(freqA[i], 1, (first,second) -> first+1);
            frequencyMap.merge(freqB[i], -1, (first,second) -> first-1);
        }

        for(int val: frequencyMap.values()){
            if(val != 0) return false;
        }
        return true;
    }

}
