public class J_09_ReverseWords {

    public static void main(String[] args) {

        System.out.println(reverseWords("   hello world   "));
        System.out.println(reverseWords("a dog is in my house"));
        System.out.println(reverseWords("a cat     jumps over 20 fences"));

    }

    private static String reverseWords(String sentence){

        //create sb
        StringBuilder sb = new StringBuilder();
        StringBuilder currentWord = new StringBuilder();

        for (int i = 0; i < sentence.length(); i++){
            char currentChar = sentence.charAt(i);
            if(currentChar == ' '){
                //define word if currentWord is populated
                if(!currentWord.isEmpty()){
                    sb.insert(0, currentWord);
                    sb.insert(0, ' ');
                    currentWord = new StringBuilder();
                }
            }
            else{
                currentWord.append(currentChar);
                if(i == sentence.length() -1){
                    sb.insert(0, currentWord);
                    sb.insert(0, ' ');
                }
            }
        }

        return sb.toString();
    }
}
