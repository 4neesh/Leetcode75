import java.util.*;

public class J_48_NearestExit {


    public static void main(String[] args) {

        J_48_NearestExit a = new J_48_NearestExit();
        char[][] aa = new char[][]{{'+','+','.','+'},{'.','.','.','+'},{'+','+','+','.'}};
        char[][] ab = new char[][]{{'+','.'}};
        System.out.println(a.nearestExit(aa, new int[]{1,2}));
    }

    public int nearestExit(char[][] maze, int[] entrance) {

        int width = maze[0].length;
        int height = maze.length;

        Deque<int[]> toVisit = new ArrayDeque<>();
        toVisit.add(new int[]{entrance[1], entrance[0], 0});
        boolean[][] visited = new boolean[height][width];
        int[][] directions = new int[][]{{0,1},{1,0}, {0,-1},{-1,0}};
        visited[entrance[1]][entrance[0]] = true;

            while(!toVisit.isEmpty()){
            int[] current = toVisit.pop();
            for(int[] direction: directions){
                int newRow = current[1]+direction[0];
                int newCol = current[0]+direction[1];

                if(newRow >= 0 && newRow <width && newCol >=0 && newCol < height) {
                    visited[newCol][newRow] = true;

                    if (maze[newCol][newRow] == '.' && !visited[newCol][newRow]) {
                        if (newRow == 0 || newCol == 0) {
                            return current[2] + 1;
                        } else {
                            toVisit.add(new int[]{newRow, newCol, current[2] + 1});
                        }
                    }
                }
            }

        }
        return -1;
    }
}
