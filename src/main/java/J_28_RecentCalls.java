import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class J_28_RecentCalls {

    public static void main(String[] args) {

        RecentCounter rc = new RecentCounter();
        System.out.println(rc.ping(1));
        System.out.println(rc.ping(100));
        System.out.println(rc.ping(3000));
        System.out.println(rc.ping(3002));

    }

}
class RecentCounter {

    private int counter;
    private Deque<Integer> queue = new ArrayDeque();
    public RecentCounter() {
        this.counter = 0;
    }

    public int ping(int t) {

        this.counter++;
        queue.addLast(t);
        while(!queue.isEmpty() && queue.getFirst() < t - 3000){
            queue.removeFirst();
            this.counter--;
        }
        return counter;
    }
}