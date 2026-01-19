public class J_12_StringCompression {


    public static void main(String[] args) {

        int a = compressString(new char[]{'a','a','b','b'});
        int b = compressString(new char[]{'a','a','a','b'});
        int c = compressString(new char[]{'a','a','a','a'});

    }

    private static int compressString(char[] s){
        int index = 0;
        int start = 0;

        //loop through the letters while the next character same as start
        //when we get to the end or the character is not the same, update the index and add the end - start
        while(start < s.length){
            int end = start;
            while(end < s.length && s[end] == s[start]){
                end++;
            }
            int count = end - start;
            s[index++] = s[start];
            if(count >= 2){
                char[] countArr = Integer.toString(end - start).toCharArray();
                for(char c: countArr){
                    s[index++] = c;
                }
            }
            start += count;
        }
        return index;
    }
}
