import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class J_21_DiffTwoArrays {

    public static void main(String[] args) {

        System.out.println(differenceOfTwo(new int[]{1, 2, 3}, new int[] {2, 4, 6}));


    }

    private static List<List<Integer>> differenceOfTwo(int[] nums1, int[] nums2){

        Map<Integer, Integer> numberMap = new HashMap<>();
        for(int i: nums1){
            numberMap.put(i, 1);
        }
        for(int i: nums2){
            numberMap.merge(i, -1, (a,b) -> -0);
        }
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        result.add(new ArrayList<>());

        numberMap.keySet().forEach(key -> {
            if(numberMap.get(key).equals(1)){
                result.getFirst().add(key);
            }
            else if(numberMap.get(key).equals(-1)){
                result.get(1).add(key);
            }
        });
        return result;
    }

}
