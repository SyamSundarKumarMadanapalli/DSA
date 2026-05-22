class Solution {
    public int search(int[] nums, int target) {
        int high = nums.length - 1;
        int low = 0;

        while(low <= high){
            int mid = (high - low) / 2 + low;

             if (nums[mid] == target) return mid;

            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } 

            else { 
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
}