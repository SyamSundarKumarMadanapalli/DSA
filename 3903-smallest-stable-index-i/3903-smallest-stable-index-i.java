class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] mins = new int[n];

        mins[n - 1] = nums[n - 1];

        for(int i = n - 2; i >= 0; i--){
            mins[i] = Math.min(mins[i + 1], nums[i]);
        }

        int maxi = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            maxi = Math.max(maxi, nums[i]);

            if(maxi - mins[i] <= k) return i;
        }

        return -1;
    }
}