public class J_20_FindPivotIndex {

    public static void main(String[] args) {

        System.out.println(findPivotIndex(new int[] {2, 1, -1}));
        System.out.println(findPivotIndex(new int[] {1, 7, 3, 6, 5, 6}));
        System.out.println(findPivotIndex(new int[] {1, 2, 3}));

    }
    private static int findPivotIndex(int[] nums){

        int[] cumulativeNums = new int[nums.length];
        cumulativeNums[0] = nums[0];
        for(int i = 1; i< nums.length; i++){
            cumulativeNums[i] = cumulativeNums[i-1] + nums[i];
        }

        for(int i = 0; i<nums.length; i++){
            int left = 0;
            int right = 0;

            if(i == 0){
               right = cumulativeNums[nums.length -1] - cumulativeNums[0];
            }
            else if(i == nums.length-1){
               left = cumulativeNums[nums.length -2];
            }
            else{
                left = cumulativeNums[i-1];
                right = cumulativeNums[nums.length -1] - cumulativeNums[i];
            }
            if(left == right){
                return i;
            }
        }
        return -1;
    }
}
