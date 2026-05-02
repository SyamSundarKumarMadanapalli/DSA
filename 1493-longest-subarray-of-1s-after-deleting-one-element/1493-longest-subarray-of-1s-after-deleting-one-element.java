class Solution {
    public int longestSubarray(int[] nums) {
        int l = 0, r = 0;
        int extra = 0;
        int maxLen = 0;

        while(r < nums.length){
            if(nums[r] != 1){
                extra++;
            }

            if(extra > 1){
                if(nums[l] != 1){
                    extra--;
                }
                l++;
            }

            if(extra <= 1){
                maxLen = Math.max(maxLen, r - l);
            }
            r++;
        }

        return maxLen;
    }
}