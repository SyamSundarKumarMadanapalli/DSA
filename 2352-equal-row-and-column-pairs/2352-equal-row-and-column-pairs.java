class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;

        Map<String, Integer> mp = new HashMap<> ();
        for(int i = 0; i < n; i++){
            String key = Arrays.toString(grid[i]);
            mp.put(key, mp.getOrDefault(key, 0) + 1);
        }

        int count = 0;
        for(int j = 0; j < n; j++){

            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = grid[i][j];
            }

            String key = Arrays.toString(arr);
            count += mp.getOrDefault(key, 0);
        }

        return count;
    }
}