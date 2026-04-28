public class J_X_MaximalBS {


    public static void main(String[] args) {

        J_X_MaximalBS a = new J_X_MaximalBS();
        int[] arr = new int[]{1,2,2,2,2,3,4,4,4,4,5};
        System.out.println(a.maximalBS(2, arr));
        System.out.println(a.minimalBS(2, arr));

    }

    private int maximalBS(int target, int[] arr) {
        int left = 0;
        int right = arr.length -1;
        int index = -1;

        while(left <= right){

            int mid = left + (right - left) /2;

            if(arr[mid] == target){
                index = mid;
                left = mid+1;
            }
            else if (arr[mid] < target){
                left = mid +1;
            }
            else if (arr[mid] > target){
                right = mid -1;
            }

        }

        return index;
    }

    private int minimalBS(int target, int[] arr) {
        int left = 0;
        int right = arr.length -1;
        int index = -1;

        while(left <= right){
            int mid = left + (right - left) /2;

            if(arr[mid] == target){
                index = mid;
                right = mid-1;
            }
            else if (arr[mid] < target){
                left = mid +1;
            }
            else{
                right = mid-1;
            }
        }

        return index;
    }
}
