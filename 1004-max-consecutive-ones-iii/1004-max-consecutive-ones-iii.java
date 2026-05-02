class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        
        int l = 0, r = 0;     
        int maxlen = 0; 
        int zeroes = 0;       
        
        while(r < n) {
            if(nums[r] == 0) 
                zeroes++;
         
            if(zeroes > k) {
                if(nums[l] == 0) 
                    zeroes--; 
                l++;    
            }

            if(zeroes <= k) {
                maxlen = Math.max(maxlen, r - l + 1);
            }

            r++;
        }

        return maxlen;
    }
}