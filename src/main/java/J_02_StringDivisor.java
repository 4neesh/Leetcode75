public class J_02_StringDivisor {


    public static void main(String[] args) {

        String s = "ah";
        String t = "ahah";
        String u = getCommonDivisor(s, t);
        System.out.println(u);
    }

    private static String getCommonDivisor(String s, String t){
        String shorterString = s.length() < t.length() ? s : t;
        int sLength = s.length();
        int tLength = t.length();
        String maxSubstring = "";

        //loop over the shorter string to create substrings
        for (int i = shorterString.length(); i > 0; i--){
            String substring = shorterString.substring(0, i);
            int substringLength = substring.length();
            if(sLength % substringLength == 0 && tLength % substringLength == 0){
                //compound and check the equality and break
                int multiplierS = sLength / substringLength;
                int multiplierT = tLength / substringLength;
                if(multiplyString(substring, multiplierS).equals(s)
                && multiplyString(substring, multiplierT).equals(t)){
                    maxSubstring = substring;
                    break;
                }
            }
        }
        return maxSubstring;
    }

    private static String multiplyString (String s, int times){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< times; i++){
            sb.append(s);
        }
        return sb.toString();
    }
}
