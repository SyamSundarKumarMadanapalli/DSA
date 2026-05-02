class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        int n = nums.length;
        double maxAvg = Integer.MIN_VALUE;

        for (int i = 0; i < k; i++){
            sum += nums[i];
        }
        maxAvg = (double)sum / k;

        for(int i = k; i < n; i++){
            sum -= nums[i - k];
            sum += nums[i];
            double avg = (double)sum / k;
            maxAvg = Math.max(maxAvg, avg);
        }

        return maxAvg;
    }
}