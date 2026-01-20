import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class J_14_MaxNumberKSumPairs {


    public static void main(String[] args) {

        System.out.println(maxOperationsAlternative(new int[]{1,3,4,5,6}, 7));
        System.out.println(maxOperationsAlternative(new int[]{1,3,4,5,6}, 12));

    }

    /**
     * Solution with n time complexity
     * Solution with n space complexity
     */
    public static int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> storedVals = new HashMap<>();
        int result = 0;
        for(int i: nums){

            int complementary = k - i;
            if(storedVals.getOrDefault(complementary, 0) > 0){
                storedVals.compute(complementary, (key,val) -> val -1);
                result++;
            }
            else{
                storedVals.merge(i, 1, (key, val) -> val + 1);
            }

        }
        return result;
    }

    /**
     * Solution with n log n time complexity (worse than linear)
     * Solution with constant space complexity (better than linear)
     */
    public static int maxOperationsAlternative(int[] nums, int k){

       Arrays.sort(nums);
       int result = 0;
       int left = 0;
       int right = nums.length-1;
       while(left < right){

           int sum = nums[left] + nums[right];
           if(sum == k){
               result ++;
               left ++;
               right --;
           }
           else if(sum < k){
               left ++;
           }
           else if(sum > k){
               right --;
           }

       }


       return result;
    }
}
