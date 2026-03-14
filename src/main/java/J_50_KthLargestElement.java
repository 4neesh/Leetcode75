import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class J_50_KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for(int i: nums){
            list.add(i);
        }

        return quickSelect(list, k);

    }

    private int quickSelect(List<Integer> list, int k) {

        if(list.size() == 1){
            return list.get(0);
        }

        List<Integer> less = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();

        int pivotIndex = new Random().nextInt(list.size());
        int pivot = list.get(pivotIndex);
        for(int i : list){
            if(i < pivot){
                less.add(i);
            }
            else if( i == pivot){
                equal.add(i);
            }
            else{
                greater.add(i);
            }
        }
        if(greater.size() >= k){
            return quickSelect(greater, k);
        }
        else if(greater.size() + equal.size() < k){
            return quickSelect(less, k - greater.size() - equal.size());
        }
        return pivot;
    }
}