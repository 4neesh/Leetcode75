public class J_07_IncreasingTripletSubsequence {


    public static void main(String[] args) {

        int[] a = {1, 2, 3, 4, 5};
        int[] b = {5, 4, 3, 2, 1};
        int[] c = {1, 4, 3, 2, 3};

        System.out.println(increasingTripletSubsequence(a) + ""
        + increasingTripletSubsequence(b) + ""
        + increasingTripletSubsequence(c));
    }

    private static boolean increasingTripletSubsequence(int [] nums){

        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        for(int i : nums){
            if(i < a){
                a = i;
            }
            else if(i < b){
                b = i;
            }
            else if(i > a && i > b && b > a){
                return true;
            }
        }
        return false;
    }

}
