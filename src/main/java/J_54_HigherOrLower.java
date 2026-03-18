public class J_54_HigherOrLower {

    public static void main(String[] args) {
        J_54_HigherOrLower a = new J_54_HigherOrLower();
        a.guessNumber(1);

    }
    public int guessNumber(int n) {

        int left = 0;
        int right = n;

        while(left < right){
            int mid = left + (right - left) /2;

            int result = guess(mid);

            if(result == 0){
                return mid;
            }
            else if(result == -1){
                right = mid -1;
            }
            else if(result == 1){
                left = mid +1;
            }
        }
        return 0;
    }

    private int guess(int n){
        return -1;
    }

}
