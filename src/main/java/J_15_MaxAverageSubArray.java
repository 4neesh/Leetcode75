public class J_15_MaxAverageSubArray {

    public static void main(String[] args) {

    }

    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        int left = 0;
        int right = k-1;
        //initialise sum
        for(int i = 0; i<= right; i++){
            sum+= nums[i];
        }

        left++; right++;
        while(right < nums.length){
            int newSum = sum + nums[right] - nums[left-1];
            sum = Math.max(sum, newSum);
            left++;right++;
        }
        return (double) sum / k;
    }

}
