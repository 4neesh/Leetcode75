public class J_19_FindHighestAltitude {


    public static void main(String[] args) {

        System.out.println(findHighestAltitude(new int[]{-5, 1, 5, 0, -7}));
        System.out.println(findHighestAltitude(new int[]{-4, -3, -2, -1, 4, 3, 2}));

    }

    private static int findHighestAltitude(int[] gain){

        int max = 0;
        int cumulative = 0;

        for (int i: gain){
            cumulative += i;
            max = Math.max(max, cumulative);
        }

        return max;
    }

}
