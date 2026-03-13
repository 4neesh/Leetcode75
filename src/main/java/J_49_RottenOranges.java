import java.util.ArrayDeque;
import java.util.Deque;

public class J_49_RottenOranges {

    public static void main(String[] args) {
        J_49_RottenOranges a = new J_49_RottenOranges();
        System.out.println(a.orangesRotting(new int[][]{{2,1,1},{1,1,1},{0,1,2}}));

    }
    public int orangesRotting(int[][] grid) {

        Deque<int[]> currentRottenOranges = new ArrayDeque<>();
        int freshOrangeCount = 0;
        int width = grid[0].length;
        int height = grid.length;

        for(int i = 0; i<height; i++){
            for(int j=0; j<width; j++){
                if(grid[i][j] == 1){
                    freshOrangeCount++;
                }
                if(grid[i][j] == 2){
                    int[] rotten = {i, j, 0};
                    currentRottenOranges.add(rotten);
                }
            }
        }
        if(currentRottenOranges.isEmpty() && freshOrangeCount > 0){
            return -1;
        }
        else if(currentRottenOranges.isEmpty()){
            return 0;
        }

        int result = 0;
        int[][] directions = new int[][]{{1,0}, {0,1}, {-1, 0}, {0, -1}};
        if(freshOrangeCount > 0){

            boolean[][] visited = new boolean[height][width];

            while(!currentRottenOranges.isEmpty()){

                int[] current = currentRottenOranges.pop();
                visited[current[0]][current[1]] = true;
                result = Math.max(result, current[2]);

                if(grid[current[0]][current[1]] == 1){
                    freshOrangeCount--;
                }

                for(int[] direction: directions){

                    int newHeight = current[0] + direction[0];
                    int newWidth = current[1] + direction[1];
                    int step = current[2];
                    //if the new cell is rotten or fresh, not visited, add it toCheck
                    if(newWidth >= 0 && newWidth < width
                            && newHeight >= 0 && newHeight < height
                                && !visited[newHeight][newWidth]){

                        if(grid[newHeight][newWidth] == 1 || grid[newHeight][newWidth] == 2){
                            currentRottenOranges.add(new int[]{newHeight, newWidth, step + 1});
                            visited[newHeight][newWidth] = true;
                        }
                    }
                }
            }

        }

        if(freshOrangeCount > 0){
            result = -1;
        }
        return result;
    }
}
