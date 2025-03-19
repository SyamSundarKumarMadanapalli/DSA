class Solution {
public:
    int minOperations(vector<int>& nums) {
        int count = 0;
        for (int i = 0; i < nums.size() - 2; i++) {
            if (nums[i] == 0) {
                count++;
                nums[i] = !nums[i];
                nums[i + 1] = !nums[i + 1];
                nums[i + 2] = !nums[i + 2];
            }
        }
        int sum = accumulate(nums.begin(), nums.end(), 0);
        if (sum == nums.size())
            return count;
        return -1;
    }
};