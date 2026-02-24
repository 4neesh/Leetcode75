import java.util.*;

public class J_47_EvaluateDivision {


    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        List<String> a = new ArrayList<>();
        a.add("x1");
        a.add("x2");
        List<String> b = new ArrayList<>();
        b.add("x2");
        b.add("x3");
        List<String> c = new ArrayList<>();
        c.add("x1");
        c.add("x4");
        List<String> d = new ArrayList<>();
        d.add("x2");
        d.add("x5");
        equations.add(a);
        equations.add(b);
        equations.add(c);
        equations.add(d);

        double[] values = {3.0, 0.5, 3.4, 5.6};
        List<List<String>> queries = new ArrayList<>();
        List<String> qa = new ArrayList<>();
        qa.add("x2");
        qa.add("x4");
        List<String> qb = new ArrayList<>();
        qb.add("x1");
        qb.add("x5");
        List<String> qc = new ArrayList<>();
        qc.add("x1");
        qc.add("x3");
        List<String> qd = new ArrayList<>();
        qd.add("x5");
        qd.add("x5");
        List<String> qe = new ArrayList<>();
        qe.add("x5");
        qe.add("x1");
        List<String> qf = new ArrayList<>();
        qf.add("x3");
        qf.add("x4");
        List<String> qg = new ArrayList<>();
        qg.add("x4");
        qg.add("x3");
        List<String> qh = new ArrayList<>();
        qh.add("x6");
        qh.add("x6");
        List<String> qi = new ArrayList<>();
        qi.add("x0");
        qi.add("x0");
        queries.add(qa);
        queries.add(qb);
        queries.add(qc);
        queries.add(qd);
        queries.add(qe);
        queries.add(qf);
        queries.add(qg);
        queries.add(qh);
        queries.add(qi);

        System.out.println(Arrays.toString(calcEquation(equations, values, queries)));
    }

    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        double[] result = new double[queries.size()];

        Map<String, Map<String, Double>> graph = new HashMap<>();
        for(int i = 0; i< equations.size(); i++){
            String numerator = equations.get(i).get(0);
            String denominator = equations.get(i).get(1);
            graph.computeIfAbsent(numerator, k ->  new HashMap<>()).put(denominator, values[i]);
            graph.computeIfAbsent(denominator, k -> new HashMap<>()).put(numerator, 1/values[i]);
        }

        for(int i = 0; i<queries.size(); i++){
            String numerator = queries.get(i).get(0);
            String denominator = queries.get(i).get(1);
            double equationValue = dfs(graph, numerator, denominator, new HashSet<>(), 1.0);
            result[i] = equationValue;
        }

        return result;
    }

    private static double dfs(Map<String, Map<String, Double>> graph, String current, String target, Set<String> visited, double currentVal){
        double result = -1;
        //base cases

        if(!graph.containsKey(current) || !graph.containsKey(target)){
            result = -1;
        }
        else if(current.equals(target)){
            result = 1;
        }
        else if(graph.get(current).containsKey(target)){
            result = currentVal * graph.get(current).get(target);
        }
        else {
            //recursiveCase
            visited.add(current);
            for (String key : graph.get(current).keySet()) {
                if (!visited.contains(key)) {
                    result = dfs(graph, key, target, visited, currentVal * graph.get(current).get(key));
                    if(result != -1){
                        return result;
                    }
                }
            }

        }
        return result;
    }
}