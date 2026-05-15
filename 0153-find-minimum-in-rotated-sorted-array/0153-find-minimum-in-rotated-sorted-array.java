class Solution {
    public int findMin(int[] nums) {
        
        int start = 0; 
        int end = nums.length - 1;
        int ans = Integer.MAX_VALUE;

        if(end == 0) return nums[0];

        while(start <= end){
            int mid = (end - start) / 2 + start;

            if(nums[start] <= nums[end]) {
                ans = Math.min(nums[start], ans);
                break;
            }

            if(nums[mid] >= nums[start]) {
                ans = Math.min(ans, nums[start]);
                start = mid + 1;
            }
            else {
                ans = Math.min(nums[mid], ans);
                end = mid - 1;
            }
        }

        return ans;
    }
}