import util.TreeNode;

import java.util.*;

public class J_Main {

    public static void main(String[] args) {

        J_Main a = new J_Main();
        System.out.println(a.findKthLargest(new int[]{3,2,1,5,6,4}, 2));
    }

    private int findKthLargest(int[] nums, int k){

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i: nums){
            pq.add(i);
        }
        for(int i = 0; i<k-1; i++){
            pq.poll();
        }
        return pq.poll();
    }



}
