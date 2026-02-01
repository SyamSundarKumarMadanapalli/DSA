class Solution {
public:
    int minimumCost(vector<int>& nums) {
        int ans=nums[0];
        int mini = INT_MAX, ind=-1;
        for(int i=1;i<nums.size();i++){
            if(nums[i]<mini){
                mini = nums[i];
                ind = i;
            }
        }
        ans+=mini;
        mini=INT_MAX;

        for(int i=1;i<nums.size();i++){
            if(nums[i]< mini && i!=ind){
                mini = nums[i];
            }
        }

        return ans+mini;
    }
};