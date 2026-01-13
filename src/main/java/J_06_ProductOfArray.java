import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class J_06_ProductOfArray {


    public static void main(String[] args) {

        int[] arr1 = {1, 2, 3, 4};
        System.out.println(Arrays.toString(optimisedProductOfArrayExceptSelf(arr1)));

    }

    private static int[] productOfArrayExceptSelf(int[] arr){

        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];
        int[] suffix = new int[arr.length];
        suffix[arr.length-1] = arr[arr.length-1];

        for(int i=1; i<arr.length; i++){
            prefix[i] = prefix[i-1] * arr[i];
        }
        for(int i=arr.length-2; i>=0; i--){
            suffix[i] = arr[i] * suffix[i+1];
        }

        int[] result = new int[arr.length];
        //for first value = the suffix of i + 1
        result[0] = suffix[1];
        //for last value = the prefix of i -1
        result[result.length-1] = prefix[result.length-2];

        for(int i=1; i<arr.length-1; i++){
            result[i] = prefix[i-1] * suffix[i+1];
        }

        return result;
    }

    private static int[] optimisedProductOfArrayExceptSelf(int[] arr){

        //define our result array
        int[] result = new int[arr.length];

        //loop over the prefix and populate one forward
        result[1] = arr[0];
        for(int i=1; i<arr.length-1; i++){
            result[i+1] = result[i] * arr[i];
        }

        //loop over the postfix and populate one back
        int postfix = arr[arr.length-1];
        for(int i = arr.length-2; i>0; i--){
            result[i] = result[i] * postfix;
            postfix = postfix * arr[i];
        }
        result[0] = postfix;

        return result;
    }
}
