class Solution {
    private void dfs(List<List<Integer>> rooms, boolean[] visited, int room){
        visited[room] = true;

        for(int r : rooms.get(room)){
            if(!visited[r]){
                dfs(rooms, visited, r);
            }
        }
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];

        dfs(rooms, visited, 0);

        for(boolean isVisited : visited){
            if(!isVisited){
                return false;
            }
        }

        return true;
    }
}