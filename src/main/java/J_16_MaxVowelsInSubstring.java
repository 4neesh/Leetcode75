import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class J_16_MaxVowelsInSubstring {

    public static void main(String[] args) {

        maxVowelsInSubstring("abciiidef", 3);

    }

    private static int maxVowelsInSubstring(String s, int k){

        int maxCount = 0;
        int currentCount = 0;
        int left = 0;
        int right = k-1;
        Set<Character> vowels = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u'));

        //initialise first k characters
        for(int i = left; i<=right; i++){
            if(vowels.contains(s.charAt(i))) {
                maxCount++;
                currentCount++;
            }
        }

        while(right<s.length()-1){
            left++;
            right++;
            if(vowels.contains(s.charAt(left -1))){
                currentCount--;
            }
            if(vowels.contains(s.charAt(right))){
                currentCount++;
            }
            maxCount = Math.max(currentCount, maxCount);
        }

        return maxCount;
    }
}
