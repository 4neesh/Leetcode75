import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class J_03_KidCandies {


    public static void main(String[] args) {

        int[] a = new int[]{2, 3, 5, 1, 3};
        System.out.println(calculateMaxArray(a, 3));

    }

    private static List<Boolean> calculateMaxArray(int[] candies, int extraCandies){


        //identify the max
        int maxCandies = 0;
        for(int i = 0; i<candies.length; i++){
            maxCandies = Math.max(maxCandies, candies[i]);
        }

        List<Boolean> kidsWithMax = new ArrayList<>(candies.length);
        for(int i =0; i< candies.length; i++){
            kidsWithMax.add(candies[i] + extraCandies > maxCandies);
        }
        return kidsWithMax;
    }
}
