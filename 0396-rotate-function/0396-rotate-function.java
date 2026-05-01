class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int firstSum = 0;
        for(int i = 0; i < n; i++){
            firstSum += i * nums[i];
        }

        int totalSum = Arrays.stream(nums).sum();
        int maxi = Integer.MIN_VALUE;
        for(int i = n-1; i >= 0; i--){
            firstSum += totalSum - (n * nums[i]);
            maxi = Math.max(maxi, firstSum);
        }

        return maxi;
    }
}