import java.util.Arrays;
import java.util.Stack;

public class J_26_AsteroidCollision {

    public static void main(String[] args) {

//        System.out.println(Arrays.toString(asteroidCollision(new int[]{10, 5, -5})));
        System.out.println(Arrays.toString(asteroidCollision(new int[]{-2, -1, 3, 3, 2})));
    }
    public static int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {

            if (stack.isEmpty() || asteroid > 0) {
                stack.add(asteroid);
            } else {
                while (true) {
                    int peek = stack.peek();
                    if (peek > -asteroid) {
                        break;
                    } else if (peek == -asteroid) {
                        stack.pop();
                        break;
                    }
                    else if(peek < 0){
                        stack.add(asteroid);
                        break;
                    }
                    else {
                        stack.pop();
                        if(stack.isEmpty()){
                            stack.add(asteroid);
                            break;
                        }
                    }
                }
            }
        }
        int[] result = new int[stack.size()];
        for(int i = 0; i< result.length; i++){
            int item = stack.pop();
            result[result.length -1 - i] = item;
        }
        return result;
    }

}
