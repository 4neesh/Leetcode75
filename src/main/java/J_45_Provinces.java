import java.util.HashSet;
import java.util.Set;

public class J_45_Provinces {

    public static void main(String[] args) {

        J_45_Provinces main = new J_45_Provinces();
        int[][] isConn = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(main.findCircleNum(isConn));
    }

    public int findCircleNum(int[][] isConnected) {

        int provinces = 0;
        int cities = isConnected.length;
        Set<Integer> visitedCities = new HashSet<>();

        for(int i = 0; i<cities; i++){
            if(!visitedCities.contains(i)){
                provinces++;
                visitedCities = dfs(isConnected, visitedCities, i);
            }
        }

        return provinces;
    }

    public Set<Integer> dfs(int[][] isConnected, Set<Integer> visitedCities, int city){
        //loop over the cities and perform dfs
        //add to visitedCities
        int[] cities = isConnected[city];
        for(int i = 0; i< cities.length; i++){
            if(i != city){
                if(cities[i] == 1 && !visitedCities.contains(i)){
                    visitedCities.add(i);
                    visitedCities = dfs(isConnected, visitedCities, i);
                }
            }
        }
        return visitedCities;
    }
}
