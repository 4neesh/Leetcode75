import java.util.*;

public class J_46_MoveToZero {


    public static void main(String[] args) {

        int[][] a = {{0,1},{1,3},{2,3},{4,0},{4,5}};
        J_46_MoveToZero main = new J_46_MoveToZero();
        System.out.println(main.movesToZero_bfs(a));
    }

    public int movesToZero_bfs(int[][] connections){

        //we initialise maps to track all relationships
        Map<Integer, List<Integer>> cityToCity = new HashMap<>();
        //and a map to capture who points to who
        Map<Integer, List<Integer>> directConnections = new HashMap<>();
        //we iterate our connections to track all of these (both directions & direct)
        for(int[] connection: connections){
            cityToCity.computeIfAbsent(connection[1], k -> new ArrayList<>()).add(connection[0]);
            directConnections.computeIfAbsent(connection[1], k -> new ArrayList<>()).add(connection[0]);
            cityToCity.computeIfAbsent(connection[0], k -> new ArrayList<>()).add(connection[1]);
        }
        
        //now perform a BFS search on the tree to understand where connections need to be reversed
        int result = 0;
        Set<Integer> visitedCities = new HashSet<>();
        Set<Integer> current = new HashSet<>();
        visitedCities.add(0);
        current.add(0);
        //loop over the nodes connected to 0 and...
        while(!current.isEmpty()) {
            Set<Integer> newCitiesToVisit = new HashSet<>();
            for (Integer city : current) {
                for (Integer neighbour : cityToCity.get(city)) {

                    if (!visitedCities.contains(neighbour)) {
                        if (!directConnections.getOrDefault(city, new ArrayList<>()).contains(neighbour)) {
                            //if those nodes are not directly connected to 0, increment the result
                            result++;
                        }
                        newCitiesToVisit.add(neighbour);
                    }
                }
                visitedCities.add(city);
            }
            current = newCitiesToVisit;
        }

        return result;
    }

    public int movesToZero_dfs(int[][] connections){

        //create a map of connections and direct connections
        Map<Integer, List<Integer>> cityToCity = new HashMap<>();
        Map<Integer, List<Integer>> cityConnections = new HashMap<>();
        //iterate through the map from 0 while there are no more nodes
        for(int[] connection: connections){
            cityToCity.computeIfAbsent(connection[1], k -> new ArrayList<>()).add(connection[0]);
            cityConnections.computeIfAbsent(connection[1], k -> new ArrayList<>()).add(connection[0]);
            cityToCity.computeIfAbsent(connection[0], k -> new ArrayList<>()).add(connection[1]);
        }

        //map contains all the connections and direct connections
        Integer currentCity = 0;
        int result = 0;
        while(currentCity!=null){



        }
        return 0;
    }
}
