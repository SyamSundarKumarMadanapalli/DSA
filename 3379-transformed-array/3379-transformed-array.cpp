class Solution {
public:
    vector<int> constructTransformedArray(vector<int>& nums) {
        int n=nums.size(), ind=0;
        vector<int>result(n,0);

        for(int i=0; i<n; i++){
            int val = nums[i]%n;
            if(val > 0){
                ind = (i+val)%n;
                result[i]=nums[ind];
            }else if(val < 0){
                ind = (n + i + val)%n;
                result[i] = nums[ind];
            }else{
                result[i]=nums[i];
            }
        }    

        return result;
    }
};