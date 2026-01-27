import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class J_22_UniqueOccurences {

    public static void main(String[] args) {



    }

    private static boolean uniqueOccurrences(int[] arr){

        Map<Integer, Integer> valToCount = new HashMap<>();
        for(int i: arr){
            valToCount.merge(i, 1, (old, newer) -> old + 1);
        }
        return valToCount.size() == valToCount.values().stream().distinct().count();
    }
}
