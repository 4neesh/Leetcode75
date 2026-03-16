import java.util.PriorityQueue;
import java.util.Set;

public class J_51_SmallestNumberInInfiniteSet {
    private PriorityQueue<Integer> infiniteSet = new PriorityQueue<>();
    private Set<Integer> remo = null;
    public J_51_SmallestNumberInInfiniteSet() {
        for(int i = 1; i<= 1000; i++){
            infiniteSet.add(i);
            remo.add(i);
        }

    }


    public int popSmallest() {
        if(infiniteSet.size() > 0){

            int removed = infiniteSet.poll();
            remo.remove(removed);
        }
        return 0;
    }

    public void addBack(int num) {
        if(!remo.contains(num)){
            infiniteSet.add(num);
            remo.add(num);
        }
    }
}
