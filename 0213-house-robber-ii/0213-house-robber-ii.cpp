class Solution {
public:
    int solve(int ind, int size, vector<int>& nums){
        if(ind == size)return 0;

        int prePrev = 0;
        int prev = nums[ind];

        for(int i = ind + 1; i < size; i++){
            int take = prePrev + nums[i];
            int skip = prev;

            int temp = max(take, skip);

            prePrev = prev;
            prev = temp;
        }

        return prev;
    }

    int rob(vector<int>& nums) {
        if(nums.size() == 1) return nums[0];
        if(nums.size() == 2) return max(nums[0], nums[1]);

        return max(solve(0, nums.size()-1, nums),
                    solve(1, nums.size(), nums));
    }
};