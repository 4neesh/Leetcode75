import java.util.ArrayList;
import java.util.List;

public class J_59_CombinationSumThree {

    public static void main(String[] args) {

        J_59_CombinationSumThree a = new J_59_CombinationSumThree();
        System.out.println(a.combinationSum3(3, 9));
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> current = new ArrayList<>();
        this.combine(new ArrayList<>(), k, n, 0, current);
        return current;
    }

    private void combine(List<Integer> answer, int k, int n, int start, List<List<Integer>> current){

        //base case
        if(k == 0 && n == 0){
            current.add(List.copyOf(answer));
            return;
        }
        //recursion
        for(int i = start+1; i<10; i++){
            //short circuit
            if(n - i < 0 || k < 1){
                break;
            }
            answer.add(i);
            combine(answer, k - 1, n-i, i, current);
            answer.removeLast();
        }
    }
}
