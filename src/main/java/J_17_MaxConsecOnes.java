public class J_17_MaxConsecOnes {

    public static void main(String[] args) {

        System.out.println(maxConsecutiveOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2));
        System.out.println(maxConsecutiveOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));

    }

    private static int maxConsecutiveOnes(int[] nums, int k) {

        int count = 0;
        int left = 0;
        int right = 0;
        int max = 0;

        while (right < nums.length) {
            while (count <= k && right < nums.length) {
                if (nums[right] == 0) {
                    if (count == k) {
                        break;
                    } else {
                        right++;
                        count++;
                    }
                }
                else{
                    right++;
                }
            }
            max = Math.max(max, (right - left));

            while (left < right) {
                if (nums[left] == 0) {
                    left++;
                    count--;
                    break;
                } else {
                    left++;
                }
            }
        }


        return max;

    }


}
