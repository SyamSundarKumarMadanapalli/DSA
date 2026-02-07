class Solution {
public:
    int minPairSum(vector<int>& nums) {
        int n= nums.size();
        int maxi= INT_MIN;
        sort(nums.begin(), nums.end());
        for(int i=0; i<n/2;i++){
            if(maxi < nums[i] + nums[n-i-1]){
                maxi = nums[i] + nums[n-i-1];
            }
        }
        return maxi;
    }
};