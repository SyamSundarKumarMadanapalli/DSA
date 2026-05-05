class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
         int n = maze.length;
        int m = maze[0].length;

        int[][] vis = new int[n][m];

        Queue<int[]> q = new LinkedList<>();

        int ans = -1;

        int[] row = {0, 0, -1, 1};
        int[] col = {1, -1, 0, 0};

        boolean flag = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == entrance[0] && j == entrance[1]) {
                    vis[i][j] = 1;
                    q.offer(new int[] {i, j, 0});
                } else if (maze[i][j] == '+') {
                    vis[i][j] = 1;
                }
            }
        }

        while (!q.isEmpty() && flag) {
            int[] front = q.poll();
            int x = front[0];
            int y = front[1];
            int d = front[2];

            for (int k = 0; k < 4; k++) {
                int r = x + row[k];
                int c = y + col[k];

                if (r >= 0 && r < n && c >= 0 && c < m && vis[r][c] == 0) {
                    if (r == 0 || r == n - 1 || c == 0 || c == m - 1) {
                        ans = d + 1;
                        flag = false;
                        break;
                    }
                    q.offer(new int[] {r, c, d + 1});
                    vis[r][c] = 1;
                }
            }
        }

        return ans;
    }
}