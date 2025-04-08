class Solution {
public:
    int minimumOperations(vector<int>& nums) {
        unordered_set<int>s;
        for(int i=nums.size()-1;i>=0;i--){
            if(s.find(nums[i])!=s.end()){
                int cnt=(i+1)/3;
                return (i+1)%3==0 ? cnt :cnt+1;
            }
            s.insert(nums[i]);
        }
        return 0;
    }
};