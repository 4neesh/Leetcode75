import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class J_10_MoveZeros {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(moveZeros(new int[]{1, 2, 0, 3, 4, 0, 0, 1, 2})));
        System.out.println(Arrays.toString(moveZeros(new int[]{1, 2, 0, 3, 4, 0, 0, 1, 2})));

    }

    private static int[] moveZeros(int[] nums){

        int current = 0;
        int latestZero = 0;
        while(current < nums.length){
            if(nums[current] != 0 && nums[latestZero] != 0){
                latestZero++;
            }
            else if(nums[current] != 0 && latestZero != current){
                int currentVal = nums[current];
                nums[latestZero] = currentVal;
                nums[current] = 0;
                latestZero++;
            }
            current++;
        }
        return nums;
    }
}
