class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        int[][] vis = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                vis[i][j] = 1;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[] {i, j, 0});
                    vis[i][j] = 2;
                }
            }
        }

        int time = 0;
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            int[] front = q.poll();
            int row = front[0];
            int col = front[1];
            int t = front[2];

            for (int i = 0; i < 4; i++) {
                int nrow = row + dr[i];
                int ncol = col + dc[i];

                if (nrow < m && nrow >= 0 && ncol >= 0 && ncol < n
                        && vis[nrow][ncol] != 2 && grid[nrow][ncol] == 1) {
                    q.offer(new int[] {nrow, ncol, t + 1});
                    vis[nrow][ncol] = 2;
                }
            }
            time = Math.max(time, t);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && vis[i][j] != 2) {
                    return -1;
                }
            }
        }

        return time;
    }
}