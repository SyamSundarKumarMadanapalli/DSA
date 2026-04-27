class Solution {
    int[][][] memo = new int[101][101][201];

    public boolean dfs(int x, int y, int state, int n, int m, char[][] grid) {
        if(memo[x][y][state] != -1) {
            return memo[x][y][state] == 1;
        }

        int remain = (n - 1 - x) + (m - 1 - y);

        if(state > remain) return false;

        if(x == n-1 && y == m-1) {
            memo[x][y][state] = (state == 0 ? 1 : 0);
            return state == 0;
        }

        if(x + 1 < n){
            int nextState = state + (grid[x+1][y] == ')' ? -1 : 1);
            if(nextState >= 0 && dfs(x+1, y, nextState, n, m, grid)){
                memo[x][y][state] = 1;
                return true;
            }
        }

        if (y + 1 < m) {
            int nextState = state + (grid[x][y + 1] == ')' ? -1 : 1);
            if (nextState >= 0 && dfs(x, y + 1, nextState, n, m, grid)) {
                memo[x][y][state] = 1;
                return true;
            }
        }

        memo[x][y][state] = 0;
        return false;
    }

    public boolean hasValidPath(char[][] grid) {
        int n = grid.length, m = grid[0].length;

        if((n + m - 1) % 2 == 1) return false;
        if(grid[0][0] == ')' || grid[n-1][m-1] == '(') return false;

        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }

        return dfs(0, 0, 1, n, m, grid);
    }
}