public class J_57_KokoBananas {

    public static void main(String[] args) {

        J_57_KokoBananas a = new J_57_KokoBananas();
        System.out.println(a.minEatingSpeed(new int[]{312884470}, 312884469));

    }

    public int minEatingSpeed(int[] piles, int h) {

        int max = 0;
        int min = 0;

        for(int i = 0; i<piles.length; i++){
            max = Math.max(max, piles[i]);
        }
        int result = max;
        while(max - min > 1){

            int mid = min + (max - min) /2;

            int hours = 0;

            //hours represents total hours required to eat all bananas
            for(int i : piles){
                hours = hours + (int)Math.ceil(((double) i / mid));
            }

            //eating too slow
            if(hours - h > 0){
                min = mid;
            }
            //eating too fast or perfect
            else if (hours - h <= 0){
                max = mid;
                result = mid;
            }
        }

        return result;

    }

}
