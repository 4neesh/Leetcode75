import java.util.HashMap;
import java.util.Map;

public class J_60_TribonacciSequence {

    public static void main(String[] args) {

        J_60_TribonacciSequence a = new J_60_TribonacciSequence();
        System.out.println(a.tribonacci(5));

    }

    public int tribonacci(int n){

        Map<Integer, Integer> memo = new HashMap<>();
        if(n == 0) return 0;
        if (n <=2 ) return 1;
        return tribHelper(n-3, memo) + tribHelper(n-2, memo) + tribHelper(n-1, memo);
    }

    public int tribHelper(int n, Map<Integer, Integer> memo){

        if(memo.containsKey(n)){
            return memo.get(n);
        }
        int result = 0;
        if(n ==1 || n == 2){
            result = 1;
        }
        else if(n > 2){
            result = tribHelper(n-3, memo) + tribHelper(n-2, memo) + tribHelper(n-1, memo);
        }

        memo.put(n, result);
        return result;
    }
}
