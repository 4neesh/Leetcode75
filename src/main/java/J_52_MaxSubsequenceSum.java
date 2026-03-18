import java.util.Arrays;
import java.util.PriorityQueue;

public class J_52_MaxSubsequenceSum {

    public static void main(String[] args) {

        J_52_MaxSubsequenceSum a =  new J_52_MaxSubsequenceSum();
        a.maxScore(new int[]{2,1,14,12}, new int[]{11, 7, 13, 6}, 3);
    }

    public long maxScore(int[] nums1, int[] nums2, int k) {
        long maxSum = 0;
        long currentSum = 0;
        Integer[] index = new Integer[nums2.length];

        for(int i = 0; i<nums2.length; i++){
            index[i] = i;
        }

        Arrays.sort(index, (a,b) -> Integer.compare(nums2[b], nums2[a]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i< nums1.length; i++){
            int idx = index[i];
            pq.add(nums1[idx]);
            currentSum += nums1[idx];

            if(pq.size() > k){
               currentSum -= pq.poll();
            }
            if(pq.size() == k){
                maxSum = Math.max(maxSum, currentSum * nums2[idx]);
            }

        }
        //iterate through the nums1 and nums2 indeix

        //update the sum
        //update the nums2 value
        //use a priorityQueue to determine smallest value each time
        //Update max

        return maxSum;
    }
}
