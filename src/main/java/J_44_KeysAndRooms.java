import java.util.*;

public class J_44_KeysAndRooms {
    public static void main(String[] args) {

        J_44_KeysAndRooms main = new J_44_KeysAndRooms();
        List<Integer> a1 = new ArrayList<>();
        List<Integer> a2 = new ArrayList<>();
        List<Integer> a3 = new ArrayList<>();


        List<List<Integer>> b = new ArrayList<>();
        b.add(a1);
        b.add(a2);
        b.add(a3);

        main.canVisitAllRooms(b);

    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        Set<Integer> visitedRooms = new HashSet<>();
        Stack<Integer> roomsToVisit = new Stack<>();
        roomsToVisit.addAll(rooms.getFirst());
        visitedRooms.add(0);

        while(!roomsToVisit.isEmpty()){

            Integer roomVisited = roomsToVisit.pop();
            visitedRooms.add(roomVisited);
            for(Integer room : rooms.get(roomVisited)){
                if(!visitedRooms.contains(room)){
                    roomsToVisit.add(room);
                }
            }
        }
        return visitedRooms.size() == rooms.size();
    }
}
