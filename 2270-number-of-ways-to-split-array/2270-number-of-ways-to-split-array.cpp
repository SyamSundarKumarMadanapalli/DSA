class Solution {
public:
    int waysToSplitArray(vector<int>& nums) {
        int sum=0;
        for(auto it: nums){
            sum+=it;
        }

        int cnt=0,summ=0;
        for(int i=0;i<nums.size()-1;i++){
            summ+=nums[i];
            int diff=sum-summ;
            if(summ>=diff)cnt++;
        }
        return cnt;
    }
};