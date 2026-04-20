class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int res = 0; 

        for (int i = n - 1; i >= 0; i--) {
            if (colors[i] != colors[0]) {
                res = Math.max(res, i);
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            if (colors[i] != colors[n - 1]) {
                res = Math.max(res, n - 1 - i);
                break;
            }
        }

        return res;
    }
}