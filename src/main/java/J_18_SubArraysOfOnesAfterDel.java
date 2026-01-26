public class J_18_SubArraysOfOnesAfterDel {


    public static void main(String[] args) {

        System.out.println(longestSubarray(new int[]{0,1,0,1,0,0,0}));
        System.out.println(longestSubarray(new int[]{1,1,1,0,1,0}));

    }

    public static int longestSubarray(int[] nums) {
        int left = 0;
        int right = 0;
        int zeroCount = 0;
        int oneCount = 0;
        int max = 0;
        boolean oneDeleted = false;

        while(right < nums.length){

            while(zeroCount <=1 && right < nums.length){

                if(nums[right] == 0){
                    if(zeroCount == 1){
                        break;
                    }
                    oneDeleted = true;
                    zeroCount +=1;
                    right+=1;
                }
                else{
                    right+=1;
                    oneCount+=1;
                }
            }
            max = Math.max(max, oneCount);
            while(left <= right && zeroCount >=1){
                if(nums[left] == 0){
                    zeroCount-=1;
                    left+=1;
                }
                else{
                    oneCount-=1;
                    left+=1;
                }
            }
        }
        return oneDeleted ? max : max -1;
    }
}
