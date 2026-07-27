class Solution {
public:
    int maxProduct(vector<int>& nums) {
        int firstMax = -1;
        int secondMax = -1;

        for(auto it : nums){
            if(it > firstMax){
                secondMax = firstMax;
                firstMax = it;
            }else if(it > secondMax){
                secondMax = it;
            }
        }

        return (firstMax - 1) * (secondMax - 1);
    }
};