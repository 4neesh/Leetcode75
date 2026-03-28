import java.util.ArrayList;
import java.util.List;

public class J_75_OnlineStockSpan {
    private List<Integer[]> stack;

    public static void main(String[] args) {
        J_75_OnlineStockSpan a = new J_75_OnlineStockSpan();
    }
    public J_75_OnlineStockSpan() {
        this.stack = new ArrayList<>();
    }

    public int next(int price) {
        int span = 1;
        if(this.stack.isEmpty()){
            stack.add(new Integer[]{price, span});
        }
        else{
            //add new item into the list with price and span
            int index = stack.size()-1;
            while(index >= 0 && stack.get(index)[0] <= price){
                int prevSpan = stack.get(index)[1];
                index -= prevSpan;
                span += prevSpan;
            }
            stack.add(new Integer[]{price, span});
        }
        return span;
    }

}