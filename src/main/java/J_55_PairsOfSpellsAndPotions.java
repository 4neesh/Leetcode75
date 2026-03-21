import java.util.Arrays;

public class J_55_PairsOfSpellsAndPotions {


    public static void main(String[] args) {

        int[] spells = new int[]{5, 1, 3};
        int[] potions = new int[]{1,2,3,4,5};
        J_55_PairsOfSpellsAndPotions a = new J_55_PairsOfSpellsAndPotions();
        System.out.println(Arrays.toString(a.successfulPairs(spells, potions, 7)));

    }
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        potions = Arrays.stream(potions).sorted().toArray();
        int[] result = new int[spells.length];
        for(int i = 0; i< spells.length; i++){

            int left = 0; int right = potions.length;
            while(left < right){
                int mid = left + (right - left)/2;
                if((long) potions[mid] * spells[i] >= success){
                    right = mid;
                }
                else{
                    left = mid +1;
                }
            }
            result[i] = potions.length - left;
        }
        return result;
    }


}
