public class J_11_IsSubsequence {


    public static void main(String[] args) {

        System.out.println(isSubsequence("ace", "abcde"));

    }

    private static boolean isSubsequence(String s, String t){

        int left = 0;
        int right = 0;

        while(left < t.length() && right < s.length()){

            if(t.charAt(left) == s.charAt(right)){
                left++;
                right++;
                if(right == s.length()){
                    return true;
                }
            }
            else{
                left++;
            }

        }
        return false;
    }

}
