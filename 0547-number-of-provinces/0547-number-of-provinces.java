class Solution {
    private void dfs(int[][] isConnected, boolean[] visited, int city){
        visited[city] = true;
        int n = isConnected.length;

        for (int neighbor = 0; neighbor < n; neighbor++) {
            if (isConnected[city][neighbor] == 1 && !visited[neighbor]) {
                dfs(isConnected, visited, neighbor);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(isConnected, visited, i);
                count++;
            }
        }

        return count;
    }
}