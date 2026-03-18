import java.util.PriorityQueue;

public class J_53_CostToHireWorkers {

    public static void main(String[] args) {
        J_53_CostToHireWorkers a = new J_53_CostToHireWorkers();
        System.out.println(a.totalCost(new int[]{17,12,10,2,7,2,11,20,8}, 3,4));
        /**
         * Left = 18,64,12,21,21,78,36,58,88,58,99,26,92,91,53,10,24,25,20,92,73,63,51
         * Right = 65,87,6,17,32,14,42,46,65,43,9,75
         * k1 = 6R
         * k2 = 9R
         * k3 = 10L
         * k4 = 12L
         * k5 = 14R
         * k6 = 17R
         * k7 = 18L
         * k8 = 20L
         * k9 = 21L
         * k10 = 21L
         * k11 = 24L
         * k12 = 25L
         * k13 = 26L
         */
    }
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Long> pqf = new PriorityQueue();
        PriorityQueue<Long> pqb = new PriorityQueue();
        int length = costs.length;
        int left = 0;
        int right = length -1;
        long sum = 0;
        while (k > 0) {
            while(pqf.size() < candidates && left <= right){
                pqf.add((long)costs[left]);
                left++;
            }
            while(pqb.size() < candidates && left <= right){
                pqb.add((long)costs[right]);
                right--;
            }
            long front = pqf.size() > 0 ? pqf.peek() : Integer.MAX_VALUE;
            long back = pqb.size() > 0 ? pqb.peek() : Integer.MAX_VALUE;
            if (front <= back) {
                pqf.poll();
                sum += front;
            } else {
                pqb.poll();
                sum += back;
            }
            k--;
        }

        return sum;
    }
}
