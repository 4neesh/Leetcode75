public class J_56_PeakElement {

    public static void main(String[] args) {
        J_56_PeakElement a = new J_56_PeakElement();
        System.out.println(a.findPeakElement(new int[]{1,2,3,1}));
    }

    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length -1;
        int result = -1;

        if(nums.length == 1 || nums[0] > nums[1]){
            return 0;
        }
        else if(nums[nums.length-1] > nums[nums.length-2]){
            return nums.length-1;
        }

        while(left < right && result == -1){
            int mid = left + (right - left) /2;
            int before = nums[mid-1];
            int after = nums[mid+1];

            if(before < nums[mid] && nums[mid] > after){
                result = mid;
            }
            else{
                if(before < after){
                    left = mid+1;
                }
                else{
                    right = mid;
                }
            }

        }

        return result;
    }

}
