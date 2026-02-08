import java.util.Stack;

public class J_27_DecodeString {

    public static void main(String[] args) {

        System.out.println(decodeString("3[a2[c]]"));
    }

    public static String decodeString(String s){

        int index = 0;
        String res = "";
        Stack<Integer> countStack = new Stack<>();
        Stack<String> letterStack = new Stack<>();

        while(index < s.length()){

            if(Character.isDigit(s.charAt(index))){
                int count = 0;
                while(Character.isDigit(s.charAt(index))){
                    count = 10 * count + (s.charAt(index) - '0');
                    index++;
                }
                countStack.add(count);
            }
            else if(s.charAt(index) == '[') {
                letterStack.add(res);
                res = "";
                index++;
            }
            else if(s.charAt(index) == ']'){
                StringBuilder temp = new StringBuilder(letterStack.pop());
                int count = countStack.pop();
                for(int i = 0; i< count; i++){
                    temp.append(res);
                }
                res = temp.toString();
                index++;
            }
            else{
                res += s.charAt(index);
                index++;
            }

        }

        return res;
    }
}
