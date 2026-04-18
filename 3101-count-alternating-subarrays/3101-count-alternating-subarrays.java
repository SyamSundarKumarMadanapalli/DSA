class Solution {
    public long countAlternatingSubarrays(int[] nums) {
        long cnt = 1;
        long ans = 0;

        for(int i = 0; i< nums.length - 1; i++){
            if(nums[i] != nums[i+1]){
                cnt++;
            }else{
                ans += (cnt * (cnt + 1))/2;
                cnt = 1;
            }
        }

        ans += (cnt * (cnt + 1))/2;

        return ans;
    }
}