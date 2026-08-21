class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 0) return 0;
        if (n == 1) return nums[0];

        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            if (i != 0) arr1.add(nums[i]);
            if (i != n - 1) arr2.add(nums[i]);
        }

        return Math.max(solve(arr1), solve(arr2));
    }


    public int solve(List<Integer> arr) {
        int m = arr.size();
        int[] house = new int[m + 1];

        house[0] = 0;
        house[1] = arr.get(0);

        for(int i = 2; i <= m; i++){
            int take = arr.get(i - 1) + house[i - 2];
            int notTake = house[i - 1];

            house[i] = Math.max(take, notTake);
        }

        return house[m];
    }
}