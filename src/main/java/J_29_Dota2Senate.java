import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class J_29_Dota2Senate {

    public static void main(String[] args) {

        System.out.println(predictPartyVictory("RDD"));

    }
    public static String predictPartyVictory(String senate) {
        Deque<Integer> dPos = new ArrayDeque<>();
        Deque<Integer> rPos = new ArrayDeque<>();
        int n = senate.length();

        for(int i = 0; i< senate.length(); i++){
            if(senate.charAt(i) == 'D'){
                dPos.addLast(i);
            }
            else{
                rPos.addLast(i);
            }
        }

        //perform the rounds
        while(!dPos.isEmpty() && !rPos.isEmpty()){
            int d = dPos.pop();
            int r = rPos.pop();
            if(r < d){
                rPos.addLast(r + n);
            }
            else{
                dPos.addLast(d + n);
            }
        }
        return dPos.isEmpty() ? "Radiant" : "Dire";
    }
}
