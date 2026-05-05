class Solution {
    private int changes = 0;

    private void dfs(Map<Integer, List<int[]>> adj, int city, boolean[] visited){
        visited[city] = true;

        for (int[] neighbor : adj.getOrDefault(city, Collections.emptyList())) {
            int nextCity = neighbor[0];
            int needsReverse = neighbor[1];

            if (!visited[nextCity]) {
                changes += needsReverse;
                dfs(adj, nextCity, visited);
            }
        }
    }


    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<int[]>> adj = new HashMap<>();

        for(int[] con : connections){
            adj.computeIfAbsent(con[0], k -> new ArrayList<>()).add(new int[] {con[1], 1});
            adj.computeIfAbsent(con[1], k -> new ArrayList<>()).add(new int[] {con[0], 0});
        }

        boolean[] visited = new boolean[n];
        dfs(adj, 0, visited);

        return changes;
    }
}