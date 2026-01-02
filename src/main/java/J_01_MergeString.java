import java.util.Objects;

public class J_01_MergeString {

    public static void main(String[] args) {

        String word1 = "Apple";
        String word2 = "Pear";
        String word3 = "";
        String word4 = null;
        String word5 = "Loop";

        System.out.println(mergeString(word1, word2));
        System.out.println(mergeString(word1, word3));
        System.out.println(mergeString(word1, word4));
        System.out.println(mergeString(word2, word5));

    }

    public static String mergeString(String word1, String word2){

        if(Objects.isNull(word1) || Objects.isNull(word2)){
            return Objects.requireNonNullElse(word1, "") + Objects.requireNonNullElse(word2, "");
        }
        StringBuilder sb = new StringBuilder();
        int minLength = Math.min(word1.length(), word2.length());
        for(int i = 0; i< minLength; i++){
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }

        sb.append(word1, minLength, word1.length());
        sb.append(word2, minLength, word2.length());
        
        return sb.toString();
    }

}
