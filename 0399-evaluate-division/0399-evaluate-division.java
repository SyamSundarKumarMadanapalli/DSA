class Solution {
    private double getPathWeight(String start, String end, Set<String> visited, Map<String, Map<String, Double>> graph){
        if(!graph.containsKey(start)){
            return -1.0;
        }

        if(graph.get(start).containsKey(end)){
            return graph.get(start).get(end);
        }

        visited.add(start);

        for(Map.Entry<String, Double> neighbour : graph.get(start).entrySet()){

            if (!visited.contains(neighbour.getKey())) {
                double productWeight = getPathWeight(neighbour.getKey(), end, visited, graph);

                if (productWeight != -1.0)
                    return neighbour.getValue() * productWeight;
            }
        }

        return -1.0;
    }


    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<> ();

        for(int i = 0; i < equations.size(); i++){
            graph.computeIfAbsent(equations.get(i).get(0), k -> new HashMap<>()).put(equations.get(i).get(1), values[i]);
            graph.computeIfAbsent(equations.get(i).get(1), k -> new HashMap<>()).put(equations.get(i).get(0), 1.0/values[i]);
        }

        double[] ans = new double[queries.size()];

        for(int i = 0; i < queries.size(); i++){
            ans[i] = getPathWeight(queries.get(i).get(0), queries.get(i).get(1), new HashSet<>(), graph);
        }

        return ans;
    }
}