import java.util.Arrays;
import java.util.List;

public class J_05_ReverseVowels {

    public static void main(String[] args) {

        String a = reverseVowels("James");
        String aa = reverseVowels("Jaies");
        String b = reverseVowels("Icecream");
        String c = reverseVowels("Rhythm");
        System.out.println(a);
        System.out.println(aa);
        System.out.println(b);
        System.out.println(c);
    }

    private static String reverseVowels(String s){
        int start = 0;
        int end = s.length()-1;
        char[] stringArr = s.toCharArray();

        while(start < end){

            while(start <= end){
                if(isVowel(stringArr[start])){
                    break;
                }
                start++;
            }

            while(end >= start){
                if(isVowel(stringArr[end])){
                    break;
                }
                end--;
            }

            //perform swap
            if(start < end){
                char endString = stringArr[end];
                stringArr[end] = stringArr[start];
                stringArr[start] = endString;
                start++;
                end--;
            }
        }


        return Arrays.toString(stringArr);
    }

    private static boolean isVowel(char c){
        List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        return vowels.contains(c);
    }
}
