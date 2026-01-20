public class J_13_ContainerMostWater {


    public static void main(String[] args) {

        System.out.println(mostWater(new int[]{5,1,2,3,4,5,9}));

    }

    private static int mostWater(int[] arr){

        int left = 0;
        int right = arr.length-1;
        int max = 0;

        while(left <=right){

            int volume = Math.min(arr[left], arr[right]) * (right - left);
            max = Math.max(max, volume);
            if(left < right){
                left++;
            }
            else{
                right--;
            }
        }
        return max;

    }
}
