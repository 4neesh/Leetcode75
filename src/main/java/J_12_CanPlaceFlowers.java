public class J_12_CanPlaceFlowers {

    public static void main(String[] args) {

        System.out.println(canPlaceFlowers(new int[]{0,1,0,1,0,0,0}, 1));
        System.out.println(canPlaceFlowers(new int[]{0,1,0,1,0,0,1}, 1));
        System.out.println(canPlaceFlowers(new int[]{0,0,0,1,0,0,0}, 2));
        System.out.println(canPlaceFlowers(new int[]{1,1,1,1,1,1,1}, 2));

    }

    private static boolean canPlaceFlowers(int[] flowerbed, int target){

        for(int i = 0; i<flowerbed.length-1; i++){
            if((i == 0 || flowerbed[i-1] == 0) && (i == flowerbed.length -1 || flowerbed[i+1] == 0) && flowerbed[i] == 0){
                flowerbed[i] = 1;
                target -= 1;
                if(target == 0){
                    return true;
                }
            }
        }
        return false;
    }

}
