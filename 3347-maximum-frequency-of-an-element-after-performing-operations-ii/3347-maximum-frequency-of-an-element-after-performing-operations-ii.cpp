class Solution {
public:
    int maxFrequency(vector<int>& nums, int k, int numOperations) {
        int max_val=*max_element(nums.begin(),nums.end())+k;
        unordered_map<int,int>freq;
        map<int,int>diff;

        for(int i=0;i<nums.size();i++){
            int left_bound=max(nums[i]-k,0);
            int right_bound=min(nums[i]+k,max_val);
            diff[left_bound]++;
            diff[right_bound+1]--;
            diff[nums[i]]+=0;
            freq[nums[i]]++;
        }
        int result=1;
        int cumSum=0;

        for(auto it=diff.begin();it!=diff.end();it++){
            int target=it->first;
            it->second+=cumSum;

            int targetFreq=freq[target];
            int needConversion=it->second-targetFreq;
            int maxFreq=min(needConversion,numOperations);
            result=max(result, targetFreq+maxFreq);
            cumSum=it->second;
        }
        return result;
    }
};