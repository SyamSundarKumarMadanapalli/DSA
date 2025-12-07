class Solution {
public:
    int countOdds(int low, int high) {
        int n = high - low;
        if(n & 1)return (n+1) >> 1;
        return (low & 1) > 0 ? (n >> 1) + 1 : n >> 1; 
    }
};