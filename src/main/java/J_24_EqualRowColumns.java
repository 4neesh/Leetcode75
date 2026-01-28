import java.util.HashMap;
import java.util.Map;

public class J_24_EqualRowColumns {

    public static void main(String[] args) {

        System.out.println(equalRowColumns(new int[][]{{3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}}));

    }
    private static int equalRowColumns(int[][] grid){

        int size = grid.length;
        Map<Integer, Integer> valueCountMap = new HashMap<>();
        int result = 0;
        //construct integer and add to count for all rows
        for(int i = 0; i<size; i++){
            StringBuilder value = new StringBuilder();
            for(int j = 0; j<size; j++){
                value.append(grid[i][j]);
            }
            valueCountMap.merge(Integer.parseInt(value.toString()),1, (old, newer) -> old +1);
        }

        //construct integer for columns
        for(int j=0; j<size; j++){
            StringBuilder value = new StringBuilder();
            for(int i =0; i<size; i++){
                value.append(grid[i][j]);
            }
            Integer colVal = Integer.parseInt(value.toString());
            result = valueCountMap.containsKey(colVal) ? result + valueCountMap.get(colVal) : result;
        }

        return result;
    }
}
