class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        final int Mod  = 12345;
        int n = grid.length;
        int m = grid[0].length;
        int[][] product = new int[n][m];

        long suffix = 1;
        for(int i = n-1; i>=0; i--){
            for(int j = m-1; j>=0; j--){
                product[i][j] = (int)suffix;
                suffix = (suffix * grid[i][j]) % Mod;
            }
        }

        long prefix = 1;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                product[i][j] =(int) (((long)product[i][j] * prefix) % Mod);
                prefix = (prefix * grid[i][j]) % Mod;
            }
        }

        return product;
    }
}