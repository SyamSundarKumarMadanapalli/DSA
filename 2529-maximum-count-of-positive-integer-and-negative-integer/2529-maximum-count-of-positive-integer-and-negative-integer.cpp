class Solution {
public:
    int maximumCount(vector<int>& nums) {
        int zero=0,neg=0;
        for(int i=0;i<nums.size();i++){
            if(nums[i]==0)zero++;
            else if(nums[i]<0)neg++;
            else break;
        }

        return neg > (nums.size()-neg-zero) ? neg : (nums.size()-neg-zero);
    }
};