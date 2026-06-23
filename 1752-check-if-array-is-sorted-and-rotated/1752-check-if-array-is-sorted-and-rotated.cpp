class Solution {
public:
    bool check(vector<int>& nums) {
        int decrements = 0;
        int n = nums.size();
        for(int i = 0; i < n - 1; i++){
            if(nums[i+1] < nums[i]) decrements++;
        }

        if(decrements == 1) return nums[0] >= nums[n - 1] ? true : false;
        return decrements > 1 ? false : true;
    }
};