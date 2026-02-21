class Solution {
public:
    bool isSmallPrime(int x) {
        return (x == 2 || x == 3 || x == 5 || x == 7 ||
                x == 11 || x == 13 || x == 17 || x == 19);
    }
    int countPrimeSetBits(int left, int right) {
        int ans=0;
        for(int j=left; j<=right; j++){
            int cnt=0;
            int i = j;
            while(i>1){
                if(i & 1)cnt++;
                i >>= 1;
            }
            if(i==1)cnt++;
            if(isSmallPrime(cnt))ans++;
        }
        return ans;
    }
};