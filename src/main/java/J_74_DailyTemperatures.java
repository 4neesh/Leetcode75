import java.util.Stack;

public class J_74_DailyTemperatures {

    public static void main(String[] args) {
        J_74_DailyTemperatures a = new J_74_DailyTemperatures();
    }


    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i<temperatures.length; i++){

            result[i] = 0;
            if(stack.isEmpty() || temperatures[stack.peek()] >= temperatures[i]){
                stack.push(i);
            }
            else{
                while(temperatures[stack.peek()] < temperatures[i]){
                    int index = stack.pop();
                    result[index] = i - index;
                }
                stack.push(i);
            }
        }
        return result;
    }
}
