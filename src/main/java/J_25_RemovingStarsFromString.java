public class J_25_RemovingStarsFromString {


    public static void main(String[] args) {



    }

    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        int skips = 0;

        for(int i = s.length() -1; i>=0; i--){

            if(s.charAt(i) == '*'){
                skips++;
            }
            else{
                if(skips > 0){
                    skips--;
                }
                else{
                    sb.insert(0,s.charAt(i));
                }
            }

        }

        return sb.toString();
    }
}
