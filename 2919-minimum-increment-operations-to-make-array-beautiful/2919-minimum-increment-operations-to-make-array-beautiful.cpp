class Solution {
public:
    long long minIncrementOperations(vector<int>& nums, int k) {
        long long n=nums.size(),ans=0;
        for(int i=1;i<n-1;i++){
            long long c = max({nums[i-1],nums[i],nums[i+1]});
            if(c<k){
                int c1 =  k - c;
                nums[i-1]+=c1;
                nums[i]+=c1;
                nums[i+1]+=c1;
                ans += c1;
            }
        }
        return ans;
    }
};